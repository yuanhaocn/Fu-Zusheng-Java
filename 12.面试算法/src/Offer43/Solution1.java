package Offer43;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: n �����ӵĵ���(�����ⷨ)
 * Description: ��n���������ڵ��ϣ��������ӳ��ϵ�һ�����֮�ͼ�Ϊs.
 * ����n,��ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 * 
 * �����Ӹ���Ϊkʱ��Ϊi��Ƶ��ʱ,ʵ���������Ӹ���Ϊk-1ʱ����Ϊi-1,i-2,...,i-6��Ƶ���ĺ�
 * 
 * @author rico
 * @created 2017��6��29�� ����2:54:34
 */
public class Solution1 {

	public static Map<Integer, Integer> printProbability(int number) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (number < 1)
			return map;
		int g_maxValue = 6;
		int[][] probabilities = new int[2][];
		probabilities[0] = new int[g_maxValue * number + 1];
		probabilities[1] = new int[g_maxValue * number + 1];
		int flag = 0;
		
		// ֻ��һ�����ӵ�����
		for (int i = 1; i <= g_maxValue; i++)
			probabilities[0][i] = 1;
		
		for (int k = 2; k <= number; ++k) {
			// k�����ӵ�������СΪk,��������ǰk��λ�ó�ʼ��Ϊ0
			for (int i = 0; i < k; ++i)
				probabilities[1 - flag][i] = 0;

			// ����С��k��,�����Ӹ���Ϊk-1ʱ�ĺ͵ķֲ��Ļ����ϣ����μ��������Ӹ���Ϊkʱ�ĺ�ֵ�ķֲ�
			for (int i = k; i <= g_maxValue * k; ++i) {
				probabilities[1 - flag][i] = 0; // �ȳ�ʼ��Ϊ0
				// �����Ӹ���Ϊkʱ��Ϊi��Ƶ��ʱ,ʵ���������Ӹ���Ϊk-1ʱ����Ϊi-1,i-2,...,i-6��Ƶ���ĺ�
				for (int j = 1; j <= i && j <= g_maxValue; ++j)
					probabilities[1 - flag][i] += probabilities[flag][i - j];
			}
			flag = 1 - flag;
		}
		
		
		for (int i = number; i <= g_maxValue * number; i++) {
			map.put(i, probabilities[flag][i]);
		}
		return map;
	}

	public static void main(String[] args) {
		int n = 3;
		Map<Integer, Integer> map = Solution1.printProbability(n);
		int s = 0;
		for (int tmp : map.values()) {
			s += tmp;
		}
		System.out.println(s);
		System.out.println(map);
	}
}
