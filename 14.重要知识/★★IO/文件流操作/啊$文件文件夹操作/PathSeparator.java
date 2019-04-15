package 啊$文件文件夹操作;

import java.io.File;

/**
 * 两个常用常量
 * 1，路径分隔符File.pathSeparator 
 * 2，名称分隔符\(windows)	/(linux other)
 */
public class PathSeparator {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//路径的集中表现形式
		String path = "C:\\Users\\FZS\\Pictures\\123.jpg";//不建议使用
		path = "C:"+File.separator+"Users"+File.separator+"FZS"+File.separator+"Pictures"+File.separator+"123.jpg";	//动态生成，可是实现跨平台
		path = "C:/Users/FZS/Pictures/123.jpg";//推荐方法
	
	}

}
