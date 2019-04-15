package E$Udp编程;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * 给我一个字节数组，装换成double
 */
/**
、服务器端：
   1)、创建 服务端  DatagramSocket  类  +指定端口
   2)、准备接受容器 字节数组  封装 DatagramPacket 
   3)、打包 接受数据
   4)	接收数据
   5)、分析数据  字节数组--》double
 *
 */
public class Server{
	public static void main(String[] args) throws Exception {
		// 1)、创建 服务端  DatagramSocket  类  +指定端口
		DatagramSocket server = new DatagramSocket(8888);
		// 2)、准备接受容器 字节数组  封装 DatagramPacket 
		byte[] container=new byte[1024];
		//3)、打包 接受数据,
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4)	接收数据，数据之后再packet里面
		server.receive(packet);
		// 5)、分析数据
		double data=convert(packet.getData());
		System.out.println(data);
		//6)释放资源
		server.close();
	}
	/*
	 * 给我一个字节数组，装换成double
	 */
	public static double convert(byte[] data) throws IOException {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data	));
		double num = dis.readDouble(); 
		dis.close();
		return 0;
	}
}
