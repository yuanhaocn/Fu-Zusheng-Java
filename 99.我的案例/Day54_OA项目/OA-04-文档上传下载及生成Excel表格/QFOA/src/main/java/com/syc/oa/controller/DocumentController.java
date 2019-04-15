package com.syc.oa.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.syc.oa.domain.TbDoc;
import com.syc.oa.service.DocumentService;
import com.syc.oa.vo.PageBean;

/**
 * 下载中心模块
 */
@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	/**
	 * 跳转到文档查询页面
	 */
	@RequestMapping("/doc/selectDocument")
	public String showDocument() {

		return "document/document";
	}

	/**
	 * 跳转到文档添加页面
	 */
	@RequestMapping("/doc/addDocument")
	public String showAddDocument() {

		return "document/showAddDocument";
	}

	/**
	 * 添加文档
	 */
	@ResponseBody
	@RequestMapping("/doc/saveDocument")
	public Map<String, Object> saveDocument(Integer uid, TbDoc document, MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {

		Map<String, Object> map = new HashMap<>();

		if (!file.isEmpty()) {// 只有当上传的文档不为空的时候,才进行数据库的添加操作

			// 1.实现文件上传
			String fileName = file.getOriginalFilename();

			File destFile = new File(getFileDir(), fileName);
			// 文件的复制
			file.transferTo(destFile);

			// 设置文件名
			document.setFileName(fileName);

			// 2.实现数据库添加
			if (documentService.saveDocument(uid, document)) {
				map.put("code", 1);
			} else {
				map.put("code", 2);
			}
			return map;
		} else {
			return null;
		}
	}

	// 设置文件上传的保存路径
	private File getFileDir() {
		File file = new File("C:/OA");
		File realFile = new File(file, "files");
		if (!realFile.exists()) {
			realFile.mkdirs();
		}
		return realFile;
	}

	/**
	 * 文档查询
	 */
	@ResponseBody
	@RequestMapping("/docJson")
	public PageBean<TbDoc> findDocument(@RequestParam(defaultValue = "") String title) {
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		return documentService.selectDocument(map);
	}

	/**
	 * 删除文档
	 */
	@RequestMapping("/doc/removeDocument")
	public String removeDocument(Integer flag, Integer id,
			@RequestParam(value = "ids[]", required = false) Integer[] ids, HttpServletResponse response)
			throws IOException {
		PrintWriter writer = response.getWriter();

		boolean result;

		if (flag == 1) {// 单个删除
			result = documentService.removeById(id);
			return "redirect:/doc/selectDocument";
		} else {// 批量删除
			result = documentService.removeMore(ids);
		}

		if (result) {
			writer.print("success");
		} else {
			writer.print("error");
		}

		return null;
	}

	/**
	 * 下载文档的实现
	 */
	@RequestMapping("/doc/downloadDocument")
	public ResponseEntity<byte[]> downloadDocument(@RequestParam(defaultValue = "") String fileName) {
		try {
			File file = new File(getFileDir(), fileName);
			if (file.exists()) {// 当存在该文件时才能下载
				// 创建文件响应头
				HttpHeaders headers = new HttpHeaders();
				String downloadFileName;
				downloadFileName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
				// 在响应头中设置要下载的文件的描述信息
				headers.setContentDispositionFormData("attachment", downloadFileName);
				// 把要下载的文件变成流的形式在网上进行传输
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

				//创建响应实体
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
