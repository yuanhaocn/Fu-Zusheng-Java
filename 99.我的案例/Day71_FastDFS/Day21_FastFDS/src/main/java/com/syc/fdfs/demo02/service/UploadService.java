package com.syc.fdfs.demo02.service;

import org.springframework.stereotype.Service;

import com.syc.fdfs.demo02.util.FastDFSUtils;

@Service
public class UploadService {

	/**
	 * 实现文件上传
	 * @返回类型:String,是服务器中文件的ID=group+filename
	 */
	public String uploadFile(byte[] pic,String name,long size){
		return FastDFSUtils.uploadPic(pic, name, size);
	}
}
