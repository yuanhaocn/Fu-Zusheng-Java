package Offer41;

import java.util.ArrayList;

/**
 * Title:��ΪS�������������� (˫ָ�뷨��small �� big) Description:
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�� ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good
 * Luck!
 * 
 * �������: ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 * 
 * @author rico
 * @created 2017��6��28�� ����8:18:42
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (sum < 3) {
			return result;
		} else {
			int small = 1;
			int big = 2;
			int mid = (1 + sum) / 2;
			int cursum = small + big;
			while (small < mid) { // ѭ����ֹ����
				if (cursum == sum) {
					ArrayList<Integer> list = generateList(small, big);
					result.add(list);
				}

				// cursum > sum ʱ, small ����;
				while (cursum > sum && small < mid) {
					cursum -= small;
					small++;
					if (cursum == sum) {
						ArrayList<Integer> list = generateList(small, big);
						result.add(list);
					}
				}

				// cursum < sum ʱ, big ����
				big++;
				cursum += big;
			}
			return result;
		}
	}

	public ArrayList<Integer> generateList(int small, int big) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = small; i <= big; i++) {
			list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int sum = 9;
		System.out.println(s.FindContinuousSequence(sum));
	}
}
