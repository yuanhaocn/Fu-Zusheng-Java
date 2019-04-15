package com.syc.oa.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

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
 * 文档管理模块
 * 
 * @类名称:DocumentController
 * @创建人:一一哥
 * @创建时间:2018年3月6日 上午9:11:54
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
	 * 实现文档查询
	 */
	@RequestMapping("/docJson")
	@ResponseBody
	public PageBean<TbDoc> selectDocument(String title) {

		return documentService.selectDocument(title);
	}

	/**
	 * 删除文档
	 */
	@RequestMapping("/doc/removeDocument")
	public String removeDocument(Integer flag, Integer id,
			@RequestParam(value = "ids[]", required = false) Integer[] ids) {
		if (flag == 1) {
			documentService.removeOne(id);
			// return "document/document";
		} else {
			documentService.removeMore(ids);
		}
		return "document/document";
	}

	/**
	 * 实现文件上传
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@ResponseBody
	@RequestMapping("/doc/saveDocument")
	public HashMap<String, Object> uploadDocument(TbDoc doc, MultipartFile file)
			throws IllegalStateException, IOException {
		if (!file.isEmpty()) {
			String name = file.getName();
			String filename = file.getOriginalFilename();
			System.out.println("name=" + name + ",filename=" + filename);

			File destFile = new File(getFiles(), filename);
			// 实现文件的复制,底层的实现原理就是IO复制读写
			file.transferTo(destFile);

			doc.setFilename(filename);

			HashMap<String, Object> map = new HashMap<>();
			if (documentService.saveDocument(doc)) {
				map.put("code", 1);
			} else {
				map.put("code", 0);
			}
			return map;
		}
		return null;
	}

	// 获取本地存储文件的路径
	private File getFiles() {
		File file = new File("C:/OA");
		File subFile = new File(file, "files");
		if (!subFile.exists()) {
			subFile.mkdirs();
		}
		return subFile;
	}

	/**
	 * 文件的下载
	 */
	@RequestMapping("/doc/downloadDocument")
	public ResponseEntity<byte[]> downloadDocument(String fileName) {
		try {
			// C:/OA/files/qf-logo中文.png
			File file = new File(getFiles(), fileName);
			if (file.exists()) {
				//在浏览器中,以附件的形式来进行文件的下载.
				// 响应头信息对象
				HttpHeaders headers = new HttpHeaders();
				// 改变文件名称的编码
				String downfileName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
				//设置响应头信息---attachment
				headers.setContentDispositionFormData("attachment", downfileName);
				// 设置文件的输出类型--->以流的形式输出
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
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
