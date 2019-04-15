package Offer29;

/**
 * Title:�����г��ִ�������һ������� 
 * Description: ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ� �������鳤�ȵ�һ�룬������2����������������0��
 * 
 * @author rico
 * @created 2017��6��2�� ����4:55:15
 */
public class Solution {
	/**     
	 * @description ��������д��ڳ��ִ�������һ������֣���ô���Ȼ��array[array.length/2];
	 * ���仰˵�����array[array.length/2]���ֵĴ���û�г���һ�룬��ô�Ͳ���������������
	 * @author rico       
	 * @created 2017��6��2�� ����6:18:51     
	 * @param array
	 * @return     
	 */
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array != null && array.length != 0) {
			int mid = array[array.length / 2];    
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				if (mid == array[i]) {
					count++;
				}
			}
			return count > array.length / 2 ? mid : 0;
		}
		return 0;
	}
}
