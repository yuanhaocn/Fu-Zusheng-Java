package Offer48;

/**
 * Title:��ʹ���µı����������������ͱ�����ֵ 
 * Description: ��������������a��b,����ϣ���ڲ�ʹ���µı�����ǰ���½������ߵ�ֵ
 * 
 * @author rico
 * @created 2017��7��2�� ����2:41:38
 */
public class Solution {
	  
	/**     
	 * @description ����������㣬����������㽻���ɣ���һ�������������Ϊ0��һ������0���Ϊ����
	 * @author rico       
	 * @created 2017��7��2�� ����2:44:19     
	 * @param a
	 * @param b
	 */
	public static void swap(int a, int b) {
		System.out.println("����ǰ, a = " + a + " , b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("������, a = " + a + " , b = " + b);
	}

	public static void main(String[] args) {
		int a = 8;
		int b = 98;
		Solution.swap(a, b);
	}
}
