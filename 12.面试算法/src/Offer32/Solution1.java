package Offer32;

/**
 * Title: ������1���ֵĴ�������1��n������1���ֵĴ����� 
 * Description:ʱ�临�Ӷȣ�O(lgn)
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������1
 * ��10��11��12��13��˹�����6��
 * ,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�����
 * 
 * ���Ƽ���ÿ�����Ķ����Ʊ�ʾ��1�ĸ�������������ͨ����2(ֻ��������)������1�ĸ�����ʮ����ͨ����10������1�ĸ���
 * 
 * ʮ���Ƶ�λ����lgN+1
 * 
 * @author rico
 * @created 2017��6��20�� ����9:15:47
 */
public class Solution1 {

	/**
	 * @description
	 * @author rico
	 * @created 2017��6��20�� ����10:45:31
	 * @param n
	 * @return
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		if (n <= 0) {
			return 0;
		}
		return NumberOf1(String.valueOf(n));
	}

	/**
	 * @description ����ÿ������1�ĸ�������������ͨ����2(ֻ��������)������1�ĸ�����ʮ����ͨ����10������1�ĸ���
	 * @author rico
	 * @created 2017��6��20�� ����10:45:09
	 * @param n
	 * @return
	 */
	public int NumberOf1(String str) {
		int first = str.charAt(0) - '0';
		int length = str.length();

		if (length == 1) {
			return first > 0 ? 1 : 0;
		}

		// ����str��21345
		// numFirstDigit����10000~19999�ĵ�һ��λ�е���Ŀ
		int numFirstDigit = 0;
		if (first > 1) {
			numFirstDigit = (int) Math.pow(10, length - 1);
		} else if (first == 1) {
			numFirstDigit = Integer.valueOf(str.substring(1)) + 1;
		}

		// numOtherDigits��1346~21345���˵�һλ֮�����λ����Ŀ�� 2 * 4 * 10^3
		int numOtherDigits = (int) (first * (length - 1) * Math.pow(10,
				length - 2));
		
		// numRecursive��1~1345�е���Ŀ
		int numRecursive = NumberOf1(str.substring(1));

		return numFirstDigit + numOtherDigits + numRecursive;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		Solution1 s1 = new Solution1();
		int target = 9;
		System.out.println("s : " + s.NumberOf1Between1AndN_Solution(target));
		System.out.println("s1 : " + s1.NumberOf1Between1AndN_Solution(target));

	}
}
