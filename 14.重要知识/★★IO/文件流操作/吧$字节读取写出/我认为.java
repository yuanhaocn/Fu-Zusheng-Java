package ��$�ֽڶ�ȡд��;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ����Ϊ {
	public static void main(String[] args) {
	
		byte[] bytes=new byte[1024];//һ��ư
		int capacity=0;				//��¼ư�����ˮ
		/*
		 * ԴͷͰ+Ŀ��Ͱ+�Զ��ر�
		 * 	
		 * ��1.8�����Ƕ����رս���������
		 * ��tryС�������涨���������ʹ����֮���Զ��ر�
		 * ʹ�õ��Ǻ�jvm�Ķ��份�ѻ���
		 */
		 
		try(FileInputStream is = new FileInputStream("d://fzs.txt");
			FileOutputStream os = new FileOutputStream("d://fzs.txt");
			) {
			
			is.read(bytes);		//Ҩˮ��ư,����ֵ��ư���������
			os.write(bytes);	//��ư�е�ˮ����Ŀ��Ͱ
			os.flush();		//���ɾ�
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
