package D$加密解密类加载器;

/**
 *测试简单的加密解密（取反）操作  
 *
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		//加密之后的class 文件，正常的类加载器无法加载，报classFormatError
		/*FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava/temp");
		Class<?> c = loader.loadClass("com.bjsxt.gaoqi.HelloWorld");
		System.out.println(c);*/
		
		DecriptClassLoader loader = new DecriptClassLoader("d:/myjava/temp");
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
	}
}
