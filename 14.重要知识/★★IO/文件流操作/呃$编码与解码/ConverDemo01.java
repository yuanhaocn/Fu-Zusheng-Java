package ��$���������;

import java.io.UnsupportedEncodingException;

public class ConverDemo01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str ="�й�";
		byte[] data =str.getBytes();
		//�ֽ���������
		System.out.println(new String(data,0,3));
		test1();
	}
	/**
	 * ����������ַ���������ͬ����������
	 */
	public static void test1() throws UnsupportedEncodingException{
		//���� byte -->char
				String str ="�й�"; //gbk 
				byte[] data =str.getBytes();//���� char -->byte
				System.out.println(new String(data));//����������ַ���ͬһ
				data =str.getBytes("utf-8"); //�趨�����ַ���
				System.out.println(new String(data));//��ͬһ��������
				byte[] data2 = "�й�".getBytes("utf-8");//����
				str=new String(data2,"utf-8");//����
				System.out.println(str);
	}

}
