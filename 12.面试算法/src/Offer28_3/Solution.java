package Offer28_3;

import java.util.Arrays;

/**
 * Title: �˻ʺ�����(ȫ���е�Ӧ��,����Լ��)
 * Description:8*8�����̰ڷ�8���ʺ󣬲������������ʺ�����ͬһ�У�ͬһ�л���ͬһ�Խ�����
 *
 * ����˼�룺ȫ���е�Ӧ�ã��оٳ����п����ԣ����þ���������һ��֤���޳������������Ľ��
 * 
 * @author rico
 * @created 2017��6��20�� ����8:03:39
 */
public class Solution {
	static int count = 0;

	/**
	 * @description �˻ʺ�����
	 * @author rico
	 * @created 2017��6��20�� ����8:25:48
	 * @param target target[i] = j, ��ʾ��i�е�j�д��ڻʺ�(���ֱ�ʾ�����£��ʺ���Բ�����ͬһ��/����)
	 * @param from
	 * @param to
	 */
	public static void eightQueen(int[] target, int from, int to) {
		if (from == to) { // �ݹ���ֹ����,���龰�µĴ���
			boolean flag = true;
			for (int i = 0; i < target.length; i++) {
				if (!flag)
					break; // ������һ��ѭ��
				for (int j = i + 1; j < target.length; j++) {
					// (i - j)��ʾ�����ʺ������еĲ(target[i] - target[j])��ʾ�������ʺ������еĲ�
					// ��������Ȼ��߻�Ϊ�෴������ô�������ʺ����ͬһ���Խ�����
					if (((i - j) == (target[i] - target[j]))
							|| ((j - i) == (target[i] - target[j]))) {
						flag = false; // ����������һ��ѭ��
						break; // ������ǰѭ��
					}
				}
			}
			// flagΪtrue,��ʾ��ǰ�����������������д�ӡ
			if (flag) {
				System.out.println("�� " + ++count + "�� �� "
						+ Arrays.toString(target));
			}
		} else { // ��С��ģ���ݹ����
			for (int i = from; i <= to; i++) {
				swap(target, from, i);
				eightQueen(target, from + 1, to);
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
		int[] target = { 0, 1, 2, 3, 4, 5, 6, 7 };
		eightQueen(target, 0, 7);
	}
}
