package ��$ת����;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �ֽ��ַ�ת����
 *
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println("С�磬����������");
		//����ת�����������������룬����ʹ��System.in
		InputStreamReader isr = new InputStreamReader(System.in);
		//����char ���͵�����
		char[] chars =new char[1024];
		//��ȡ�û�����
		try {
			int capacity = isr.read(chars,0,chars.length);
			//��ӡ�û�������ַ���,ʹ��capacity��ȡ��Ч����
			System.out.println(new String(chars,0,capacity));
		} catch (IOException e) {e.printStackTrace();}}}
