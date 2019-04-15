package Offer30;

import java.util.ArrayList;

/**
 * Title: ��С��K���� 
 * Description: ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�
 * ����С��4��������1,2,3,4��
 * 
 * @author rico
 * @created 2017��6��2�� ����9:17:15
 */
public class Solution {
	  
	/**     
	 * @description ͨ���ѵ����㷨�ҳ���СK��Ԫ�أ�ʱ�临�Ӷ� O(nlgn)
	 * @author rico       
	 * @created 2017��6��2�� ����10:19:47     
	 * @param input
	 * @param k
	 * @return     
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input != null && k > 0 && k <= input.length) {
			
			// ����Ϊ��С��: O(nlgn) = O(n) * O(lgn)
			int pos = (input.length - 2) / 2;
			while (pos >= 0) {          // O(n)
				shiftDown(input, pos, input.length - 1);  // O(lgn)
				pos--;
			}

			// ͨ���ѵ����㷨��ȡ��СK��Ԫ��
			int end = input.length - 1;
			for (int i = 0; i < k; i++) {   // K
				int temp = input[0];
				input[0] = input[end];
				input[end] = temp;
				end--;
				shiftDown(input, 0, end);  // O(lgn)
				list.add(temp);
			}
		}
		return list;
	}

	  
	/**     
	 * @description �ѵ����㷨���������µ���(��������Ϊ��С��)
	 * @author rico       
	 * @created 2017��6��2�� ����10:16:19     
	 * @param input ����������
	 * @param start ������Χ����ʼλ��
	 * @param end   ������Χ����ֹλ��  
	 */
	public void shiftDown(int[] input, int start, int end) {
		int i = start;
		int j = 2 * start + 1;
		int temp = input[i];
		while (j <= end) {
			if (j < end) {  // �ҳ���С����Ů
				j = input[j] < input[j + 1] ? j : j + 1;
			}
			if (input[j] < temp) {   // ���϶��²��ϵ���Ϊ��С��
				input[i] = input[j];
				i = j;
				j = 2 * i + 1;
			} else {  // ������С�ѣ����õ�����ֱ���˳�
				break;
			}
		}
		input[i] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(new Solution().GetLeastNumbers_Solution(input, 4));
	}
}
