package E$Udp编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 1、客户端：
   1)、创建客户端   DatagramSocket  类  +指定端口
   2)、准备数据  字节数组
   3)、打包  DatagramPacket +服务器地址 及端口
   4)、发送
   5)、释放资源
   new DatagramSocket(6666).send(new DatagramPacket(data,data.length,new InetSocketAddress("localHost",8888)))
   
   
 *
 */
public class MyClient {
	public static void main(String[] args) throws Exception {
		// 1)、创建客户端   DatagramSocket  类  +指定端口
		DatagramSocket client = new DatagramSocket(6666);
		// 2)、准备数据  字节数组
		String msg ="udp编程";
		byte[] data = msg.getBytes(); 
		// 3)、打包  DatagramPacket +服务器地址 +端口
		DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localHost",8888));
		// 4)、发送
		client.send(packet);
		// 5)、释放资源
		client.close();
	}

}
