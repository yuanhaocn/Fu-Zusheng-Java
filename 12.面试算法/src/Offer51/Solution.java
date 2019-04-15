package Offer51;

import java.util.Arrays;

/**
 * Title:�������ظ������֣��ⷨ��������ĿOffer35����һ��ֻ����һ�ε��ַ������׹�ϣ��
 * Description: ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�
 * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * 
 * ʱ�临�Ӷȣ�O(n)
 * 
 * �ռ临�Ӷȣ�O(n)
 * 
 * @author rico
 * @created 2017��7��3�� ����4:38:19
 */
public class Solution {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers != null && length > 0 && duplication.length > 0) {
			boolean[] hash = new boolean[length];   // ���׹�ϣ��
			for (int num : numbers) {
				if (!hash[num]) {
					hash[num] = true;
				}else{
					duplication[0] = num;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] test = {2,3,1,0,2,5,3};
		int[] duplication = new int[1];
		System.out.println(s.duplicate(test, test.length, duplication));
		System.out.println(Arrays.toString(duplication));
	}
}