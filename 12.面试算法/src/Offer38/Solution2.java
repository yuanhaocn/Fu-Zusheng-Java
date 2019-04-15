package Offer38;

/**
 * Title: ���������������г��ֵĴ���(���ֲ����㷨�ı��� ����������k�״γ���λ�ú�ĩ�γ���λ��) 
 * Description: ͳ��һ�����������������г��ֵĴ�����
 * 
 * �㷨ʱ�临�Ӷȣ�O(lgN)
 * 
 * @author rico
 * @created 2017��6��25�� ����4:47:51
 */
public class Solution2 {
	public int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) { // �߽�����
			return 0;
		} else if (k < array[0] || k > array[array.length - 1]) { // �߽�����
			return 0;
		} else {
			// �Ȳ�������k�״γ��ֵ�λ��:O(lgN)
			int first = getFirstK(array, 0, array.length - 1, k);
			// �ٲ�������k�����ֵ�λ��:O(lgN)
			int last = getLastK(array, 0, array.length - 1, k);

			if (first == -1 || last == -1) {
				return 0;
			} else {
				return last - first + 1;
			}
		}
	}

	/**
	 * @description ���ֲ����㷨�ĸĽ����ҵ�һ��K���ֵ�λ��
	 * @author rico
	 * @created 2017��6��26�� ����3:53:02
	 */
	public int getFirstK(int[] array, int from, int to, int k) {
		if (from > to) { // �ݹ���ֹ����
			return -1; // ���龰�µĴ���
		} else {
			int mid = (from + to) / 2;
			if (array[mid] == k) {
				if (mid > 0 && array[mid - 1] == k) {
					return getFirstK(array, from, mid - 1, k);
				}
				return mid;
			} else if (array[mid] < k) {
				return getFirstK(array, mid + 1, to, k); // ȥ�������в���
			} else {
				return getFirstK(array, from, mid - 1, k); // ȥ�������в���
			}
		}
	}

	/**
	 * @description ���ֲ����㷨�ĸĽ��������һ��K���ֵ�λ��
	 * @author rico
	 * @created 2017��6��26�� ����3:53:02
	 */
	public int getLastK(int[] array, int from, int to, int k) {
		if (from > to) { // �ݹ���ֹ����
			return -1; // ���龰�µĴ���
		} else {
			int mid = (from + to) / 2;
			if (array[mid] == k) {
				if (mid < array.length - 1 && array[mid + 1] == k) {
					return getLastK(array, mid + 1, array.length - 1, k);
				}
				return mid;
			} else if (array[mid] < k) {
				return getLastK(array, mid + 1, to, k); // ȥ�������в���
			} else {
				return getLastK(array, from, mid - 1, k); // ȥ�������в���
			}
		}
	}

	public static void main(String[] args) {
		Solution2 s1 = new Solution2();
		int[] array = { 3, 3, 3, 3, 3, 3 };
		int k = 3;
		System.out.println("���� " + k + " �״γ��ֵ�λ�� �� "
				+ s1.getFirstK(array, 0, array.length - 1, k));
		System.out.println("���� " + k + " �����ֵ�λ�� �� "
				+ s1.getLastK(array, 0, array.length - 1, k));
		System.out.println(s1.GetNumberOfK(array, k));
	}
}
