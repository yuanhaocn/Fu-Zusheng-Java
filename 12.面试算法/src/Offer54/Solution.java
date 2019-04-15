package Offer54;

/**
 * Title: ��ʾ��ֵ���ַ���(����/С�� + (E/e) + (����))
 * Description:��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ���"+100","5e2","-123"
 * ,"3.1416"��"-1E-16"����ʾ��ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 * 
 * @author rico
 * @created 2017��7��6�� ����2:19:42
 */
public class Solution {

	/**
	 * @description �ַ����Ƿ��ʾ��ֵ
	 * @author rico
	 * @created 2017��7��6�� ����3:21:49
	 * @param str
	 * @return
	 */
	public boolean isNumeric(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		} else {
			String s = String.valueOf(str);
			int index = s.indexOf('e');
			if (index == -1) {
				index = s.indexOf('E');
			}
			if (index != -1) {
				return (isRoundNumber(s.substring(0, index).toCharArray()) || isDecimalNumber(s
						.substring(0, index).toCharArray()))
						&& isRoundNumber(s.substring(index + 1, s.length())
								.toCharArray());
			} else {
				return isRoundNumber(str) || isDecimalNumber(str);
			}
		}

	}

	/**
	 * @description �ַ����Ƿ��ʾ����(������ + ����)
	 * @author rico
	 * @created 2017��7��6�� ����3:22:17
	 * @param str
	 * @return
	 */
	public boolean isRoundNumber(char[] str) {
		if (str.length == 0) {
			return false;
		} else {
			for (int i = 0; i < str.length; i++) {
				if (i == 0) {
					if (str[0] == '+' || str[0] == '-') {
						continue;
					}
				}
				if (!(str[i] >= '0' && str[i] <= '9')) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * @description �ַ����Ƿ��ʾС��(������ + ���� + ����֮���С����)
	 * @author rico
	 * @created 2017��7��6�� ����3:22:59
	 * @param str
	 * @return
	 */
	public boolean isDecimalNumber(char[] str) {
		if (str.length == 0) {
			return false;
		} else {
			boolean flag = false; // ֻ�ܳ���һ��С����
			for (int i = 0; i < str.length; i++) {
				if (i == 0) {
					if (str[0] == '+' || str[0] == '-') {
						continue;
					}
				}
				if (!(str[i] >= '0' && str[i] <= '9')) {
					if (str[i] == '.' && !flag && i != 0 && i != str.length - 1) {
						flag = true;
						continue;
					}
					return false;
				}
			}
			return flag;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "123.45e+6";
		System.out.println("�Ƿ�Ϊ���� �� " + s.isRoundNumber(str.toCharArray()));
		System.out.println("�Ƿ�ΪС�� �� " + s.isDecimalNumber(str.toCharArray()));
		System.out.println("�Ƿ�Ϊ�� �� " + s.isNumeric(str.toCharArray()));
	}
}
