package com.syc.commons.utils;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {

	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageClient1 storageClient = null;

	public FastDFSClient(String conf) throws Exception {
		if (conf.contains("classpath:")) {
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
		}

		ClientGlobal.init(conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageClient = new StorageClient1(trackerServer, null);
	}

	public  String uploadPic(byte[] pic, String name, long size) {
		String path = null;
		try {
			// 图片11.jpg 根据图片名称得到图片后缀 jpg
			String ext = FilenameUtils.getExtension(name);
			NameValuePair[] meta_list = new NameValuePair[3];
			meta_list[0] = new NameValuePair("fileName", name);
			meta_list[1] = new NameValuePair("fileExt", ext);
			meta_list[2] = new NameValuePair("fileSize", String.valueOf(size));

			// group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
			path = storageClient.upload_file1(pic, ext, meta_list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
