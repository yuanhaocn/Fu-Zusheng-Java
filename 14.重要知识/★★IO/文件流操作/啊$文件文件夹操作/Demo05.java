package ��$�ļ��ļ��в���;

import java.io.File;
import java.util.Arrays;

/**
 * ����һ���ļ��У����������ＶĿ¼�����ļ������ơ�����·����ȫ�������
 * 1.listFiles()
 * 2.�ݹ�
 *static listRoots() ��·��
 */
public class Demo05 {

	public static void main(String[] args) {
//*************************��������������*******************************************//
		String path = "C:\\Users\\FZS\\Pictures\\test";
		File parent = new File(path);
//************************************************************************************//
		printName(parent);//�������������·��������
		
		
		/*
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		//�����еı������������Գ���һ�����һ��Ŀ¼����������˼
		for(File temp:roots) {
			printName(temp);
		}*/
		
		
		
	}
	/**
	 * ���·��
	 */
	public static void printName(File src) {
//********************************�ݹ���**************************************************//	
		if(null==src||!src.exists()) {
			return;
		}
		System.out.println(src.getAbsolutePath());
//****************************************************************************************//
		
//***************************�ݹ�ͷ*******************************************************//
		if(src.isDirectory()) {	//������ļ���
			for(File sub:src.listFiles()) {
				printName(sub);		//��ʼ�ݹ��ˣ��Լ������Լ�
			}
		}
//****************************************************************************************//
	}

}
