package Offer12;

/**
 * Title: ��ӡ1������nλ��
 * Description:��������n,��˳���ӡ����1������nλʮ��������������3�����ӡ��1��2��3һֱ������3λ��999.
 * 
 * @author rico
 * @created 2017��6��5�� ����9:03:10
 */
public class Solution {

	public void print(int n) {
		StringBuilder start = new StringBuilder(); // ��С��nλ��
		StringBuilder end = new StringBuilder(); // ����nλ��
		for (int i = 0; i < n; i++) {
			start.append("0");
			end.append("9");
		}

		// ѭ����ӡ��1������nλʮ������
		while (!start.toString().equals(end.toString())) { // StringBuilderû����дObject��equals����
			int index = n - 1;
			while (Integer.valueOf(start.charAt(index) - 48) == 9) { //�Ӻ���ǰɨ�裬ʹindexָ���һ����Ϊ9������
				index--;
			}
			if (index == n - 1) {	 // �����ۼ�
				start = start.replace(index, index + 1,
						String.valueOf(start.charAt(index) - 48 + 1));
			} else { 	// ��λ����
				StringBuilder rp = new StringBuilder(String.valueOf(start
						.charAt(index) - 48 + 1));
				int temp = index;
				while (temp < n - 1) {
					temp++;
					rp.append("0");
				}
				start = start.replace(index, n, rp.toString());
			}
			System.out.println(trim(start));
		}
	}

	  
	/**     
	 * @description ȥ��ǰ���0
	 * @author rico       
	 * @created 2017��6��10�� ����10:06:59     
	 * @param sb
	 * @return     
	 */
	public String trim(StringBuilder sb) {
		int index = 0;
		while (index < sb.length() && sb.charAt(index) == '0') {
			index++;
		}
		return sb.substring(index);
	}

	public static void main(String[] args) {
		new Solution().print(5);
	}
}
