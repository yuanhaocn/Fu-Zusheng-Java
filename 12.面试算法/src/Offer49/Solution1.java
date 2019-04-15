package Offer49;

/**
 * Title: ���ַ���ת�������� Description:��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯����
 * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0 ��������: ����һ���ַ���,����������ĸ����,����Ϊ��
 * �������:����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
 *
 *
 * ���룺 +2147483647 1a33
 * 
 * 
 * ��� 2147483647 0
 * 
 * @author rico
 * @created 2017��7��2�� ����3:03:46
 */
public class Solution1 {

	/**
	 * @description ��λ����
	 * @author rico
	 * @created 2017��7��2�� ����3:15:39
	 * @param str
	 * @return
	 */
	public int StrToInt(String str) {
		if (str != null && str.length() != 0) {
			char[] arr = str.toCharArray();
			int num = 0;
			int end = arr.length - 1;

			// ����λ֮����ַ�
			for (int i = end; i > 0; i--) {
				if ('0' <= arr[i] && arr[i] <= '9') {
					num += (arr[i] - 48) * power_optimized(10, end - i);
				} else {
					return 0;
				}
			}
			
			// ����������λ
			if (arr[0] == '+') {
				return num;
			} else if (arr[0] == '-') {
				return -num;
			} else if ('0' <= arr[0] && arr[0] <= '9') {
				num += (arr[0] - 48) * power_optimized(10, end);
				return num;
			} else {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * @description ������
	 * @author rico
	 * @created 2017��7��2�� ����4:06:24
	 * @param a
	 * @param b
	 * @return
	 */
	public int power(int a, int b) {
		if (b == 0) {
			return 1;
		} else {
			return a * power(a, b - 1);
		}
	}

	/**
	 * @description �Ż����������(������˵Ĵ���)
	 * @author rico
	 * @created 2017��7��2�� ����4:06:41
	 * @param a
	 * @param b
	 * @return
	 */
	public int power_optimized(int a, int b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		} else {
			int mid = b >> 1;
			int result = power_optimized(a, mid);
			result *= result;
			if ((b & 1) == 1) {
				result *= a;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String str = "-1209";
		System.out.println(s.StrToInt(str));
	}
}
