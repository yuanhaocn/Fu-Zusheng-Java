package ��̬����;
import java.net.URL;
import java.net.URLClassLoader;
/**
 * ͨ���������б���õ���
 * main
 */
public class Test_ClassLoader {
	//ͨ���������б���õ���
	public static void runJavaClassByReflect(String dir,String classFile) {
	try {
		URL[] urls=new URL[] {new URL("file:/"+"D:/myjava/")};
		URLClassLoader Loader = new URLClassLoader(urls);//ClassLoader���������ͨ��������ָ�����࣬�ٵ�����ص�main����
		Class c=Loader.loadClass("HelloWorld");
		//���ü������main����
										//��Ϊmain�Ǿ�̬���������Բ���Ҫ������null�Ϳ���
		c.getMethod("main", String[].class).invoke(null, (Object)new String[] {});//(Object)new String[] {}��ʾһ��String[]����
																					//����Ϊ�˺�main(String[] args)��ƥ��	
																					//������Object����Ȼ���ɿɱ��������״
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
