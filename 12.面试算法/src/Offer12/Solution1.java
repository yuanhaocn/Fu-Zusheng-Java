package Offer12;

/**
 * Title: ��ӡ1������nλ����n����0��9��ȫ���У�
 * Description:��������n,��˳���ӡ����1������nλʮ��������������3�����ӡ��1��2��3һֱ������3λ��999.
 * 
 * @author rico
 * @created 2017��6��5�� ����9:03:10
 */
public class Solution1 {

	/**  �ڵݹ���ٽ�������⣬���ڱ�����  (@author: rico) */      
	static StringBuilder result = new StringBuilder();

	/**     
	 * @description �ݹ��ӡ��1��99...9
	 * @author rico       
	 * @created 2017��6��10�� ����11:39:14     
	 * @param n     
	 */
	public static void print(int n) {
		if (n == 0) {   // �ݹ���ֹ����
			// ���龰�µĴ���
			String s = trim(result);   //ȥ������ǰ���0
			if (!s.equals("")) {     
				System.out.println(s);
			}
		} else {   
			for (int i = 0; i < 10; i++) {
				result.append(i);  // ��ȥ
				print(n - 1);    // ��ȡ�ظ����߼�����С�����ģ
				result = result.deleteCharAt(result.length()-1);  // ����
			}
		}
	}

	/**
	 * @description ȥ��ǰ���0
	 * @author rico
	 * @created 2017��6��10�� ����10:06:59
	 * @param sb
	 * @return
	 */
	public static String trim(StringBuilder sb) {
		int index = 0;
		while (index < sb.length() && sb.charAt(index) == '0') {
			index++;
		}
		return sb.substring(index);
	}

	public static void main(String[] args) {
		Solution1.print(3);
	}
}
