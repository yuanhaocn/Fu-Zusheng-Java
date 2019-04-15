package part02;

import java.lang.annotation.Annotation;

import domain.Lion;
import part01.Annotation02;

public class Test {
	public static void main(String[] args) {
		Class<?> cls = Lion.class;
		Annotation[] annotations = cls.getAnnotations();
		// 遍历数组
		for (int i = 0; i < annotations.length; i++) {
			Annotation annotation = annotations[i];
			// 4.强转
			Annotation02 annotation02 = (Annotation02) annotation;
			//拆解注解的值
			System.out.println(annotation02.name()+"    "+annotation02.value());
		}
	}
}
