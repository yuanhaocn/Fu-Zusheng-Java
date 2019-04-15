package B$反射获取类信息;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API,获取类的信息（类的名字，属性，方法，构造器）
 */
public class Get_Class_Info {
	public static void main(String[] args) {

		String path="A$反射机制.User";
		try {
			Class<?> cls = Class.forName(path);
		
			
			//获取类的名字
			System.out.println(cls.getName());//全类名获取
			System.out.println(cls.getSimpleName());//类名
		
			
			//获得属性信息,
			Field[] fields = cls.getFields();//只能获取公开属性，私有属性获取不到 
			Field declaredField = cls.getDeclaredField("uname");//获得指定指定属性
		
			Field[] declaredFields = cls.getDeclaredFields();//获得所有的属性
			for (Field field : declaredFields) {
				System.out.println(field);
			}
			
			
			//获得方法信息
			Method[] methods = cls.getMethods();//获得公开方法
			Method[] declaredMethods = cls.getDeclaredMethods();//获得所有方法
			Method method = cls.getMethod("getUname",null);
			//String.class 参数以String类的对象输进去
			Method method2 = cls.getMethod("setUname", String.class);
			
			
			//获得构造器信息
			Constructor<?>[] constructors = cls.getConstructors();//获取公开构造器
			Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();//获取全部构造器
			Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class,int.class,String.class);//获得指定构造器
			
			
		} catch (Exception e) {e.printStackTrace();}
	}
}
