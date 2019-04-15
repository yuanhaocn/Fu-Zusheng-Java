package Offer30;

import java.util.ArrayList;

/**
 * Title: ��С��K���� (�ȼ���Ѱ�ҵ�K����)
 * Description: ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�
 * ����С��4��������1,2,3,4��
 * 
 * @author rico
 * @created 2017��6��2�� ����9:17:15
 */
public class Solution1 {

	/**
	 * @description ��С��K��Ԫ��һ���Ǵ��ڵģ���Ϊ�����ǰK�������������� ���ֵĴ��ˣ�end = index - 1����С��
	 *              ���ֵ�С�ˣ� start = index + 1�� ���� ֱ��ǡ�û�����ɡ�
	 * @author rico
	 * @created 2017��6��3�� ����8:38:04
	 * @param input
	 *            ��������
	 * @param k
	 *            ��СK����
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input != null && k > 0 && k <= input.length) {
			int start = 0;
			int end = input.length - 1;
			int index = partition(input, start, end);
			while (index != k - 1) { // ѭ����ֹ���������ֵ�����
				// System.out.println(Arrays.toString(input));
				if (index > k - 1) { // ���ô���
					end = index - 1; 
					index = partition(input, start, end);
				} else { // ����С��
					start = index + 1;
					index = partition(input, start, end);
				}
			}

			for (int i = 0; i < k; i++) {
				list.add(input[i]);
			}
		}
		return list;
	}

	/**
	 * @description ���ŵĻ����㷨,ʱ�临�Ӷ�O(n)
	 * @author rico
	 * @created 2017��6��3�� ����8:17:54
	 * @param input
	 * @param start
	 * @param end
	 * @return
	 */
	public int partition(int[] input, int start, int end) {
		int base = input[start];
		int base_index = start;
		for (int i = 1 + start; i <= end; i++) {
			if (input[i] < base) {
				base_index++;
				if (base_index != i) {
					int temp = input[base_index];
					input[base_index] = input[i];
					input[i] = temp;
				}
			}
		}
		input[start] = input[base_index];
		input[base_index] = base;
		return base_index;
	}

	public static void main(String[] args) {
		// int[] input = { 4, 5, 3, 6, 2, 7, 1, 8 };
		int[] input = { 1, 5, 4, 4, 4 };
		// int[] input = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(new Solution1().GetLeastNumbers_Solution(input, 3));
	}
}
