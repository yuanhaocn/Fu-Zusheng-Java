package 啊$文件文件夹操作;

import java.io.File;

/**
 * 相对路径与绝对路径构造File对象
 * 1.相对路径构造File对象
 * File(String parent,String Child)===>File(parentPath,name);
 * File(File parent,String Child)===>File(new File(parentPath), name)
 * 2.绝对路径
 * File(String name);
 */
public class Demo02 {

	public static void main(String[] args) {
		String parentPath = "C:\\Users\\FZS\\Pictures";
		String name = "123.jpg";
		// 1.相对路径构造File对象  ，这是java中文件或者是抽象路径对应的类，本质是一个路径
		File src = new File(parentPath,name);
		src = new File(new File(parentPath), name);
		//输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//绝对路径
		src = new File("C:\\Users\\FZS\\Pictures\\123.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//没有盘符 ：以user.dir构建
		src = new File("test.txt");
		//src = new File(".");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());

	}

}
