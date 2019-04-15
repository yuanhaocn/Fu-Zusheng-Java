package ��$�ֽڶ�ȡд��;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *  * д���ļ�
1��������ϵ   File����  Ŀ�ĵ�
2��ѡ����     �ļ������  OutputStream FileOutputStream
3������  :  write() +flush
4���ͷ���Դ :�ر�
 * @author FZS
 *
 */
public class TestWrite {

	public static void main(String[] args) {
		//1��������ϵ   File����  Ŀ�ĵ�
		File dest =new File("C:\\Users\\FZS\\Pictures\\123.txt");
		//2��ѡ����   �ļ������  OutputStream FileOutputStream
		OutputStream os =null;
		//��׷����ʽ д���ļ� ����Ϊtrue ����Ϊ����
		try {
			os =new FileOutputStream(dest,true);
			//3������
			String str="bjsxt is very good \r\n";
			//�ַ���ת�ֽ�����
			byte[] data =str.getBytes();
			os.write(data,0,data.length);
			
			os.flush(); //ǿ��ˢ�³�ȥ
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ�");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�д��ʧ��");
		}finally{
			//4���ͷ���Դ :�ر�
			try {
				if (null != os) {
					os.close();
				}
			} catch (Exception e2) {
				System.out.println("�ر������ʧ��");
			}
		}
	}

}
