package Offer29;

/**
 * Title:�����г��ִ�������һ������� 
 * Description: ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ� �������鳤�ȵ�һ�룬������2����������������0��
 * 
 * @author rico
 * @created 2017��6��2�� ����4:55:15
 */
public class Solution2 {

	/**
	 * @description ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ��,
	 * ��ô������ֳ��ֵĴ����������������ֳ��ִ����ĺͻ�Ҫ�ࡣ
	 * 
	 * ʹ����������A��B������A�洢�����е�ĳ������B������������ʼʱ��B��ʼ��Ϊ0�� 
	 * �������飬���B=0������A���ڵ�ǰ������B����1�������ǰ����A��ͬ����B=B+1��
	 * �����ǰ����A��ͬ������B=B-1����������ʱ��A�е�������Ҫ�ҵ�����
	 *  
	 * @author rico
	 * @created 2017��6��2�� ����8:48:10
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array != null && array.length != 0) {
			int target = 0;  // �洢�����е�ĳ����
			int count = 0;    // ����
			for (int i = 0; i < array.length; i++) {
				if (count == 0) {  
					target = array[i];  
					count = 1;   
				} else {
					if (target == array[i]) {
						count++;
					} else {
						count--;
					}
				}
			}

			// ��֤Target�Ƿ�����������
			if (count > 0) {   // �����յ�count������0����Ȼ������������Ҫ������
				count = 0;  // ͳ��target���ִ���
				for (int i = 0; i < array.length; i++) {
					if (target == array[i]) {
						count++;
					}
				}
				return count > array.length / 2 ? target : 0;
			}
		}
		return 0;
	}

	/**
	 * @description
	 * @author rico
	 * @created 2017��6��2�� ����8:43:55
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(new Solution2().MoreThanHalfNum_Solution(array));
	}
}
