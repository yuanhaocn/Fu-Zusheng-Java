package ��$�ļ��ļ��в���;

import java.io.File;

/**
 * �������ó���
 * 1��·���ָ���File.pathSeparator 
 * 2�����Ʒָ���\(windows)	/(linux other)
 */
public class PathSeparator {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//·���ļ��б�����ʽ
		String path = "C:\\Users\\FZS\\Pictures\\123.jpg";//������ʹ��
		path = "C:"+File.separator+"Users"+File.separator+"FZS"+File.separator+"Pictures"+File.separator+"123.jpg";	//��̬���ɣ�����ʵ�ֿ�ƽ̨
		path = "C:/Users/FZS/Pictures/123.jpg";//�Ƽ�����
	
	}

}
