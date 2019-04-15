package Offer14;

import java.util.Arrays;
/**
 * Title: ��������˳��ʹ����λ��ż��ǰ��(����֤������������ż����ż��֮������λ�ò���)��˫ָ�뷨
 * Description:����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿��
 * �����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * 
 * @author rico
 * @created 2017��6��10�� ����2:36:29
 */
public class Solution2 {
	public void reOrderArray(int[] array) {
		int index1 = 0;  
		int index2 = array.length - 1; 
		while(index2 > index1){
			while(index1 < index2 && (array[index1] & 1)!= 0){  // index1�������ƣ�ֱ��ָ��ż��
				index1 ++;
			}
			while(index2 > index1 && (array[index2] & 1)!= 1){  // index2�������ƣ�ֱ��ָ������
				index2 --;
			}
			if (index2 > index1) {  // ����
				int temp = array[index2];
				array[index2] = array[index1];
				array[index1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		new Solution2().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
