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

/*
 * 图片上传的实现类
 */
@Service
public class PictureServiceImpl implements PictureService {

	// @Value注解,给基本类型的数据赋值

	// ftp服务器地址
	@Value("${FTP_HOST}")
	private String FTP_HOST;

	// ftp服务器端口号
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;

	// ftp服务器用户名
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;

	// ftp服务器密码
	@Value("${FTP_PWD}")
	private String FTP_PASSWORD;

	// ftp服务器文件上传到的基本的url
	@Value("${BASE_URL}")
	private String FTP_BASEPATH;

	//图片访问路径
	@Value("${IMAGE_ACCESS_URL}")
	private String IMAGE_ACCESS_URL;

	@Override
	public Map<String,Object> picUpload(MultipartFile uploadFile) {
		Map<String,Object> map=new HashMap<>();
		try {
			//创建图片在服务器端存放的路径  /2017/10/17/
			String filePath = new DateTime().toString("yyyy/MM/dd");
			
			//得到图片本来的名称
			String filename = uploadFile.getOriginalFilename();
			
			//根据当前时间随机生成图片名称
			String imageName = IDUtils.genImageName();
			imageName+=filename.substring(filename.lastIndexOf("."));
			
			//进行文件上传
			boolean result = FtpUtil.uploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, filePath, imageName,
					uploadFile.getInputStream());
			
			System.out.println("FTP_HOST="+FTP_HOST+",port="+FTP_PORT+",name="+FTP_USERNAME+",pwd="+FTP_PASSWORD+",base="+FTP_BASEPATH);
			
			if(!result){//上传结果为false时
				map.put("error", 1);
				map.put("message", "上传失败!");
				return map;
			}
			
			//上传成功时
			map.put("error", 0);
			//注意:此处的filePath+"/"+imageName之间有"/",形成:
			//http://192.168.3.34/imgs/2017/10/17/1508245627731520.png格式!
			map.put("url", IMAGE_ACCESS_URL+filePath+"/"+imageName);
			
			return map;
		} catch (IOException e) {
			e.printStackTrace();
			map.put("error", 1);
			map.put("message", "上传失败!");
			return map;
		}
	}

}
