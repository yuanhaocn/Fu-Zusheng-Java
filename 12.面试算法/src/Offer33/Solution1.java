package Offer33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Title:�������ų���С����
 * Description:����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����������������
 * {3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * 
 * @author rico
 * @created 2017��6��21�� ����9:08:42
 */
public class Solution1 {
	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return "";
		} else if (numbers.length == 1) {
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
				int min = Math.min(s1.length(), s2.length());
				for (int i = 0; i < min; i++) {
					if (i < s2.length()) {
						if (s1.charAt(i) > s2.charAt(i)) {
							return 1;
						} else if (s1.charAt(i) < s2.charAt(i)) {
							return -1;
						} else {
							continue;
						}
					}
				}
				
				if (s1.length() > min) {
					for (int j = min; j < s1.length(); j++) {
						if (s2.charAt(min-1) > s1.charAt(j)) {
							return -1;
						} else if (s2.charAt(min-1) < s1.charAt(j)) {
							return 1;
						} else {
							if (j == s1.length()-1) {
								return 0;
							}
							continue;
						}
					}
				}else{
					for (int j = min; j < s2.length(); j++) {
						if (s1.charAt(min-1) > s2.charAt(j)) {
							return 1;
						} else if (s1.charAt(min-1) < s2.charAt(j)) {
							return -1;
						} else {
							if (j == s2.length()-1) {
								return 0;
							}
							continue;
						}
					}
				}
				return 0;
			}
		});
	}
}
