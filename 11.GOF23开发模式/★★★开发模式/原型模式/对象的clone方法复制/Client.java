package �����clone��������;

import java.util.Date;

/**
 * ����ԭ��ģʽ(ǳ��¡)
 * @author ��ѧ�ø�� www.sxt.cn
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Date date = new Date(12312321331L);
		Sheep s1 = new Sheep("����",date);
		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		//ǳ�㸴�Ƶ���˼�ǣ�����s1��ȫ��ֵ�����ã�����s1��s2��Birthdayָ����ͬһ��date�����date���ˣ������仯
		date.setTime(23432432423L);
		//��㸴�Ƶ���˼�ǣ�����s1��ȫ��ֵ�Ͳ��Ұ�s1��Birthday��ָ��Ķ���new Date(12312321331L);Ҳ����һ�ݸ��Լ��ã�
		//����s1��s2��Birthdayָ���˲�ͬһ��date����������
		System.out.println(s1.getBirthday());
		
		Sheep s2 = (Sheep) s1.clone();
		s2.setSname("����");
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());
		
		
	}
}
