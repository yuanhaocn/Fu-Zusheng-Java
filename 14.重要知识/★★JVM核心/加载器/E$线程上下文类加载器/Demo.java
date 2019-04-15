package E$�߳��������������;

import C$�ļ������Զ����������.FileSystemClassLoader;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = Demo.class.getClassLoader();
		System.out.println(loader);
		
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);
		
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("d:/myjava/"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		Class<?> cls = Thread.currentThread().getContextClassLoader().loadClass("C$�ļ������Զ����������.Demo");
		System.out.println(cls);
		System.out.println(cls.getClassLoader());//cls���������
	}
}
