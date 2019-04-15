package C$数据封装拆封;

import java.net.InetSocketAddress;

/**
 * 封装端口：在InetAddress的基础上加入端口的概念
 * 2、InetSocketAddress:封装端口
	1)、创建对象: 
 		InetSocketAddress(String hostname, int port) 
		InetSocketAddress(InetAddress addr, int port) 
	2)、方法：
		getAddress() 
		getHostName() 
		getPort() 
 */
public class InetSocketDemo01 {
	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("10,11,54,57",9999);
		System.out.println(address.getPort());
		System.out.println(address.getHostName());
	}
}
