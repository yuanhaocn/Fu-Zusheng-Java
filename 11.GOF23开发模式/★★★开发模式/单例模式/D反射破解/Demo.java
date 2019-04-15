/**
 * 测试懒汉式单例模式的反射破解和反序列化破解
 * 枚举方式基于JVM底层天然的避免了被反射和反序列化破解的可能
 */
package D反射破解;

import java.lang.reflect.Constructor;

import B线程安全的单例模式.MyJvm;

public class Demo{
	public static void main(String[] args)  {
		try {
		Class<MyJvm> clazz = (Class<MyJvm>)Class.forName("B线程安全的单例模式.MyJvm");
			//获得构造器
			Constructor<MyJvm>  c = clazz.getDeclaredConstructor(null);
			c.setAccessible(true);//访问私有的东西，跳过权限检查
			MyJvm s1 = c.newInstance();
			MyJvm s2 = c.newInstance();
			System.out.println(s1);
			System.out.println(s2);
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	}
}


