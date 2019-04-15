package cn.fzs.io.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 1��������ϵ   File����   Դͷ Ŀ�ĵ�
2��ѡ����     
	 �ļ�������  InputStream FileInputStream
	  �ļ������  OutputStream FileOutputStream
3������  :  ����
	 byte[] flush =new byte[1024]; 
	 int len =0;
	  while(-1!=(len=������.read(flush))){  
		 �����.write(flush,0,len)
	  }
             �����.flush
4���ͷ���Դ :�ر� ������
 
 
 * @author Administrator
 *
 */
public class CopyFileDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String src ="E:/xp/test";
		String dest="e:/xp/test/4.jpg";
		try {
			copyFile(src,dest);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�����ļ�ʧ��|�ر���ʧ��");
		}		
		
	}
	/**
	 * �ļ��Ŀ���
	 * @param  Դ�ļ�·��
	 * @param  Ŀ¼�ļ�·��
	 * @throws FileNotFoundException,IOException
	 * @return 
	 */
		public static void copyFile(String srcPath,String destPath) throws FileNotFoundException,IOException {
			//1��������ϵ Դ(������Ϊ�ļ�) +Ŀ�ĵ�(�ļ����Բ�����)  
			File src =new File(srcPath);
			File dest =new File(destPath);
			if(! src.isFile()){ //�����ļ�����Ϊnull
				System.out.println("ֻ�ܿ����ļ�");
				throw new IOException("ֻ�ܿ����ļ�");
			}
			//2��ѡ����
			InputStream is =new FileInputStream(src);
			OutputStream os =new FileOutputStream(dest);
			//3���ļ�����   ѭ��+��ȡ+д��
			byte[] flush =new byte[1024];
			int len =0;
			//��ȡ
			while(-1!=(len=is.read(flush))){
				//д��
				os.write(flush, 0, len);
			}
			os.flush(); //ǿ��ˢ��
			
			//�ر���
			FileUtil.closeAll(os,is);
		}
		
		/**
		 * 1.7������ try --with --resource
		 * @param srcPath
		 * @param destPath
		 * @throws FileNotFoundException
		 * @throws IOException
		 */
		public static void copyFile2(String srcPath,String destPath) throws FileNotFoundException,IOException {
			//1��������ϵ Դ(������Ϊ�ļ�) +Ŀ�ĵ�(�ļ����Բ�����)  
			File src =new File(srcPath);
			File dest =new File(destPath);
			if(! src.isFile()){ //�����ļ�����Ϊnull
				System.out.println("ֻ�ܿ����ļ�");
				throw new IOException("ֻ�ܿ����ļ�");
			}
			//2��ѡ����
			try(
					InputStream is =new FileInputStream(src);
					OutputStream os =new FileOutputStream(dest);
			){
				//3���ļ�����   ѭ��+��ȡ+д��
				byte[] flush =new byte[1024];
				int len =0;
				//��ȡ
				while(-1!=(len=is.read(flush))){
					//д��
					os.write(flush, 0, len);
				}
				os.flush(); //ǿ��ˢ��
			}
	}
}
