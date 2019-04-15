package Offer28_2;

import java.util.Arrays;

/**
 * Title:�����������涥������(ȫ���е�Ӧ��,����Լ��)
 * Description: �Ѱ˸����ַŵ��������8�������ϣ�ʹ��������������Ե����ϵ�4���������ȡ�
 * 
 * ����˼�룺ȫ���е�Ӧ�ã��оٳ����п����ԣ����þ���������һ��֤���޳������������Ľ��
 * 
 * @author rico
 * @created 2017��6��19�� ����10:18:51
 */
public class Solution {
	public static void getSpecifiedArrangement(int[] target, int from, int to) {
		if (from == to) { // �ݹ���ֹ����,���龰�µĴ���
			if (((target[0] + target[1] + target[2] + target[3]) == (target[4]
					+ target[5] + target[6] + target[7]))
					&& ((target[0] + target[2] + target[4] + target[6]) == (target[1]
							+ target[2] + target[4] + target[6]))
					&& ((target[0] + target[1] + target[4] + target[5]) == (target[2]
							+ target[3] + target[6] + target[7]))) {
				System.out.println(Arrays.toString(target)); 
			}
		} else { // ��С��ģ���ݹ����
			for (int i = from; i <= to; i++) {
				swap(target, from, i);
				getSpecifiedArrangement(target, from + 1, to);
				swap(target, from, i);
			}
		}
	}

	/**
	 * @description ����ָ������Ԫ��
	 * @author rico
	 * @created 2017��6��19�� ����10:38:27
	 * @param target
	 * @param from
	 * @param index
	 */
	public static void swap(int[] target, int from, int index) {
		int tmp = target[from];
		target[from] = target[index];
		target[index] = tmp;
	}

	public static void main(String[] args) {
		int target[] = { 1, 2, 3, 4, 1, 2, 3, 4};
		getSpecifiedArrangement(target, 0, target.length - 1);
	}
}
