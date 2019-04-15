package BinarySearch;

/**
 * Title: ���ֲ��ҵ�ʵ�� 
 * Description: �ݹ� + �ǵݹ�
 * 
 * @author rico
 */
public class BinarySearch {

	/**     
	 * @description �ݹ�����Ŀ��ֵ���������ɹ����򷵻�Ŀ��ֵ�Ĵ���(��1��ʼ)�����򣬷���-1
	 * ������Χ���ϵ���С����ÿ�����������У�Ҫô�ҵ�ָ��Ԫ�أ�Ҫô��С��Χ��
	 * ���������յ��µĽ���ǣ������ҵ�Ŀ��Ԫ�ػ��� low > high(�������ȥ������ֹͣ�ݹ飬��ʼ����)
	 * 
	 * @author rico       
	 * @param arr Ŀ������
	 * @param high �ұ߽�
	 * @param low ��߽�
	 * @param target Ŀ��ֵ
	 * @return     
	 */
	public static int binarySearch(int[] arr, int high, int low, int target) {
		
		if (high >= low) { // �ݹ���ֹ����
			int mid = (high + low) >> 1;
			if (arr[mid] == target) {
				return mid + 1;
			} else if (arr[mid] > target) { //arr[mid]�϶�����Ŀ��ֵ�����޳�������Χ
				return binarySearch(arr, mid - 1, low, target);  // �ݹ���������С����Ĺ�ģ
			} else { //arr[mid]�϶�����Ŀ��ֵ�����޳�������Χ
				return binarySearch(arr, high, mid + 1, target);  // �ݹ���������С����Ĺ�ģ
			}
		}
		return -1;
	}
	
	/**     
	 * @description ���ֲ��ҵķǵݹ�ʵ��
	 * @author rico       
	 * @param arr Ŀ������
	 * @param high �ұ߽�
	 * @param low ��߽�
	 * @param target Ŀ��ֵ
	 * @return     
	 */
	public static int binarySearch_Loop(int[] arr, int high, int low, int target) {
		
		while (high >= low) { // ѭ����ֹ����
			int mid = (high + low) >> 1;
			if (arr[mid] == target) {
				return mid + 1;
			} else if (arr[mid] > target) { 
				high = mid -1;   //arr[mid]�϶�����Ŀ��ֵ�����޳�������Χ
			} else { 
				low = mid + 1;   //arr[mid]�϶�����Ŀ��ֵ�����޳�������Χ
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3};
		System.out.println("Recursive : " + binarySearch(arr, arr.length-1, 0, 3));
		System.out.println("Loop : " + binarySearch(arr, arr.length-1, 0, 3));
	}
}
