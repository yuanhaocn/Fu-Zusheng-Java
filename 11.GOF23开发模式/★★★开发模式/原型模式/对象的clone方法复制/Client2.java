package �����clone��������;

import java.util.Date;

/**
 * ԭ��ģʽ(���)
 *
 */
public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(12312321331L);
		Sheep2 s1 = new Sheep2("����",date);
		Sheep2 s2 = (Sheep2) s1.clone();   //ʵ����ơ�s2�����birthday��һ���¶���
		
		
		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		
		date.setTime(23432432423L);//��������ָ���date����һ���������Ի���Ӱ�죬ʵ�����
		
		System.out.println(s1.getBirthday());
		
		
		s2.setSname("����");
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());	
	}
}
