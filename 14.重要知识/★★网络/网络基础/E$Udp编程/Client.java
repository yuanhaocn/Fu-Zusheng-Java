package E$Udp编程;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 字节数组当数据源+data输出流
 * 这个是将double 转成byte[] 
 * 内部还是使用流
 */
/**
 * 1、客户端：
   1)、创建客户端   DatagramSocket  类  +指定端口
   2)、准备数据  double=-->>字节数组  字节数组输出流
   3)、打包  DatagramPacket +服务器地址 及端口
   4)、发送
   5)、释放资源
 */
public class Client {

	public static void main(String[] args) throws Exception {
		// 1)、创建客户端   DatagramSocket  类  +指定端口
		DatagramSocket client = new DatagramSocket(6666);
		// 2)、准备数据  字节数组
		double num=89.12;
		byte[] data = convert(num); 
		// 3)、打包  DatagramPacket +服务器地址 +端口
		DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localHost",8888));
		// 4)、发送
		client.send(packet);
		// 5)、释放资源
		client.close();
	}
	/*
	 * 字节数组当数据源+data输出流
	 * 这个是将double 转成byte[] 
	 * 内部还是使用流
	 */
	public static byte[] convert(double num) throws IOException {
		byte[] data= null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);		
			dos.writeDouble(num);
			dos.flush();
			data=bos.toByteArray();
			dos.close();
			return data;
	}
	
}

