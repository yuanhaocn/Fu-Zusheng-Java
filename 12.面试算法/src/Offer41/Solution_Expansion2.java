package Offer41;

import java.util.ArrayList;

/**
 * Title:��ΪS����� (˫ָ�뷨) 
 * Description: ����һ����������������һ������S���������в������������ǵ����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * 
 * @author rico
 * @created 2017��6��28�� ����8:18:42
 */

public class Solution_Expansion2 {
	public ArrayList<Integer> FindPairs(int[] arr, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (arr != null && arr.length < 2) {
			return result;
		} else {
			int p1 = 0; // ��ָ��
			int p2 = arr.length - 1; // βָ��
			int cursum;
			while (p1 < p2) {
				cursum = arr[p1] + arr[p2];
				if (cursum == sum) { // cursum == sum ����ʱ, ��βָ�������£
					result.add(arr[p1]);
					result.add(arr[p2]);
					return result;
				} else if (cursum < sum) { // cursum < sum ����ʱ����ָ������
					p1++;
				} else { // cursum > sum ����ʱ��βָ������
					p2--;
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution_Expansion2 s = new Solution_Expansion2();
		int[] arr = { 1, 3, 4, 4, 7, 11, 12, 15 };
		int sum = 15;
		System.out.println(s.FindPairs(arr, sum));
	}
}
