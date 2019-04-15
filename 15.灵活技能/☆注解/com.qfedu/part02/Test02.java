package part02;
import java.lang.reflect.Method;

import domain.Lion;
import part01.Annotation02;

public class Test02 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class<?> cls = Lion.class;
		Method method = cls.getMethod("show");
		 //判断该方法上是否存在指定注解
		boolean b = method.isAnnotationPresent(Annotation02.class);
		//如果该注解的确在这个方法上，我们需要读取注解的值
		if(b) {
			//获取在本方法上的注解
			Annotation02 annotation = method.getAnnotation(Annotation02.class);
			//获取注解在该方法上的值
			System.out.println(annotation.name());
		}
	}
}
