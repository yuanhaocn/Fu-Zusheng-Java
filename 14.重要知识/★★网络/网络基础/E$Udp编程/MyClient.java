package E$Udp���;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 1���ͻ��ˣ�
   1)�������ͻ���   DatagramSocket  ��  +ָ���˿�
   2)��׼������  �ֽ�����
   3)�����  DatagramPacket +��������ַ ���˿�
   4)������
   5)���ͷ���Դ
   new DatagramSocket(6666).send(new DatagramPacket(data,data.length,new InetSocketAddress("localHost",8888)))
   
   
 *
 */
public class MyClient {
	public static void main(String[] args) throws Exception {
		// 1)�������ͻ���   DatagramSocket  ��  +ָ���˿�
		DatagramSocket client = new DatagramSocket(6666);
		// 2)��׼������  �ֽ�����
		String msg ="udp���";
		byte[] data = msg.getBytes(); 
		// 3)�����  DatagramPacket +��������ַ +�˿�
		DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localHost",8888));
		// 4)������
		client.send(packet);
		// 5)���ͷ���Դ
		client.close();
	}

}
