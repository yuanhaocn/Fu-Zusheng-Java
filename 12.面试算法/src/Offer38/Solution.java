package Offer38;

/**
 * Title: ���������������г��ֵĴ���(˫ָ�뷨)
 * Description: ͳ��һ�����������������г��ֵĴ�����
 * 
 * �㷨ʱ�临�Ӷȣ�O(n)
 * 
 * @author rico
 * @created 2017��6��25�� ����4:47:51
 */
public class Solution {
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) {  // �߽�ֵ
			return 0;
		} else if (k < array[0] || k > array[array.length - 1]) {  // �߽�ֵ
			return 0;
		} else if(array.length == 1){  
			return array[0] == k ? 1:0;
		}else {
			int i = 0;
			int j = array.length - 1;
			while (array[i] != k && array[j] != k && j > i) {
				i++;
				j--;
			}
			if (j <= i) {
				return 0;
			} else if (array[i] == k) {
				while (array[j] != k) {
					j--;
				}
			} else if (array[j] == k) {
				while (array[i] != k) {
					i++;
				}
			}
			return j - i + 1;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] array = {3};
		System.out.println(s.GetNumberOfK(array, 3));
	}
}
