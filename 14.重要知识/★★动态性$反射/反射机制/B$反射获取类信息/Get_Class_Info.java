package B$�����ȡ����Ϣ;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Ӧ�÷����API,��ȡ�����Ϣ��������֣����ԣ���������������
 */
public class Get_Class_Info {
	public static void main(String[] args) {

		String path="A$�������.User";
		try {
			Class<?> cls = Class.forName(path);
		
			
			//��ȡ�������
			System.out.println(cls.getName());//ȫ������ȡ
			System.out.println(cls.getSimpleName());//����
		
			
			//���������Ϣ,
			Field[] fields = cls.getFields();//ֻ�ܻ�ȡ�������ԣ�˽�����Ի�ȡ���� 
			Field declaredField = cls.getDeclaredField("uname");//���ָ��ָ������
		
			Field[] declaredFields = cls.getDeclaredFields();//������е�����
			for (Field field : declaredFields) {
				System.out.println(field);
			}
			
			
			//��÷�����Ϣ
			Method[] methods = cls.getMethods();//��ù�������
			Method[] declaredMethods = cls.getDeclaredMethods();//������з���
			Method method = cls.getMethod("getUname",null);
			//String.class ������String��Ķ������ȥ
			Method method2 = cls.getMethod("setUname", String.class);
			
			
			//��ù�������Ϣ
			Constructor<?>[] constructors = cls.getConstructors();//��ȡ����������
			Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();//��ȡȫ��������
			Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class,int.class,String.class);//���ָ��������
			
			
		} catch (Exception e) {e.printStackTrace();}
	}
}
