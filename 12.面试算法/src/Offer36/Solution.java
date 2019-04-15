package Offer36;

import java.util.Arrays;

/**
 * Title:�����е������(�鲢�����㷨��Ӧ��)
 * Description:�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P
 * ������P��1000000007ȡģ�Ľ������� �����P%1000000007
 * 
 * ��������: ��Ŀ��֤�����������û�е���ͬ������
 * 
 * ���ݷ�Χ������%50������,size<=10^4 ����%75������,size<=10^5 ����%100������,size<=2*10^5
 * 
 * ��������: 1,2,3,4,5,6,7,0
 * 
 * �������: 7
 * 
 * ʱ�临�Ӷ�O(nlgn),�ռ临�Ӷ�O(n),���ʼ�����޹�
 * 
 * ����ȡ�������ȥ���ٴζ�û�й�ϵ
 * 
 * @author rico
 * @created 2017��6��24�� ����11:07:55
 */
public class Solution {

	public int InversePairs(int[] array) {
		if (array == null || array.length < 2) {
			return 0;
		} else {
			int[] tmp = Arrays.copyOf(array, array.length); // �����洢�ռ�
			int result = InversePairs(array, 0, array.length - 1, tmp);
			return result;
		}
	}
	
	/**     
	 * @description ���ƹ鲢����
	 * @author rico       
	 * @created 2017��6��25�� ����3:28:05        
	 */
	public int InversePairs(int[] array, int from, int to, int[] tmp) {
		if (from == to) {
			return 0;
		} else {
			int mid = (from + to) / 2;
			int left = InversePairs(array, from, mid, tmp) % 1000000007;
			int right = InversePairs(array, mid + 1, to, tmp) % 1000000007;
			int merge = merge(array, from, mid, to, tmp);
			int sum = (left + right + merge) % 1000000007;
			return sum;
		}
	}

	/**
	 * @description �鲢����ĺϲ�����
	 * @author rico
	 * @created 2017��6��25�� ����3:20:46
	 */
	public int merge(int[] array, int from, int mid, int to, int[] tmp) {
		int p1 = mid;
		int p2 = to;
		int cur = to;
		int result = 0;  

		// ��������������������ĩ�˱���
		while (p1 >= from && p2 >= mid + 1) {
			if (tmp[p1] > tmp[p2]) {
				result += p2 - mid;
				if (result > 1000000007) {
					result %= 1000000007;
				}
				array[cur] = tmp[p1];
				p1--;
				cur--;
			} else {
				array[cur] = tmp[p2];
				p2--;
				cur--;
			}
		}

		// �������黹��Ԫ��
		while (p1 >= from) {
			array[cur] = tmp[p1];
			cur--;
			p1--;
		}

		// �������黹��Ԫ��
		while (p2 >= mid + 1) {
			array[cur] = tmp[p2];
			cur--;
			p2--;
		}

		// ���¸�������tmp
		for (int i = from; i <= to; i++) {
			tmp[i] = array[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] array = { 1, 2, 3, 4, 5, 1, 7, 0 };
		// int[] array = {7, 5, 6, 4};
		System.out.println("����� ��" + s.InversePairs(array));
		System.out.println(Long.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
