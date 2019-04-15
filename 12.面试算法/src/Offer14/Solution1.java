package Offer14;

import java.util.Arrays;
/**
 * Title: ��������˳��ʹ����λ��ż��ǰ��(����֤������������ż����ż��֮������λ�ò���)
 * Description:����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿��
 * �����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * 
 * @author rico
 * @created 2017��6��10�� ����2:36:29
 */
public class Solution1 {
	public void reOrderArray(int[] array) {
		int index1 = -1; // ָ�����µ�����
		int index2 = -1; // ָ�����ϵ�ż��
		for (int i = 0; i < array.length; i++) { // ���������α�������
			if ((array[i] & 1) == 1) { // index1 ָ�����µ�����
				index1 = i;
			} else if (index2 == -1) {
				index2 = i; // index2ָ�����ϵ�ż��
			}
			if (index2 != -1 && index1 > index2) { // ����������������ż������
				int temp = array[index1];
				array[index1] = array[index2];
				array[index2] = temp;
				index1 = index2;   // ����index1
				index2++; // ����index2�������Ƶ�ż��ǰ�棬ż��λ���ƺ�
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		new Solution1().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
