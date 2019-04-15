package com.syc.fdfs.demo01;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDemo {

	private String confFile="/fdfs/fdfs_client.conf";
	private String uploadFile="E:\\dishu.jpg";
	
	@Test
	public void uploadTest(){
		try {
			String confPath=getClass().getResource(confFile).getPath();
			//1.对FastDFS做一个全局的初始化设置
			ClientGlobal.init(confPath);
			
			//TrackerServer trackerServer=new TrackerServer(sock, inetSockAddr);
			
			//3.创建最总服务器的客户端对象
			TrackerClient trackerClient=new TrackerClient();
			TrackerServer trackerServer=trackerClient.getConnection();
			
			//2.创建存储客户端对象,不需要关系存储服务器
			StorageClient client=new StorageClient(trackerServer, null);
			
			//4.实现文件上传
			//results:返回结果中包含,存储服务器中文件所在的group名,还有服务器根据内部算法生成的随机的文件名.
			//组名+文件名=ID
			//组名:group1
			//文件名:M00/00/00/CgtE7Vrv9T-AbqcIAAARvKnKFr8902.jpg
			//图片服务器中图片的url=http://10.11.68.237/group1/M00/00/00/CgtE7Vrv9T-AbqcIAAARvKnKFr8902.jpg
			//<img src="">
			String[] results = client.upload_file(uploadFile, "jpg", null);
			for(String result : results){
				System.out.println("result="+result);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
