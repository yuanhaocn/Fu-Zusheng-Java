package Offer33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Title:�������ų���С����(�����µ�Comparator�������µ��������)����������һ����������
 * Description:����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����������������
 * {3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * 
 * @author rico
 * @created 2017��6��21�� ����9:08:42
 */
public class Solution {
	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) { // �߽�����
			return "";
		} else if (numbers.length == 1) { // �߽�����
			return String.valueOf(numbers[0]);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			for (int tmp : numbers) {
				list.add(tmp);
			}

			// �����µ��������
			sort(list);
			System.out.println(list);

			StringBuilder sb = new StringBuilder();
			for (Integer tmp : list) {
				sb.append(tmp);
			}
			return sb.toString();
		}
	}

	/**
	 * @description ΪInteger�����µ��������
	 * @author rico
	 * @created 2017��6��21�� ����3:07:46
	 * @param list
	 */
	public void sort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String s1 = String.valueOf(o1);
				String s2 = String.valueOf(o2);
				// ������߳��ȣ����ҵ��ϴ󳤶�
				int n = Math.max(s1.length(), s2.length()); 
				
				// �����Ƚ϶̵���������ĩλ���룬ֱ�� s1��s2�������
				if (s1.length() > s2.length()) {
					StringBuilder sb = new StringBuilder(s2);
					char c = s2.charAt(s2.length() - 1);
					for (int i = s2.length(); i < n; i++) {
						sb.append(c);
					}
					s2 = sb.toString();
				} else if (s1.length() < s2.length()) {
					StringBuilder sb = new StringBuilder(s1);
					char c = s1.charAt(s1.length() - 1);
					for (int i = s1.length(); i < n; i++) {
						sb.append(c);
					}
					s1 = sb.toString();
				}
				
				// ��λ�Ƚ�
				for (int i = 0; i < n; i++) {
					if (s1.charAt(i) > s2.charAt(i)) {
						return 1;
					} else if (s1.charAt(i) < s2.charAt(i)) {
						return -1;
					} else {
						continue;
					}
				}
				return 0;
			}
		});
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = { 3334, 3, 3333332 };
		System.out.println(s.PrintMinNumber(numbers));
	}
}
