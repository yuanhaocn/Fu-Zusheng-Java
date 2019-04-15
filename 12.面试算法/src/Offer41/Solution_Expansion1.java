package Offer41;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Title:��ΪS����������(��Ҫ���������ݹ鷽��)
 * Description: С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�� ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good
 * Luck!
 * 
 * �������: ������к�ΪS���������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 * 
 * @author rico
 * @created 2017��6��28�� ����8:18:42
 */

public class Solution_Expansion1 {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (sum < 3) {     // �ݹ���ֹ����
			return result;     // ���龰�µĴ���
		} else {
			for (int i = 1; i < sum - i; i++) {    // ��С��Χ���ݹ鴦��
				result.add(new ArrayList<Integer>(Arrays.asList(i, sum - i)));
				ArrayList<ArrayList<Integer>> list = FindContinuousSequence(sum
						- i);
				if (list != null) {
					for (ArrayList<Integer> tmpList : list) {
						if (tmpList.get(0) > i) {
							// System.out.println("tmpList : " + tmpList);
							ArrayList<Integer> tmp = new ArrayList<Integer>();
							tmp.add(i);
							tmp.addAll(tmpList);
							result.add(tmp);
						}
					}
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution_Expansion1 s = new Solution_Expansion1();
		int sum = 15;
		System.out.println(s.FindContinuousSequence(sum));
	}
}
