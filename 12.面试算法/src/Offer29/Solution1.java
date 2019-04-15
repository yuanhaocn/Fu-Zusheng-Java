package Offer29;

/**
 * Title:�����г��ִ�������һ������� -----> ת��������λ������
 * Description: ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ� �������鳤�ȵ�һ�룬������2����������������0��
 * 
 * @author rico
 * @created 2017��6��2�� ����4:55:15
 */
public class Solution1 {
	
	/**
	 * @description �������д��ڳ��ִ�������һ������֣������Ȼ���������λ����
	 * ��֮����λ����һ���������г��ִ�������һ������֡���ˣ��ȸ��ݿ��ŵĻ����㷨��
	 * ���϶����н��л��֣��ҵ���λ����Ȼ����֤��λ���Ƿ������ĿҪ��
	 * 
	 * ��λ�����������޵�����������ͨ�������й۲�ֵ�ߵ�������ҳ����м��һ����Ϊ��λ����
	 * 
	 * ����֪�������������г���nΪż������ô��λ���ͻ�������Ԫ�أ����������г���nΪ������
	 * ��ô��λ����ֻ��һ��Ԫ�ء����ͱ�����˵�����������ں��ڻ���Ҫ��֤��ȡn/2�Ϳ����ˡ�
	 *  
	 * @author rico
	 * @created 2017��6��3�� ����8:38:04
	 * @param input ԭʼ����
	 * @return
	 */
	 public int MoreThanHalfNum_Solution(int[] input) {
		int target = 0; // �洢Ŀ��ֵ
		int count = 0;   // ��������֤
		int n = input.length;   // �������г���
		int mid = n/2;     // ��λ
		if (input != null && input.length != 0) {
			int start = 0;
			int end = n - 1;
			int index = partition(input, start, end);
			while (index != mid) { // ѭ����ֹ���������ֵ�����
//			System.out.println(Arrays.toString(input));
				if (index > mid) {
					end = index - 1;
					index = partition(input, start, end);
				} else {
					start = index + 1;
					index = partition(input, index + 1, end);
				}
			}
			
			// �ҵ���λ��
			target = input[index];
			
			//�������ֳ��ִ����Ƿ񳬹�һ��
			for (int i = 0; i < input.length; i++) {
				if (target == input[i]) {
					count ++;
				}
			}
		}
		return count > n/2 ? target : 0;
	}

	/**
	 * @description ���ŵĻ����㷨,ʱ�临�Ӷ�O(n)
	 * @author rico
	 * @created 2017��6��3�� ����8:17:54
	 * @param input
	 * @param start
	 * @param end
	 * @return
	 */
	private int partition(int[] input, int start, int end) {
		int base = input[start];
		int base_index = start;
		for (int i = 1 + start; i <= end; i++) {
			if (input[i] < base) {
				base_index++;
				if (base_index != i) {
					int temp = input[base_index];
					input[base_index] = input[i];
					input[i] = temp;
				}
			}
		}
		input[start] = input[base_index];
		input[base_index] = base;
		return base_index;
	}

	public static void main(String[] args) {
		int[] input = {1,2,3,2,2,2,5,4,2};
		System.out.println(new Solution1().MoreThanHalfNum_Solution(input));
	}
}

