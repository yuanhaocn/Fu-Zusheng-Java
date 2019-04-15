package 啊$文件文件夹操作;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 5、操作目录
 *mkdir() 创建目录，必须确保父目录存在，如果不存在，创建失败
 *mkdirs() 创建目录，如果父目录链不存在一同创建
 *list() 文件|目录 名字符串形式
 *listFiles()
 *static listRoots() 根路径
 * @author FZS
 *
 */
public class Demo04 {

	public static void main(String[] args) {
		String path ="C:\\Users\\FZS\\Pictures\\test";
		File src = new File(path);
		if(src.isDirectory()) {
			System.out.println("=====子目录|子文件名====");
			String[] subNames = src.list();		//字符串数组接收文件夹里面的文件名
			for(String temp:subNames) {		//增强for循环
				System.out.println(temp);
			}
			System.out.println("====子目录|子文件名File对象====");
			File[] subFiles = src.listFiles();
			for(File temp:subFiles) {
				System.out.println(temp.getAbsolutePath());
			}
			System.out.println("====子文件|.java对象=======");		//如果是一个文件夹，就把里面的java文件输出来
//*******************************重点！！********************************************//
			//命令设计模式	（过滤)													//
			subFiles = src.listFiles(new FilenameFilter() {							//<---------------------------------------------------------|
																					//														    |
				@Override															//															|
				/*Dir代表src															//															|
				 *重写过滤规则														//															|
				 */																	//															|
				public boolean accept(File dir, String name) {						//															|
					System.out.println(dir.getName());								//															|		
					return new File(dir,name).isFile() && name.endsWith(".java");	//这一句表示是文件切是java文件								|
				}																	//															|
																					//															|	
			});																		//<---------------------------------------------------------|
			for(File temp:subFiles) {												//
				System.out.println(temp.getAbsolutePath());							//
			}																		//
//**********************************************************************************//			
		}
		
	}
	public static void test1() {
		String path ="C:\\Users\\FZS\\Pictures\\test";
		File src = new File(path);	//这个File可以使文件，也可以是文件夹
		src.mkdirs();	
	}
}
