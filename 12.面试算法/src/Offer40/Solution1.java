package Offer40;

/**
 * Title:������ֻ����һ�ε����� (������㣬����������㽻����)
 * Description: һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * ʱ�临�Ӷȣ�O(n)
 * �ռ临�Ӷȣ�O(1)
 * @author rico
 * @created 2017��6��28�� ����5:11:23
 */
public class Solution1 {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		// �߽�����
		if (array == null || array.length < 2) {
			return;
		}
		
		// ����������㽻���ɣ�������ͬ���������������Ȼ��Ϊ0
		int or = 0;
		for (int i = 0; i < array.length; i++) {
			or ^= array[i];
		}
		
		// ����һ�����ֵĶ����Ʊ�ʾ�������������һ��Ϊ1��Bitλ
		int index = findFirstBitis1(or);
		
		for (int i = 0; i < array.length; i++) {
			// �� index λ�Ƿ�Ϊ 1 ��Ϊ����
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];  // һ��������0������ԭ��������
			}else{
				num2[0] ^= array[i];  // һ��������0������ԭ��������
			}
		}
	}

	  
	/**     
	 * @description ����һ�����ֵĶ����Ʊ�ʾ�������������һ��Ϊ1��Bitλ
	 * @author rico       
	 * @created 2017��6��28�� ����6:21:22     
	 */
	public int findFirstBitis1(int tmp) {
		int i = 1;
		int index = 0;
		while ((i & tmp) != i) {
			i <<= 1;
			index++;
		}
		return index;
	}

	/**     
	 * @description ����һ�����ֵĶ����Ʊ�ʾ���ж���indexλ�Ƿ�Ϊ1
	 * @author rico       
	 * @created 2017��6��28�� ����6:21:22     
	 */
	public boolean isBit1(int tmp, int index){
		tmp = tmp >> index;
		return (tmp & 1) == 1 ? true : false ;
	}
}
