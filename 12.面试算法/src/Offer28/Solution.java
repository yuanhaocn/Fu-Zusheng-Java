package Offer28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Title: �ַ���������(�ݹ鷨):�ַ����ĳ��ȳ���9�ͱȽ����ˣ�������ʱ���ڼ��㲻�����
 * Description:
 * ����һ���ַ���(���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ),���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * 
 * @author rico
 * @created 2017��6��18�� ����4:49:30
 */
public class Solution {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> strs = new ArrayList<String>();
		if (str == null || str.length() == 0) {    // �߽�����
			return strs;
		} else if (str.length() == 1) {  // �ݹ���ֹ����
			strs.add(str);  // ���龰�µĴ���
			return strs;
		} else {   // ��С��ģ���ݹ����
			for (int i = 0; i < str.length(); i++) {
				String s = swap(str, i);
				ArrayList<String> tmp = Permutation(s.substring(1));
				for (String string : tmp) {
					strs.add(s.charAt(0) + string);
				}
			}

			// ���´������ַ��ظ�����
			Collections.sort(strs);  // ���ȶԽ����������
			// Ȼ��ɨ���������У����ظ����ַ���ɾ��
			String s = null;  
			for (Iterator<String> iterator = strs.iterator(); iterator
					.hasNext();) {
				if (s == null) {
					s = (String) iterator.next();
				}
				while (iterator.hasNext()) {   // ɾ���ظ��ַ���
					String tmp = (String) iterator.next();
					if (s.equals(tmp)) {
						iterator.remove();  // ʹ�õ�������ɾ�����������׵��¿���ʧ��
					} else {
						s = tmp;
						break;
					}
				}
			}
			return strs;
		}
	}

	  
	/**     
	 * @description ���ַ�����ָ��λ�õ��ַ����ַ������ַ�����
	 * @author rico       
	 * @created 2017��6��18�� ����4:59:07     
	 * @param s Ŀ���ַ���
	 * @param i 
	 * @return     
	 */
	private String swap(String s, int i) {
		char c1 = s.charAt(0);
		char c2 = s.charAt(i);
		if (i == 0) {
			return s;
		}
		return c2 + s.substring(1, i) + c1 + s.substring(i + 1, s.length());
	}

	public static void main(String[] args) {
		ArrayList<String> strs = new Solution().Permutation("abcdefghij");
		for (String str : strs) {
			System.out.println(str);
		}
	}
}
