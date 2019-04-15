package Offer8;

/**
 * Title: ��ת�������С���� (����������Ӧ�ã�����������߲�������) ���� �ݹ��㷨�ͷǵݹ��㷨 
 * Description:
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * 
 * @author rico
 * @created 2017��6��4�� ����11:26:50
 */
public class Solution1 {
	public int minNumberInRotateArray(int[] array) {
		return minNumberInRotateArray(array, 0, array.length - 1);
	}

	/**
	 * @description �۰����������ж���СԪ��λ���ĸ������У�ǰ�����л��ߺ�������
	 * @author rico
	 * @created 2017��6��4�� ����1:42:12
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public int minNumberInRotateArray(int[] array, int low, int high) {
		int mid = 0;
		while (array[low] >= array[high]) {
			if (high - low == 1) { // ѭ���˳�����
				mid = high;
				break;
			}

			mid = (low + high) / 2;
			if (array[mid] >= array[low]) { // ��Сֵֻ����λ�������ұ�(��������)
				low = mid;
			} else if (array[mid] <= array[high]) { // ��Сֵֻ����λ���������(��������)
				high = mid;
			}

		}
		return array[mid];
	}

	  
	/**     
	 * @description �۰����������ж���СԪ��λ���ĸ������У�ǰ�����л��ߺ�������
	 * @author rico       
	 * @created 2017��6��4�� ����2:01:43     
	 * @param array
	 * @param low
	 * @param high
	 * @return     
	 */
	public int minNumberInRotateArray_Recursive(int[] array, int low, int high) {
		if (high - low != 1) {   			// �ݹ���ֹ����
			int mid = (low + high) / 2;
			if (array[mid] >= array[low]) {
				return minNumberInRotateArray_Recursive(array, mid, high);  
			} else if (array[mid] <= array[high]) {
				return minNumberInRotateArray_Recursive(array, low, mid);
			}
		}
		return array[high];
	}

	public static void main(String[] args) {
		int[] input = { 1, 1, 1, 1, 1 };
		System.out.println(new Solution1().minNumberInRotateArray(input));
	}
}
