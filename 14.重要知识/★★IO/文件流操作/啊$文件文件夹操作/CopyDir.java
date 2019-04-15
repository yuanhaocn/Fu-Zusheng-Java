package ��$�ļ��ļ��в���;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import ��$�ֽڶ�ȡд��.Transport;

/**
 * �ļ��еĿ���
 * 1���ļ� ��ֵ  copyFile
 * 2���ļ� ���� mkdirs()
 * 3���ݹ�������Ｖ
 */
public class CopyDir {
	public static void main(String[] args) throws IOException {
		//ԴĿ¼
		String srcPath="E:/xp/test/a"; 	
		//Ŀ��Ŀ¼
		String destPath="E:/xp/test/a/b";
			Transport.copyFile(srcPath,destPath);
		
	}
	/**
	 * �����ļ���
	 * @param src Դ·��
	 * @param dest Ŀ��·��
	 * @throws IOException 
	 */
	public static void copyDir(String  srcPath,String destPath) throws IOException{
		File src=new File(srcPath);
		File dest =new File(destPath);
		copyDir(src,dest);		
	}
	/**
	 * �����ļ���
	 * @param src ԴFile����
	 * @param dest Ŀ��File����
	 * @throws IOException 
	 */
	public static void copyDir(File src,File dest) throws IOException{
		if(src.isDirectory()){ //�ļ���
			dest =new File(dest,src.getName());			
		}		
		copyDirDetail(src,dest);
	}
	
	/**
	 * �����ļ���ϸ��
	 * @param src
	 * @param dest
	 * @throws IOException 
	 */
	public static void copyDirDetail(File src,File dest) throws IOException{
		if(src.isFile()){ //�ļ�
				Transport.copyFile(src, dest);
		}else if(src.isDirectory()){ //�ļ���
			//ȷ��Ŀ���ļ��д���
			dest.mkdirs();
			//��ȡ��һ��Ŀ¼|�ļ�
			for(File sub:src.listFiles()){
				copyDirDetail(sub,new File(dest,sub.getName()));
			}
		}
	}
}
