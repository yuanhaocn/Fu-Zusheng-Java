package E$Udp���;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * ����һ���ֽ����飬װ����double
 */
/**
���������ˣ�
   1)������ �����  DatagramSocket  ��  +ָ���˿�
   2)��׼���������� �ֽ�����  ��װ DatagramPacket 
   3)����� ��������
   4)	��������
   5)����������  �ֽ�����--��double
 *
 */
public class Server{
	public static void main(String[] args) throws Exception {
		// 1)������ �����  DatagramSocket  ��  +ָ���˿�
		DatagramSocket server = new DatagramSocket(8888);
		// 2)��׼���������� �ֽ�����  ��װ DatagramPacket 
		byte[] container=new byte[1024];
		//3)����� ��������,
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4)	�������ݣ�����֮����packet����
		server.receive(packet);
		// 5)����������
		double data=convert(packet.getData());
		System.out.println(data);
		//6)�ͷ���Դ
		server.close();
	}
	/*
	 * ����һ���ֽ����飬װ����double
	 */
	public static double convert(byte[] data) throws IOException {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data	));
		double num = dis.readDouble(); 
		dis.close();
		return 0;
	}
}
