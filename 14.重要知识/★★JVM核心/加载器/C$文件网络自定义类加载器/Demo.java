package C$文件网络自定义类加载器;
/**
 * 测试自定义类加载器
 */
public class Demo {

	public static void main(String[] args) throws ClassNotFoundException {
		
		FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava");
		
		Class<?> c = loader.loadClass("com.bjsxt.gaoqi.HelloWorld");
		Class<?> c2 = loader.loadClass("com.bjsxt.gaoqi.HelloWorld");

		FileSystemClassLoader loader2 = new FileSystemClassLoader("d:/myjava");
		Class<?> c3 = loader2.loadClass("com.bjsxt.gaoqi.HelloWorld");
		Class<?> c4 = loader2.loadClass("java.lang.String");//因为双亲委托机制，所以这个会被引导类加载器加载
		Class<?> c5 = loader2.loadClass("A$类加载原理.Demo02");//加载本项目下的class文件
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());//同一个类加载器将会只产生一个对象，不会重复加载
		System.out.println(c3.hashCode());//不同的类加载器必定会产生不同的对象
		System.out.println(c4.hashCode());
		
		//显示使用到的类加载器
		System.out.println(c3.getClassLoader());//用的是自定义的加载器
		System.out.println(c4.getClassLoader());//为空，用的是引导类加载器
		System.out.println(c5.getClassLoader());//默认的AppClassLoader
	}

}
