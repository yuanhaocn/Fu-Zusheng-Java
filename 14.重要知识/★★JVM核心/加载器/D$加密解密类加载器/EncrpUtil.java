package D$���ܽ����������;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���ܹ�����
 *
 */
public class EncrpUtil {
	public static void main(String[] args) {
		encrpt("d:/myjava/HelloWorld.class", "d:/myjava/temp/HelloWorld.class");
	
	}
	
	public static void encrpt(String src,String dest) {
		FileInputStream fis =null;
		FileOutputStream fos =null;
		try {
			 fis = new FileInputStream(src);
			 fos = new FileOutputStream(dest);
			 //ȡ������
			 int temp=-1;
			 while((temp=fis.read())!=-1) {
				 fos.write(temp^0xff);
			 }
			 
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 if(fos!=null) {
				 try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
			 if(fis!=null) {
				 try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		}
	}
}
