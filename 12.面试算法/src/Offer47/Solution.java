package Offer47;

/**
 * Title:���üӼ��˳����ӷ� 
 * Description: дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 * 
 * �������ֵļ��㣬���˼Ӽ��˳��⣬��ʣ��λ����(���֣�&,|,^,<<,>>)��
 * 
 * @author rico
 * @created 2017��7��2�� ����2:07:34
 */
public class Solution {
	public int Add(int num1, int num2) {
		// �ȶ��������������(�˲�������λ����λ����һ����),ʵ�������������
		int sum = num1 ^ num2;
		// �����λ���㣬ʵ������������
		int carry = (num1 & num2) << 1;

		if (carry == 0) { 	// �ݹ���ֹ����(���龰)��û�н�λ
			return sum;	  // ���龳�µĴ���
		} else { 	// �ݹ����sum���λ�ĺ�
			return Add(sum, carry);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.Add(15, 87));
	}
}
