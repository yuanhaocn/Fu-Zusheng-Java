package Offer38;

/**
 * Title: ���������������г��ֵĴ���(���ֲ��ҵ�Ӧ��) 
 * Description: ͳ��һ�����������������г��ֵĴ�����
 * 
 * �㷨ʱ�临�Ӷȣ�O(n)
 * 
 * @author rico
 * @created 2017��6��25�� ����4:47:51
 */
public class Solution1 {
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) { // �߽�����
			return 0;
		} else if (k < array[0] || k > array[array.length - 1]) { // �߽�����
			return 0;
		} else {
			// �����ö��������㷨��������k��λ��
			int index = binarySearch(array, 0, array.length - 1, k);
			if (index == -1) { // û���ҵ�����k
				return 0;
			} else {
				int start = index;
				int end = index;

				// ����k����ʼλ��
				while (start - 1 >= 0) {
					if (array[start - 1] != k) {
						break;
					} else {
						start--;
					}
				}

				// ����k��ֹλ��
				while (end + 1 <= array.length - 1) {
					if (array[end + 1] != k) {
						break;
					} else {
						end++;
					}
				}
				return end - start + 1;
			}
		}
	}

	/**
	 * @description ���ֲ����㷨
	 * @author rico
	 * @created 2017��6��26�� ����3:53:02
	 */
	public int binarySearch(int[] array, int from, int to, int k) {
		if (from > to) { // �ݹ���ֹ����
			return -1; // ���龰�µĴ���
		} else {
			int mid = (from + to) / 2;
			if (array[mid] == k) {
				return mid;
			} else if (array[mid] < k) {
				return binarySearch(array, mid + 1, to, k); // ȥ�������в���
			} else {
				return binarySearch(array, from, mid - 1, k); // ȥ�������в���
			}
		}
	}

	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		int[] array = { 3, 3, 3, 3, 4, 5 };
		int k = 3;
		System.out.println(s1.binarySearch(array, 0, array.length - 1, k));
		System.out.println(s1.GetNumberOfK(array, k));
	}
}
