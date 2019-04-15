package com.syc.oa.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
 * 下载中心模块----文档查询及添加
 * 
 * @类名称:DocumentController
 * @创建人:SYC
 * @创建时间:2017年11月3日 上午9:49:10
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
	 * 添加文档,并且在这个请求方法中实现文件上传
	 */
	@ResponseBody
	@RequestMapping("/doc/saveDocument")
	public Map<String, Object> saveDocument(Integer uid, TbDoc document, MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {

		Map<String, Object> map = new HashMap<>(16);

		// 判断要上传的文件是否为空
		if (!file.isEmpty()) {
			// 实现文件上传

			// 获取要上传的文件原始名称
			String fileName = file.getOriginalFilename();
			// 创建file对象
			File destFile = new File(getDir(), fileName);
			// 文件拷贝,实现上传
			file.transferTo(destFile);

			// 给document的fileName属性赋值
			document.setFileName(fileName);
			// 保存文档
			if (documentService.saveDocument(uid, document)) {
				map.put("code", 1);
			} else {
				map.put("code", 2);
			}
			return map;
		} else {
			// 如果没有选择要上传的文档,则不做任何操作!
			return null;
		}
	}

	// 获取要上传到的文件夹路径
	private File getDir() {
		// 获取文件要上传到的目录
		File file = new File("C:/OA");
		File realPath = new File(file, "files");
		if (!realPath.exists()) {
			realPath.mkdir();
		}
		return realPath;
	}

	/**
	 * 查询文档
	 */
	@ResponseBody
	@RequestMapping("/docJson")
	public PageBean<TbDoc> selectDocument(@RequestParam(defaultValue = "") String title) {
		Map<String, Object> map = new HashMap<>(16);
		map.put("title", title);
		return documentService.findDocument(map);
	}

	/**
	 * 用户删除操作 flag:进行单个删除和批量删除的标记; id:单个删除时的参数; ids:批量删除时的参数; response:用来输出响应信息.
	 */
	@RequestMapping("/doc/removeDocument")
	public String removeDocument(Integer flag, Integer id,
			@RequestParam(value = "ids[]", required = false) Integer[] ids, HttpServletResponse response)
			throws IOException {

		PrintWriter writer = response.getWriter();
		boolean result = false;

		if (flag == 1) {
			// 删除单个对象
			result = documentService.removeOne(id);
			return "redirect:/doc/selectDocument";
		} else {
			// 批量删除
			result = documentService.removeMore(ids);
		}

		// 设置输出到前端页面的数据内容:success和error!
		if (result) {
			writer.print("success");
		} else {
			writer.print("error");
		}

		return null;
	}

	/**
	 * 文档下载 注意:返回值是ResponseEntity,响应实体.
	 */
	@RequestMapping("/doc/downloadDocument")
	public ResponseEntity<byte[]> downloadDocument(String fileName) throws IOException {
		File file = new File(getDir(), fileName);
		if (file.exists()) {// 当文档存在时才下载
			// 创建响应头
			HttpHeaders headers = new HttpHeaders();
			String downloadFileName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");
			// 设置文件下载的描述信息
			headers.setContentDispositionFormData("attachment", downloadFileName);
			// 设置响应的内容是流----二进制
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// 输出响应内容
			//readFileToByteArray():将要下载的文件内容读取成字节数组
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
		}

		return null;
	}

}
