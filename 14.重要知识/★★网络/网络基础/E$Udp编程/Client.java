package E$Udp���;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * �ֽ����鵱����Դ+data�����
 * ����ǽ�double ת��byte[] 
 * �ڲ�����ʹ����
 */
/**
 * 1���ͻ��ˣ�
   1)�������ͻ���   DatagramSocket  ��  +ָ���˿�
   2)��׼������  double=-->>�ֽ�����  �ֽ����������
   3)�����  DatagramPacket +��������ַ ���˿�
   4)������
   5)���ͷ���Դ
 */
public class Client {

	public static void main(String[] args) throws Exception {
		// 1)�������ͻ���   DatagramSocket  ��  +ָ���˿�
		DatagramSocket client = new DatagramSocket(6666);
		// 2)��׼������  �ֽ�����
		double num=89.12;
		byte[] data = convert(num); 
		// 3)�����  DatagramPacket +��������ַ +�˿�
		DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localHost",8888));
		// 4)������
		client.send(packet);
		// 5)���ͷ���Դ
		client.close();
	}
	/*
	 * �ֽ����鵱����Դ+data�����
	 * ����ǽ�double ת��byte[] 
	 * �ڲ�����ʹ����
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

