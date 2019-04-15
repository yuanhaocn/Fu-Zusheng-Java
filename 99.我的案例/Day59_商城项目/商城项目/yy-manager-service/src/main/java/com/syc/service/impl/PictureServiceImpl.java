package com.syc.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.syc.common.utils.FtpUtil;
import com.syc.common.utils.IDUtils;
import com.syc.service.PictureService;

/**
 * 实现图片上传
 * 
 * @类名称:PictureServiceImpl
 * @创建人:一一哥
 * @创建时间:2017年11月10日 下午2:10:52
 */
@Service
public class PictureServiceImpl implements PictureService {

	// @Value()作用:根据资源文件的key取值,赋值给该变量.
	@Value("${FTP_HOST}")
	private String FTP_HOST;

	@Value("${FTP_PORT}")
	private int FTP_PORT;

	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;

	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;

	@Value("${BASE_URL}")
	private String BASE_URL;

	@Value("${IMAGE_ACCESS_URL}")
	private String IMAGE_ACCESS_URL;// 图片回显地址.

	@Override
	public Map<String, Object> picUpload(MultipartFile uploadFile) {

		Map<String, Object> map = new HashMap<>();
		try {
			/// home/yyg/uploda/imgs/2017/11/10
			String filePath = new DateTime().toString("yyyy/MM/dd");

			// 获取图片本身的名字,比如p4.jpg
			String filename = uploadFile.getOriginalFilename();

			// 随机生成一个图片文件名,38023890283082
			String imageName = IDUtils.genImageName();

			// 38023890283082.jpg
			imageName += filename.substring(filename.lastIndexOf("."));
			System.out.println("image="+imageName);

			// 图片上传
			boolean result = FtpUtil.uploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, BASE_URL, filePath,
					imageName, uploadFile.getInputStream());

			// 上传失败
			if (!result) {
				map.put("error", 1);
				map.put("message", "上传失败");
				return map;
			}

			// 上传成功
			map.put("error", 0);
			map.put("url", IMAGE_ACCESS_URL + filePath + "/" + imageName);
			return map;

		} catch (IOException e) {
			e.printStackTrace();
			map.put("error", 1);
			map.put("message", "上传失败");
			return map;
		}
	}

}
