/**
 * ��������ʽ����ģʽ�ķ����ƽ�ͷ����л��ƽ�
 * ö�ٷ�ʽ����JVM�ײ���Ȼ�ı����˱�����ͷ����л��ƽ�Ŀ���
 */
package D�����ƽ�;

import java.lang.reflect.Constructor;

import B�̰߳�ȫ�ĵ���ģʽ.MyJvm;

public class Demo{
	public static void main(String[] args)  {
		try {
		Class<MyJvm> clazz = (Class<MyJvm>)Class.forName("B�̰߳�ȫ�ĵ���ģʽ.MyJvm");
			//��ù�����
			Constructor<MyJvm>  c = clazz.getDeclaredConstructor(null);
			c.setAccessible(true);//����˽�еĶ���������Ȩ�޼��
			MyJvm s1 = c.newInstance();
			MyJvm s2 = c.newInstance();
			System.out.println(s1);
			System.out.println(s2);
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	}
}


