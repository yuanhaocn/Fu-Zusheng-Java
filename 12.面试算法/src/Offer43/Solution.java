package Offer43;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: n �����ӵĵ���(�ݹ�ⷨ)
 * Description: ��n���������ڵ��ϣ��������ӳ��ϵ�һ�����֮�ͼ�Ϊs.
 * ����n,��ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 * 
 * ��n�����ӷ�Ϊ���ѣ�һ��ֻ��һ�����ӣ���һ�ѹ�n-1�����ӡ����У���һ����Ψһ�����ӳ��ֵĵ���������1~6��ʣ�µĵڶ����е��������ӵĵ�����Ϊ(n-6)~
 * (n-1),��������
 * 
 * @author rico
 * @created 2017��6��29�� ����2:54:34
 */
public class Solution {

	Map<Integer, Double> map = new HashMap<Integer, Double>();

	public static Map<Integer, Integer> caculate(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (n > 0) {
			int min = n;
			int max = 6 * n;
			int mid = (min + max) / 2;
			for (int i = min, j = max; i <= mid; i++, j--) { // ����֮�ͳ��ֵ�Ƶ���ǶԳƵ�
				int num = count(n, i);
				map.put(i, num);
				map.put(j, num);
			}
		}
		return map;
	}

	/**
	 * @description ����n�����ӵ�����Ϊsum������
	 *              �㷨����n�����ӷ�Ϊ���ѣ�һ��ֻ��һ�����ӣ���һ�ѹ�n-1�����ӡ����У���һ����Ψһ�����ӳ��ֵĵ���������1~6��
	 *              ʣ�µĵڶ����е��������ӵĵ�����Ϊ(n-6)~(n-1),�������ơ�
	 * @author rico
	 * @param n
	 * @param sum
	 */
	public static int count(int n, int sum) {
		int result = 0;
		if (n == 1) { // �ݹ���ֹ����
			// ���龰�µĴ���
			if (sum > 6 || sum < 1) {
				return result;
			} else {
				result = 1;
				return result;
			}
		} else { // ��С��ģ���ݹ���
			for (int i = 1; i <= 6; i++) {
				result += count(n - 1, sum - i);
			}
			return result;
		}
	}

	public static void main(String[] args) {
		int n = 3;
		int sum = 7;
		System.out.println(Solution.count(n, sum));
		Map<Integer, Integer> map = Solution.caculate(n);
		int s = 0;
		for (int tmp : map.values()) {
			s += tmp;
		}
		System.out.println(s);
		System.out.println(map);
	}
}
