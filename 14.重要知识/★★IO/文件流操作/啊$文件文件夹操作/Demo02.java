package ��$�ļ��ļ��в���;

import java.io.File;

/**
 * ���·�������·������File����
 * 1.���·������File����
 * File(String parent,String Child)===>File(parentPath,name);
 * File(File parent,String Child)===>File(new File(parentPath), name)
 * 2.����·��
 * File(String name);
 */
public class Demo02 {

	public static void main(String[] args) {
		String parentPath = "C:\\Users\\FZS\\Pictures";
		String name = "123.jpg";
		// 1.���·������File����  ������java���ļ������ǳ���·����Ӧ���࣬������һ��·��
		File src = new File(parentPath,name);
		src = new File(new File(parentPath), name);
		//���
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//����·��
		src = new File("C:\\Users\\FZS\\Pictures\\123.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//û���̷� ����user.dir����
		src = new File("test.txt");
		//src = new File(".");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());

	}

}
