package ��$�ֽڶ�ȡд��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * �ļ��Ĳ���
 * @author FZS
 */
public class Transport {
	public static void main(String[] args)  {
		//1��������ϵ   File���� ��Դͷ�� Ŀ�ĵ�-----������������ϵ
		//Դͷ,�ļ�������ڣ��ұ������ļ�����ʱ�ļ���
		String src =  "E:/xp/test/1.jpg";
		//Ŀ�ĵأ��ļ����Բ�����
		String dest = "E:/xp/test/100.jpg";
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
	 * �ļ��Ŀ�������
	 * @param Դ�ļ�·��
	 * @param Ŀ���ļ���·��
	 * @throws
	 * @return
	 */
	public static   void copyFile(String srcPath,String destPath) throws IOException  {
		copyFile(new File(srcPath),new File(destPath));
	}
	/**
	 * �ļ��Ŀ�������
	 * @param Դ�ļ�File����
	 * @param Ŀ���ļ���File����
	 * @throws
	 * @return
	 */
	public static   void copyFile(File src ,File dest)  throws IOException  {
		if(! src.isFile()) {	//�����ļ�����Ϊnull
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
		}
		//2��ѡ����������     
		// �ļ�������  InputStream FileInputStream
	    //�ļ������  OutputStream FileOutputStream
		 InputStream is = new FileInputStream(src);
		 OutputStream os = new FileOutputStream(dest);
		 //3.�ļ��Ŀ�����ѭ��+��ȡ+д��
		 byte[] flush = new byte[1024];	//1024���ֽ���
		 //������ճ���
		 int len = 0;
		 //ѭ����ȡ
		 while (-1!=(len=is.read(flush))) {
			//д�� ����os��
			 os.write(flush, 0, len);//�Ƽ�ʹ���������Ϊ���һ�����ܶ��������пյ�
		}
		 os.flush();		//����һ��flushǿ��ˢ������ֹפ��
		 //�ر�����һ������ǣ��ȴ򿪵ĺ�ر�
		 os.close();
		 is.close();
	}
}
