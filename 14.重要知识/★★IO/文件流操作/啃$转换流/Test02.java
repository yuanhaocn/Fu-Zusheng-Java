package ��$ת����;

import java.io.IOException;
import java.io.InputStreamReader;

public class Test02 {
	public static void main(String[] args) {
		System.out.println("������һ���ַ�������");
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			/*
			 * read����ֻ����һ���ַ� ����ֵ��int����
			 * ����������ַ���ascii��
			 * ����������ʹ��ǿ������ת��
			 */
			int number = isr.read();
			System.out.println((char) (number));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
