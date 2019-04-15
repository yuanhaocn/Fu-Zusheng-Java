package E$线程上下文类加载器;

import C$文件网络自定义类加载器.FileSystemClassLoader;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = Demo.class.getClassLoader();
		System.out.println(loader);
		
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);
		
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("d:/myjava/"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		Class<?> cls = Thread.currentThread().getContextClassLoader().loadClass("C$文件网络自定义类加载器.Demo");
		System.out.println(cls);
		System.out.println(cls.getClassLoader());//cls的类加载器
	}
}
