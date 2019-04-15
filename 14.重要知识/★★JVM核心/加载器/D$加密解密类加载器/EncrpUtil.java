package D$加密解密类加载器;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密工具类
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
			 //取反加密
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
