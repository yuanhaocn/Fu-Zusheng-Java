package ��$�ֽڶ�ȡд��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ��Ķ�ȡ
 *  1��������ϵ   File����
	2��ѡ����     �ļ�������  InputStream FileInputStream
	3������  : byte[] car =new byte[1024];  +read+��ȡ��С
              ���
	4���ͷ���Դ :�ر�
 * @author FZS
 *
 */
public class TestRead {

	public static void main(String[] args) {
		//1��������ϵ   File����
		File src = new File("C:\\Users\\FZS\\Pictures\\123.txt");
//		2��ѡ����     �ļ�������  InputStream FileInputStream
		InputStream is = null;//����������
		try {
			 is = new FileInputStream(src);//ֻҪ����������ϵ�ͻ����쳣
//			3�������϶�ȡ������һ����������
			 byte[] car = new byte[10];
			 int len = 0;//ʵ�ʶ�ȡ��С
			 //ѭ����ȡ
			 
//***************************************************************************//
			 try {
				 
				while(-1!=(len=is.read(car))) {
					 //������ֽ�����ת���ַ���
					String info = new String(car,0,len);
					System.out.println(info);
				 }
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�ļ�������");
			}
			 
//***************************************************************************//			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ȡ�ļ�ʧ��");
		}finally {
			//4���ͷ���Դ
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("�ر��ļ�������ʧ��");
				}
			}
			
		}
		
	}

}
