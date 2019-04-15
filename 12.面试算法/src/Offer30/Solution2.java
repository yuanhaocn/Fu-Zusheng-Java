package Offer30;

import java.util.ArrayList;

/**
 * Title: ��С��K���� (���ѣ��������ݲ���,ʱ�临�Ӷ�O(nlgK))
 * Description: ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�
 * ����С��4��������1,2,3,4��
 * 
 * @author rico
 * @created 2017��6��2�� ����9:17:15
 */
public class Solution2 {

	/**
	 * @description ͨ�������㷨�ҳ���СK��Ԫ�أ�ʱ�临�Ӷ� O(nlgK)���ռ临�Ӷ�O(K),�ʺϺ������ݲ���
	 * @author rico
	 * @created 2017��6��2�� ����10:19:47
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>(k); // �洢��СK��Ԫ��
		int[] target = new int[k]; // �洢��СK��Ԫ��
		if (input != null && k > 0 && k <= input.length) {
			for (int i = 0; i < input.length; i++) {
				if (i < k) { // ������СΪK������: O(KlgK) = O(K) * O(lgK)
					target[i] = input[i];
					shiftUp(target, 0, i); // �������ϵ���Ϊ����
				} else {
					int max = target[0]; // O(1)
					if (max > input[i]) {
						target[0] = input[i]; // ɾ�����Ԫ�ز��滻���¶���Ԫ��
						shiftDown(target, 0, k - 1); // �������µ���Ϊ����,O(lgK)
					} else {
						continue;
					}
				}
			}

			// ��target�е�Ԫ��ת�浽list��
			for (int i = 0; i < k; i++) {
				list.add(target[i]);
			}
		}
		return list;
	}

	/**
	 * @description �ѵ����㷨���������µ���(ԭ�������ѣ�ɾ�����滻�Ѷ�Ԫ�أ�����Ϊ����)
	 * @author rico
	 * @created 2017��6��2�� ����10:16:19
	 * @param input
	 *            ����������
	 * @param start
	 *            ������Χ����ʼλ��
	 * @param end
	 *            ������Χ����ֹλ��
	 */
	public void shiftDown(int[] input, int start, int end) {
		int i = start;
		int j = 2 * start + 1;
		int temp = input[i];
		while (j <= end) {
			if (j < end) { // �ҳ�������Ů
				j = input[j] > input[j + 1] ? j : j + 1;
			}
			if (input[j] > temp) { // ���϶��²��ϵ���Ϊ����
				input[i] = input[j];
				i = j;
				j = 2 * i + 1;
			} else { // �������ѣ����õ�����ֱ���˳�
				break;
			}
		}
		input[i] = temp;
	}

	/**
	 * @description �ѵ����㷨���������ϵ���(ԭ�������ѣ��ڶ�β������Ԫ�أ�����Ϊ����)
	 * @author rico
	 * @created 2017��6��3�� ����10:35:10
	 * @param input
	 *            ����������
	 * @param start
	 *            ������Χ����ʼλ��
	 * @param end
	 *            ������Χ����ֹλ��
	 */
	public void shiftUp(int[] input, int start, int end) {
		int i = (end - 1) / 2;
		int j = end;
		int temp = input[j];
		while (j > 0) { // ѭ����ֹ�������������Ѷ���ֹͣ
			if (input[i] < temp) {
				input[j] = input[i];
				j = i;
				i = (j - 1) / 2;
			} else {
				break;
			}
		}
		input[j] = temp;
	}

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(new Solution2().GetLeastNumbers_Solution(input, 4));
	}
}
