package Offer65;

import java.util.ArrayList;

/**
 * Title:�������ڵ����ֵ
 * Description:����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,
 * 2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 * �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}��
 * {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}��
 * {2,3,4,2,6,[2,5,1]}��
 * 
 * @author rico
 * @created 2017��7��9�� ����11:34:37
 */
public class Solution {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (num == null || num.length == 0 || size < 1 || size > num.length) {
			return result;
		} else {
			int from = 0; // ���ڱ߽�
			int to = size - 1; // ���ڱ߽�
			int tmp = Integer.MAX_VALUE;
			for (int i = to; i < num.length; i++) {
				// ��ȡ�����ڵ����ֵ
				if (tmp != Integer.MAX_VALUE) {
					if (num[i] > tmp) {
						tmp = num[i];
					} else if (tmp == num[from - 1]) {
						tmp = getMax(num, from, i);
					}
					from ++;  // ���ɺ���
				} else {
					tmp = getMax(num, from++, i);
				}
				result.add(tmp);
			}
		}
		return result;
	}

	/**
	 * @description ��ȡ�����/��С���㷨����K�������㷨���ӶȾ�ΪO(n)
	 * @author rico
	 */
	public int getMax(int[] num, int from, int to) {
		int max = num[from];
		for (int i = from + 1; i <= to; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		return max;
	}
}
