package ��Ԫ����junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

//import static org.junit.Assert.*;//����ע���ˣ���˵

import org.junit.Test;

public class Junit01 {
	@Before	//��ÿ��@Test֮ǰִ��һ��
	public void testBefor() {
		System.out.println("��ʼ��¼��־");
	}
	@After//��ÿ��@Test֮��ִ��һ��
	public void testAfter() {
		System.out.println("����������");
		//System.err.println("����������");,err�Ǵ��󣬻�������ʾ
	}
	@Test	//JUnit���еı�ǣ�ֻ�з��������������ǵ�ʱ��ſ�������
	public void test() {
		//fail("Not yet implemented");
		System.out.println("hello");
	}
	@Test
	public void test01() {
		System.out.println(3);
	}
	@Ignore //���Ե���˼���������β���ִ�У�����ʲôҲ��д���ߵ�Ч
	public void test02() {
		System.out.println(3/0);
	}
	
}
