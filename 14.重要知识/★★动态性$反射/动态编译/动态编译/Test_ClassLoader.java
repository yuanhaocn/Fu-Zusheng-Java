package 动态编译;
import java.net.URL;
import java.net.URLClassLoader;
/**
 * 通过反射运行编译好的类
 * main
 */
public class Test_ClassLoader {
	//通过反射运行编译好的类
	public static void runJavaClassByReflect(String dir,String classFile) {
	try {
		URL[] urls=new URL[] {new URL("file:/"+"D:/myjava/")};
		URLClassLoader Loader = new URLClassLoader(urls);//ClassLoader类加载器，通过它加载指定的类，再调用相关的main方法
		Class c=Loader.loadClass("HelloWorld");
		//调用加载类的main方法
										//因为main是静态方法，所以不需要对象，用null就可以
		c.getMethod("main", String[].class).invoke(null, (Object)new String[] {});//(Object)new String[] {}表示一个String[]数组
																					//就是为了和main(String[] args)相匹配	
																					//必须有Object，不然会变成可变参数的形状
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
