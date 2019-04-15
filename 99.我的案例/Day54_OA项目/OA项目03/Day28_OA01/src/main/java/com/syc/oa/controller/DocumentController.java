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

@Controller
public class DocumentController {

	@Autowired
	private DocumentService docService;

	// 跳转到文档查询页面
	@RequestMapping("/doc/selectDocument")
	public String showDocument() {
		return "document/document";
	}

	// 跳转到文档添加页面
	@RequestMapping("/doc/addDocument")
	public String showAddDocument() {
		return "document/showAddDocument";
	}

	// 1.实现文件上传;
	// 2.将该文件信息保存到数据库.
	@ResponseBody
	@RequestMapping("/doc/saveDocument")
	public HashMap<String, Object> saveDocument(TbDoc document, MultipartFile file)
			throws IllegalStateException, IOException {

		if (!file.isEmpty()) {// 当文档不等于空的时候,做数据库的添加操作.

			// 获取文件名称
			String filename = file.getOriginalFilename();

			File destFile = new File(getDestDir(), filename);
			// 将客户端上传的文件复制到目标文件中.
			file.transferTo(destFile);

			// 设置文件名
			document.setFilename(filename);

			HashMap<String, Object> map = new HashMap<>();
			// 保存文件信息到数据库
			if (docService.saveDocument(document)) {
				map.put("code", 1);
			} else {
				map.put("code", 0);
			}
			return map;
		}
		return null;
	}

	// 获取服务器上传文件夹的路劲
	private File getDestDir() {
		File file = new File("C:/OA");
		File subFile = new File(file, "files");
		if (!subFile.exists()) {
			subFile.mkdirs();
		}
		return subFile;
	}

	// 查询文档
	@ResponseBody
	@RequestMapping("/docjson")
	public PageBean<TbDoc> selectDocument(String title) {
		return docService.selectDocument(title);
	}

	// 删除文档
	@RequestMapping("/doc/removeDocument")
	public String removeDocument(Integer flag, Integer id,
			@RequestParam(value = "ids[]", required = false) Integer[] ids) throws IOException {
		if (flag == 1) {
			docService.removeOne(id);
			return "document/document";
		} else {
			docService.removeMore(ids);
			return "document/document";
		}
	}

	// 下载文档
	@RequestMapping("/doc/downloadDocument")
	public ResponseEntity<byte[]> downloadDocument(String fileName) {
		try {
			File file = new File(getDestDir(), fileName);
			if (file.exists()) {// 文件存在时才能进行下载
				// 头信息.
				HttpHeaders headers = new HttpHeaders();
				// 改变文件编码
				String downName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
				// 在响应头中设置要下载的文件的描述信息
				headers.setContentDispositionFormData("attachment", downName);
				//设置文件的内容类型是流的形式
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				
				//FileUtils.readFileToByteArray(file):将file变成byte[].
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
