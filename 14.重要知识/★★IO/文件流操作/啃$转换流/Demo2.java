package ��$ת����;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo2 {
	public static void main(String[] args) {
	 try (	// �����ļ�����������
			 FileInputStream fis = new FileInputStream("C:\\Users\\FZS\\Pictures\\����1.txt");
			// ʹ���ļ����������󹹽�ת����	
			 InputStreamReader isr = new InputStreamReader(fis);){
		 //����ת������Ҫ���ַ�����
		 char[] chars=new char[1024];
		 //�������������Ч��ȡ�ַ�����
		 int capacity=0;
			//����ѭ��,������֮ǰһ��
		while((capacity=isr.read(chars))!=-1) {
				//ʹ�����鹹���ַ���
			System.out.print(new String(chars,0,capacity));
		}
		 
	} catch (Exception e) {
	}
	}
}
