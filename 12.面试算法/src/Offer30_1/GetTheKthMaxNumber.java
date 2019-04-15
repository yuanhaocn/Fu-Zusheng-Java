package Offer30_1;

import java.util.Arrays;
import java.util.Random;

/**        
 * Title: Ԫ�����е�K��Ԫ��    
 * Description: ��K��Ԫ��һ���Ǵ��ڵģ���Ϊ��������ǾͿ���ֱ���ҵ��������㷨������ŵĻ����㷨��
 * ���϶����н��л��֣�ֱ��ĳ�λ�����ɺ��׼Ԫ�ص�λ���ǵ�n-k�����㷨��ʱ�临�Ӷ���O(n)��
 * @author rico       
 * @created 2017��6��3�� ����2:11:48    
 */      
public class GetTheKthMaxNumber {
	/**
	 * @description ��K��Ԫ��һ���Ǵ��ڵģ���Ϊ��������ǾͿ���ֱ���ҵ�����
	 * ���㷨������ŵĻ����㷨�����϶����н��л��֣�ֱ��ĳ�λ�����ɺ��׼Ԫ�ص�λ���ǵ�n-k����
	 * @author rico
	 * @created 2017��6��3�� ����8:38:04
	 * @param input ԭʼ����
	 * @param k ��K��Ԫ��
	 * @return
	 */
	public int getTheKthMaxNumber(int[] input, int k) {
		int target = -1;
		if (input != null && k > 0 && k <= input.length) {
			int n = input.length;
			int start = 0;
			int end = n - 1;
			int index = partition(input, start, end);
			while (index != n - k) { // ѭ����ֹ���������ֵ�����
			// System.out.println(Arrays.toString(input));
				if (index > n - k) {
					end = index - 1;
					index = partition(input, start, end);
				} else {
					start = index + 1;
					index = partition(input, index + 1, end);
				}
			}
			target = input[index];
		}
		return target;
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
	public int partition(int[] input, int start, int end) {
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

		int[] input = new int[1000];
		for (int i = 0; i < input.length; i++) {
			input[i] = new Random().nextInt(10000);
		}

		System.out.println("ԭ���� �� " + Arrays.toString(input));

		int k = 4;
		System.out.println("�� " + k + " ��Ԫ�أ� "
				+ new GetTheKthMaxNumber().getTheKthMaxNumber(input, k));
		System.out.println("���ֽ����������(�ҵ�Ŀ��ֵʱ������) �� " + Arrays.toString(input));
		Arrays.sort(input);
		System.out.println("����������(��֤) �� " + Arrays.toString(input));
	}
}
