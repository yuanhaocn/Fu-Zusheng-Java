package 啊$文件文件夹操作;

import java.io.File;
import java.util.Arrays;

/**
 * 遍历一个文件夹，把他的子孙级目录或者文件的名称【绝对路径】全都输出来
 * 1.listFiles()
 * 2.递归
 *static listRoots() 根路径
 */
public class Demo05 {

	public static void main(String[] args) {
//*************************构建，建立连接*******************************************//
		String path = "C:\\Users\\FZS\\Pictures\\test";
		File parent = new File(path);
//************************************************************************************//
		printName(parent);//接下来根据这个路径往下走
		
		
		/*
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		//把所有的遍历出来，可以尝试一下输出一个目录树，很有意思
		for(File temp:roots) {
			printName(temp);
		}*/
		
		
		
	}
	/**
	 * 输出路径
	 */
	public static void printName(File src) {
//********************************递归体**************************************************//	
		if(null==src||!src.exists()) {
			return;
		}
		System.out.println(src.getAbsolutePath());
//****************************************************************************************//
		
//***************************递归头*******************************************************//
		if(src.isDirectory()) {	//如果是文件夹
			for(File sub:src.listFiles()) {
				printName(sub);		//开始递归了，自己调用自己
			}
		}
//****************************************************************************************//
	}

}
