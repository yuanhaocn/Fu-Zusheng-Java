package Offer3;

import java.util.Arrays;

/**
 * Title : ��ά�����еĲ��� 
 * Description :��������+���ֲ���
 * ʱ�临�Ӷȣ�O(nlgn)
 * �ռ临�Ӷȣ�O(1)
 * 
 * @author rico
 * @created 2017��5��8�� ����12:02:59
 */
public class Solution1 {

	public static boolean contain(int[][] array, int target) {

		// �߽�������Ŀ�������Ƿ�Ϊ��
		if (array == null)
			return false;

		for (int i = 0; i < array.length; i++) {
			int col = array[i].length;
			if (col != 0) { // ��colΪ�㣬��ǰ�����鲻�����κ�Ԫ�أ���˲�����ִ��

				int min = array[i][0]; // ����Сֵ
				int max = array[i][col - 1]; // �����ֵ

				// �Ż�����
				// ��Ŀ��ֵС�ڵ�ǰ����Сֵ������ȵ�ǰ���·����κ�Ԫ�ض�ҪС��ֱ�ӷ��� false
				if (target < min) { 
					return false;
					
				} else if (target > max) { // ��Ŀ��ֵ���ڵ�ǰ�����ֵ������ȵ�ǰ���е��κ�Ԫ�ض�Ҫ��������ǰ��
					continue;
				}

				// ��Ŀ��ֵλ�ڵ�ǰ����Сֵ�����ֵ֮�䣬����ж������������ҵ���ֱ�ӷ��� true
				if (Arrays.binarySearch(array[i], target) >= 0)
					return true;
				//���򣬼�������һ��������
				continue;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {};
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
		// System.out.println(binarySearch(arr, 0, arr.length - 1, 4));
	}
}
