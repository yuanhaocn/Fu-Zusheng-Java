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
public class GreatestSolution {
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
	 * @description ΪInteger�����µ��������,����رȽϴ�С
	 * @author rico
	 * @created 2017��6��21�� ����3:07:46
	 * @param list
	 */
	public void sort(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {
			/** 
			 * @description o1o2��o2o1���ȴ�С��ͬ��Ҫ��Ƚ�o1��o2�Ĵ�С��ֻ��Ƚ�o1o2��o2o1�Ĵ�С
			 * @author rico       
			 * @created 2017��6��21�� ����3:51:19      
			 * @param o1
			 * @param o2
			 * @return     
			 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)     
			 */  
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String s1 = String.valueOf(o1) + String.valueOf(o2);
				String s2 = String.valueOf(o2) + String.valueOf(o1);
				if (Long.valueOf(s1) > Long.valueOf(s2)) {  // ��Long�Ƚϣ���������
					return 1;
				}else if(Long.valueOf(s1) < Long.valueOf(s2)){
					return -1;
				}else{
					return 0;
				}
			}
		});
	}

	public static void main(String[] args) {
		GreatestSolution s = new GreatestSolution();
		int[] numbers = { 3334, 3, 3333332 };
		System.out.println(s.PrintMinNumber(numbers));
	}
}
