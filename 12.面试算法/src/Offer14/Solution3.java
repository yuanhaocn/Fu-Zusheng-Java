package Offer14;

import java.util.Arrays;
/**
 * Title: ��������˳��ʹ����λ��ż��ǰ��(����֤������������ż����ż��֮������λ�ò���)�����Ż��ַ�
 * Description:����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿��
 * �����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * 
 * @author rico
 * @created 2017��6��10�� ����2:36:29
 */
public class Solution3 {
	  
	/**     
	 * @description ����partition�����Ļ���˼��
	 * @author rico       
	 * @created 2017��6��10�� ����4:59:03     
	 * @param array     
	 */
	public void reOrderArray(int[] array) {
		int base_index = 0;
		// �ҵ���һ��ż����Ϊ��׼Ԫ��
		while((array[base_index] & 1) != 0){
			base_index ++;
		}
		
		int base = array[base_index];
		int index = base_index;   // ��׼Ԫ��Ӧ���ڵ�λ��
		for (int i = base_index+1; i < array.length; i++) {
			if ((array[i] & 1) == 1 ) {
				index ++;
				if (i != index) {
					int temp = array[index];
					array[index] = array[i];
					array[i] = temp;
				}
			}
		}
		array[base_index] = array[index];
		array[index] =base;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		new Solution3().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
