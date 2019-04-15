package B$�����ȡ����Ϣ;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import A$�������.User;

/**
 * ͨ������API��̬�Ĳ�����������������������
 */
public class Use_Reflection {
	public static void main(String[] args) {
		String path="A$�������.User";
		try {
			
			Class<User> cls = (Class<User>)Class.forName(path);
			//ͨ����̬���ù��췽�����������
			User ni = cls.newInstance();//������User���޲ι���
			
			Constructor<?> c=cls.getDeclaredConstructor(int.class,int.class,String.class);//���ù�����
			User ni2 = (User) c.newInstance(1001,19,"fzs");//����ʵ�ν��и�ֵ
			
			//ͨ������API������ͨ����,�������ƺͲ������Ǳ��������
			Method declaredMethod = cls.getDeclaredMethod("setUname", String.class);
			declaredMethod.invoke(ni, "fzs");//=ni.setUname("fzs");
			System.out.println(ni.getUname());
		
			
			//ͨ������API��������
			User ni3 = cls.newInstance();//������User���޲ι���
			Field df = cls.getDeclaredField("uname");
			df.setAccessible(true);//������Բ�������ȫ����ˣ�ֱ��	���ʣ�˽�з���Ҳ��һ�����õ�
			df.set(ni3, "lzy");//ͨ������ֱ��д���Ե�ֵ
			
		} catch (Exception e) {e.printStackTrace();}
	}
}
