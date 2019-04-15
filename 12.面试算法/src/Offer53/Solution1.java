package Offer53;

/**
 * Title:������ʽƥ�� Description:��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'
 * ��ʾ��ǰ����ַ����Գ��������
 * ������0�Σ����ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬
 * ������"aa.a"��"ab*a"����ƥ��
 * 
 * @author rico
 * @created 2017��7��3�� ����7:22:57
 */
public class Solution1 {

	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) { // �߽�����:�ַ�����ģʽ����һ��Ϊ��,����false
			return false;
		} else {
			if (str.length == 0 && pattern.length == 0) { // �߽�����:�ַ�����ģʽ�����Ⱦ�Ϊ0
				return true;
			} else if (str.length != 0 && pattern.length == 0) { // �߽�����:�ַ�������Ϊ0��ģʽ�����Ȳ�Ϊ0
				return false;
			} else { // ƥ�䴦��
				return matchCore(str, pattern, 0, 0, str.length, pattern.length);
			}
		}
	}

	/**
	 * @description �ַ���ƥ������㷨���ݹ���ٷ�(������������)
	 * @author rico
	 * @created 2017��7��6�� ����1:40:07
	 * @param str
	 *            �ַ���
	 * @param pattern
	 *            ģʽ��
	 * @param p1
	 *            �ַ���ָ��
	 * @param p2
	 *            ģʽ��ָ��
	 * @param n1
	 *            �ַ�������
	 * @param n2
	 *            ģʽ������
	 * @return �Ƿ�ƥ��
	 */
	public boolean matchCore(char[] str, char[] pattern, int p1, int p2,
			int n1, int n2) {
		if (p1 == n1 && p2 == n2) { // �ݹ���ֹ�������ַ���ָ�롢ģʽ��ָ��ͬʱɨ�����
			return true;
		} else if (p1 != n1 && p2 == n2) { // �ݹ���ֹ�������ַ���ָ��δɨ����ϣ�ģʽ��ָ��ɨ�����
			return false;
		} else { 
			if (p2 + 1 < n2 && pattern[p2 + 1] == '*') {    // ģʽ����ǰ�ַ�����һ���ַ�Ϊ'*'
				if (p1 < n1 && (pattern[p2] == '.' || str[p1] == pattern[p2])) { // �ַ���δɨ������ҵ�ǰ�ַ�ƥ��
					// ����������
					return matchCore(str, pattern, p1 + 1, p2 + 2, n1, n2) // �ַ����ƶ�1λ��ģʽ���ƶ�2λ
							|| matchCore(str, pattern, p1 + 1, p2, n1, n2) // �ַ����ƶ�1λ��ģʽ�����ƶ�
							|| matchCore(str, pattern, p1, p2 + 2, n1, n2); // �ַ������ƶ���ģʽ���ƶ�1λ
				} else { // �ַ���ɨ����ϻ��ߵ�ǰ�ַ���ƥ��
					return matchCore(str, pattern, p1, p2 + 2, n1, n2);
				}
			} else {  // ģʽ����ǰ�ַ�����һ���ַ���Ϊ'*'
				if (p1 < n1 && (pattern[p2] == '.' || str[p1] == pattern[p2])) {   // �ַ���δɨ������ҵ�ǰ�ַ�ƥ��
					return matchCore(str, pattern, p1 + 1, p2 + 1, n1, n2);
				} else {  // �ַ���ɨ����ϻ��ߵ�ǰ�ַ���ƥ��
					return false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String str = "";
		String pattern = ".*";
		System.out.println(s.match(str.toCharArray(), pattern.toCharArray()));
	}
}
