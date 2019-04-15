package part02;
import java.lang.reflect.Method;

import domain.Lion;
import part01.Annotation02;

public class Test02 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class<?> cls = Lion.class;
		Method method = cls.getMethod("show");
		 //�жϸ÷������Ƿ����ָ��ע��
		boolean b = method.isAnnotationPresent(Annotation02.class);
		//�����ע���ȷ����������ϣ�������Ҫ��ȡע���ֵ
		if(b) {
			//��ȡ�ڱ������ϵ�ע��
			Annotation02 annotation = method.getAnnotation(Annotation02.class);
			//��ȡע���ڸ÷����ϵ�ֵ
			System.out.println(annotation.name());
		}
	}
}
