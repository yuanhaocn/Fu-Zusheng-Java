package Offer8;

/**        
 * Title: ��ת�������С����    
 * Description: ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * @author rico       
 * @created 2017��6��4�� ����11:26:50    
 */      
public class Solution2 {

	/**     
	 * @description ��˳�������ת��[O(n)],�ٷ�����СԪ��[O(1)]���ܵ�ʱ�临�Ӷ�O(n)
	 * @author rico       
	 * @created 2017��6��4�� ����11:24:41     
	 * @param array
	 * @return     
	 */
	public int minNumberInRotateArray(int[] array) {
		if (array != null || array.length == 0 ) {
			if (array.length != 1) {
				// ˳�������ת��:O(n)
				int index = 0;
				for (int i = 0; i < array.length; i++) {
					if (i + 1 < array.length) {
						if (array[i+1] < array[i]) {
							index = i + 1;
							break;
						}
					}
				}
				
				// ���ֲ���
				return array[index];
			}
			return array[0];
		}
		return 0;
	}
}
