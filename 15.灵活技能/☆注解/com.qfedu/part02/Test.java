package part02;

import java.lang.annotation.Annotation;

import domain.Lion;
import part01.Annotation02;

public class Test {
	public static void main(String[] args) {
		Class<?> cls = Lion.class;
		Annotation[] annotations = cls.getAnnotations();
		// ��������
		for (int i = 0; i < annotations.length; i++) {
			Annotation annotation = annotations[i];
			// 4.ǿת
			Annotation02 annotation02 = (Annotation02) annotation;
			//���ע���ֵ
			System.out.println(annotation02.name()+"    "+annotation02.value());
		}
	}
}
