package C$���ݷ�װ���;

import java.net.InetSocketAddress;

/**
 * ��װ�˿ڣ���InetAddress�Ļ����ϼ���˿ڵĸ���
 * 2��InetSocketAddress:��װ�˿�
	1)����������: 
 		InetSocketAddress(String hostname, int port) 
		InetSocketAddress(InetAddress addr, int port) 
	2)��������
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
