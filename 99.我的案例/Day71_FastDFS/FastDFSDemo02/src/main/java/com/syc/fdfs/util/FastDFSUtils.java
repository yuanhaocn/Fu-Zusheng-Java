package com.syc.fdfs.util;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

/**
 * 上传图片到Fast
 * 
 * @author lx
 *
 */
public class FastDFSUtils {

	/**
	 * @Description: 上传图片到Fast.
	 * @param pic
	 *            图片二进制
	 * @param name
	 *            图片名称
	 * @param size
	 *            图片大小
	 * @return 图片服务器中图片的存放路径
	 */
	public static String uploadPic(byte[] pic, String name, long size) {
		String path = null;
		// ClientGloble 读配置文件
		try {
			ClassPathResource resource = new ClassPathResource("/fdfs/fdfs_client.conf");
			//ClientGlobal.init(resource.getClassLoader().getResource("/fdfs/fdfs_client.conf").getPath());
			ClientGlobal.init(resource.getPath());
			
			// 追踪服务器的客户端
			TrackerClient trackerClient = new TrackerClient();
			// 追踪服务器
			TrackerServer trackerServer = trackerClient.getConnection();
			
			//存储服务器
			StorageServer storageServer = null;
			//存储服务器的客户端
			StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
			
			// 例如图片11.jpg,根据图片名称得到图片的后缀 jpg
			String ext = FilenameUtils.getExtension(name);

			NameValuePair[] meta_list = new NameValuePair[3];
			meta_list[0] = new NameValuePair("fileName", name);
			meta_list[1] = new NameValuePair("fileExt", ext);
			meta_list[2] = new NameValuePair("fileSize", String.valueOf(size));

			// group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
			path = storageClient1.upload_file1(pic, ext, meta_list);
			System.out.println("path="+path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
