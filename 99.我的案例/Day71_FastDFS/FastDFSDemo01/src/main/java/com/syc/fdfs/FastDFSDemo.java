package com.syc.fdfs;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDFSDemo {

	// 客户端配置文件
	private String conf_filename = "/fdfs/fdfs_client.conf";

	// 本地文件,要上传的文件
	private String filename = "E:\\redbaby.png";

	@Test
	public void testDemo() throws IOException, MyException {
		// 初始化fdfs的配置文件,指定配置文件的完整路径
		String url = getClass().getResource(conf_filename).getPath();
		ClientGlobal.init(url);

		// 获取tracker的客户端
		TrackerClient client = new TrackerClient();

		// 获取tracker的服务端
		TrackerServer trackerServer = client.getConnection();

		// 获取storage的客户端, 第二个参数是storageserver，可以指定某个storageserver上传图片

		StorageClient storageClient = new StorageClient(trackerServer, null);

		// 通过storage的客户端完成上传操作
		String[] upload_file = storageClient.upload_file(filename, "jpg", null);

		//得到如下结果:
		//group1
		//M00/00/00/wKgDIlrvFJWAOA0PAAAEGsnljbY764.jpg
		//然后将group1和第二行的字符串拼接成url,就是图片服务器上图片的访问地址.
		//http://192.168.3.34/group1/M00/00/00/wKgDIlrvFJWAOA0PAAAEGsnljbY764.jpg
		
		for (String string : upload_file) {
			System.out.println(string);
		}
	}
}
