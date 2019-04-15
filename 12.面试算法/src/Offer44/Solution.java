package Offer44;

import java.util.Arrays;

/**
 * Title: �˿���˳�� Description:
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)
 * ...��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��
 * ,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh My
 * God!������˳��.....LL��������,��������,������\С
 * �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So
 * Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
 * 
 * @author rico
 * @created 2017��7��1�� ����10:50:49
 */
public class Solution {
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length != 5) {
			return false;
		} else {
			// ����
			Arrays.sort(numbers);
			int start = 0;
			int count = 0; // ���������д�С���ĸ���
			int needs = 0; // ����Ҫ���Ϊ˳����Ҫ��С���ĸ���

			// �ҵ���һ����0���ֵ�λ��
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] != 0) {
					start = i;
					count = i;
					break;
				}
			}

			// ����Ҫ���Ϊ˳����Ҫ��С���ĸ���
			for (int i = start; i < numbers.length - 1; i++) {
				if (numbers[i] == numbers[i + 1]) {
					return false;
				} else {
					needs += (numbers[i + 1] - numbers[i] - 1);
				}
			}
			return count >= needs ? true : false;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int numbers[] = { 1, 3, 0, 0, 0 };
		System.out.println(s.isContinuous(numbers));
	}
}