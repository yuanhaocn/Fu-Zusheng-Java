package �鲢����;

public class Snippet {
	public static void merge_sort(int[] arr) {
		int len = arr.length;
		// ���ںϲ�����ʱ����
		int[] result = new int[len];
		int block, start;

		/*
		 * block = 1   low mid high(index)
		 * start = 0	0	1	2
		 * start = 2	2	3	4
		 * start = 4	4	5	6
		 * start = 6	6	7	8
		 * 
		 * block = 2:
		 * start = 0	0	2	4
		 * start = 4	4	6	8
		 * 
		 * block = 4:
		 * start = 0	0	4	8
		 * 
		 * block = 8:
		 * start = 0	0	8	8
		 * 
		 */
		// �����ϲ�����С������� (ע�����һ��block����len)
		for (block = 1; block <= len; block *= 2) {
			// ����������ֳɺܶ���飬ÿ�κϲ�����������
			for (start = 0; start < len; start += 2 * block) {

// ********************************************************************************************//
				int low = start;
				int mid = (start + block) < len ? (start + block) : len;
				int high = (start + 2 * block) < len ? (start + 2 * block) : len;
				// ���������ʼ�±꼰�����±�
				int start1 = low, end1 = mid;
				int start2 = mid, end2 = high;
// ********************************************************************************************//

// ********************************************************************************************//
				// ��ʼ������block���й鲢����
				while (start1 < end1 && start2 < end2) {
					result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
				}
				while (start1 < end1) {
					result[low++] = arr[start1++];
				}
				while (start2 < end2) {
					result[low++] = arr[start2++];
				}
// ********************************************************************************************//

			}
			// ÿ�ι鲢��ѽ��result����arr�У��Ա�����´ι鲢
			int[] temp = arr;
			arr = result;
			result = temp;
		}

	}

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		merge_sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
