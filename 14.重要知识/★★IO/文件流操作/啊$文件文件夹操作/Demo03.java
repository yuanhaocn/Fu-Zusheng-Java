package 啊$文件文件夹操作;
import java.io.File;
import java.io.IOException;
/**
 * 基于文件的操作，你可以把这些东西建立的文件的属性页上面的信息去想
 * src:
 * ______________________________________
 * ||常规||安全|详细信息|以前版本|			|
 * |123.jpg								|
 * |文件类型：JPG文件.jpg					|
 * |打开方式：照片							|
 * |位置：C:\Users\FZS\Pictures			|
 * |大小：1.22 MB (1,287,676 字节)			|
 * |占用空间：1.23 MB (1,290,240 字节)		|
 * |创建时间：2018‎年3‎月12‎日 	20:14:49		|
 * |修改时间：2018‎年3‎月12‎日 	20:13:24		|
 * |访问时间：2018‎年3‎月12‎日 	20:14:49		|
 * |属性：  只读（R） 	隐藏（H） 				|
 * |____________________________________|
 * 
 * 常用方法:
1、文件名
	getName() 文件名、路径名
	getPath()路径名
	getAbsoluteFile() 绝对路径所对应的File对象
	getAbsolutePath() 绝对路径名
	getParent() 父目录 ,相对路径的父目录，可能为null 如. 删除本身后的结果
2、判断信息
	exists()
	canWrite()
	canRead()
	isFile()
	isDirectory()
	isAbsolute()：消除平台差异，ie以盘符开头，其他以/开头
3、长度 字节数  不能读取文件夹的长度
	length()
4、创建、删除
	createNewFile() 不存在创建新文件,存在返回false
	delete() 删除文件
	static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
	staticcreateTempFile(前缀3个字节长，后缀默认.temp,目录)
	deleteOnExit() 退出虚拟机删除,常用于删除临时文件
 */
public class Demo03 {

	public static void main(String[] args) throws IOException, InterruptedException {
		test3();
	}
	
	/*
	 * 构建信息 （名称）
	 */
	public static void test1() {
		File src = new File("C:\\Users\\FZS\\Pictures\\123.jpg");
		//与硬盘建立联系，但是存不存在不知�??
		
		System.out.println(src.getName());//返回名称
		System.out.println(src.getPath());//如果是绝对路径，返回完整路径，否则相对路�??
		System.out.println(src.getAbsolutePath());//返回绝对路径 
		System.out.println(src.getParent());//返回上一级目�?,如果是相对，返回null
	}
	/*
	 * 判断信息
	 */
	public static void test2() {
		//String path = "123.jpg";
		String path = "C:\\Users\\FZS\\Pictures\\123.jpg";
		//构建�??个文件夹，看看能不能�??
		//String path = "C:\\\\Users\\\\FZS\\\\Pictures";
		 File src = new File(path);
		 //文件是否存在
		 System.out.println("文件是否存在�??"+src.exists());
		 //是否可读写canWrite() canRead()
		 System.out.println("文件是否可写�??"+src.canWrite());
		 //isFile()
		 if(src.isFile()) {
			 System.out.println("是文�??");
		 }else {
			 //没有真实存在的默认为文件�??
			 System.out.println("是文件夹");
		 }
		 System.out.println("长度为："+src.length());
	}
	/*
	 * 创建和删除文�?
	 */
	public static void test3() throws IOException, InterruptedException {
		//createNewFile() 不存在创建新文件,存在返回false
		String path = "C:\\Users\\FZS\\Pictures\\12453.jpg";
		File src = new File(path);
		if(!src.exists()) {		//如果src不存在！！！则进�??
			try {
				boolean flag = src.createNewFile();
				System.out.println(flag?"成功":"失败");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("文件操作失败");
			}
		}
		//删除文件
		boolean flag = src.delete(); 
		System.out.println(flag?"成功":"失败");
		
		//static createTempFile(前缀3个字节长，后�??默认.temp) 默认临时空间
		//static createTempFile(前缀3个字节长，后�??默认.temp,目录)
		File temp = File.createTempFile("test", ".temp",new File("C:\\Users\\FZS\\Pictures"));
		//一秒钟后就会删去??
		Thread.sleep(1000);
		temp.deleteOnExit();//退出即删除
		
	}
}
