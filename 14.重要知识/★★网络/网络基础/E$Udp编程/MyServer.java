package E$Udp编程;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
、服务器端：
   1)、创建 服务端  DatagramSocket  类  +指定端口
   2)、准备接受容器 字节数组  封装 DatagramPacket 
   3)、打包 接受数据
   4)、接收数据
   5)、分析数据
   
   
   new DatagramSocket(8888).receive(new DatagramPacket(container,container.length))
   
   
 *
 */
public class MyServer{
	public static void main(String[] args) throws Exception {
		// 1)、创建 服务端  DatagramSocket  类  +指定端口
		DatagramSocket server = new DatagramSocket(8888);
		// 2)、准备接受容器 字节数组  封装 DatagramPacket 
		byte[] container=new byte[1024];
		// 3)、打包 接受数据,
		DatagramPacket packet = new DatagramPacket(container,container.length);
		// 4)、接收数据，数据之后在packet里面
		server.receive(packet);
		// 5)、分析数据
		byte[] data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
		// 6)释放资源
		server.close();
	}

}
