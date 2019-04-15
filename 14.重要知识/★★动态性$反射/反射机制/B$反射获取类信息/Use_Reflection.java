package B$反射获取类信息;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import A$反射机制.User;

/**
 * 通过反射API动态的操作：构造器，方法，属性
 */
public class Use_Reflection {
	public static void main(String[] args) {
		String path="A$反射机制.User";
		try {
			
			Class<User> cls = (Class<User>)Class.forName(path);
			//通过动态调用构造方法，构造对象
			User ni = cls.newInstance();//调用了User的无参构造
			
			Constructor<?> c=cls.getDeclaredConstructor(int.class,int.class,String.class);//调用构造器
			User ni2 = (User) c.newInstance(1001,19,"fzs");//传递实参进行赋值
			
			//通过反射API调用普通方法,方法名称和参数都是变量。灵活
			Method declaredMethod = cls.getDeclaredMethod("setUname", String.class);
			declaredMethod.invoke(ni, "fzs");//=ni.setUname("fzs");
			System.out.println(ni.getUname());
		
			
			//通过反射API操作属性
			User ni3 = cls.newInstance();//调用了User的无参构造
			Field df = cls.getDeclaredField("uname");
			df.setAccessible(true);//这个属性不用做安全检查了，直接	访问，私有方法也是一样设置的
			df.set(ni3, "lzy");//通过反射直接写属性的值
			
		} catch (Exception e) {e.printStackTrace();}
	}
}
