package E$Udp���;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
���������ˣ�
   1)������ �����  DatagramSocket  ��  +ָ���˿�
   2)��׼���������� �ֽ�����  ��װ DatagramPacket 
   3)����� ��������
   4)����������
   5)����������
   
   
   new DatagramSocket(8888).receive(new DatagramPacket(container,container.length))
   
   
 *
 */
public class MyServer{
	public static void main(String[] args) throws Exception {
		// 1)������ �����  DatagramSocket  ��  +ָ���˿�
		DatagramSocket server = new DatagramSocket(8888);
		// 2)��׼���������� �ֽ�����  ��װ DatagramPacket 
		byte[] container=new byte[1024];
		// 3)����� ��������,
		DatagramPacket packet = new DatagramPacket(container,container.length);
		// 4)���������ݣ�����֮����packet����
		server.receive(packet);
		// 5)����������
		byte[] data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
		// 6)�ͷ���Դ
		server.close();
	}

}
