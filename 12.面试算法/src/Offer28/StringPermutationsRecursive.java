package Offer28;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: �ַ���ȫ���� 
 * Description: �ַ��� str ��ȫ�������ַ��� str ���Ӵ� (str��ȥ��һλ���ַ���ɵ��ַ���)��ȫ���н��
 * ���ַ� c (str��һ��λ�õ��ַ�)��������
 * 
 * ���ֵݹ�ⷨ(��һ�ֽⷨ������ֽⷨ�ھ��崦���߼������в�ͬ)
 * 
 * �����ֽⷨ�ǳ���������
 * 
 * @author rico
 */
public class StringPermutationsRecursive {

	/**
	 * @description ����str.substring(1)��ȫ���У��ڴ˽���ϣ����str��ȫ����
	 * @author rico
	 * @param str
	 *            Ŀ���ַ���
	 * @return Ŀ���ַ�����ȫ����
	 */
	public static List<String> getStringPermutations1(String str) {

		// ���ڴ洢ȫ���н��
		List<String> list = new ArrayList<String>();

		if (str != null) {
			if (str.length() == 1) { // �ݹ���ֹ����
				list.add(str);
			} else {
				char first = str.charAt(0);
				String sub = str.substring(1);
				List<String> temp = getStringPermutations1(sub); // �ݹ���ã���С����Ĺ�ģ
				for (String s : temp) { // ���Ӵ���ȫ���н�������ԭ����ȫ���н��
					for (int i = 0; i <= s.length(); i++) {
						if (i == 0) {
							list.add(first + s);
						} else if (i == s.length()) {
							list.add(s + first);
						} else {
							list.add(s.substring(0, i) + first
									+ s.substring(i, s.length()));
						}
					}
				}
			}
		}
		return list;
	}

	
	/**
	 * @description ����str.substring(1)��ȫ���У��ڴ˽���ϣ����str��ȫ����
	 * @author rico
	 * @param str
	 *            Ŀ���ַ���
	 * @return Ŀ���ַ�����ȫ����
	 */
	public static List<String> getStringPermutations2(String str) {

		// ���ڴ洢ȫ���н��
		List<String> list = new ArrayList<String>();

		if (str != null) {
			if (str.length() == 1) { // �ݹ���ֹ����
				list.add(str);
			} else {
				// ���ַ�����ÿ��ѡȡһ��Ԫ�أ���Ϊ����еĵ�һ��Ԫ��;Ȼ�󣬶�ʣ���Ԫ��ȫ����
				for (int i = 0; i < str.length(); i++) {
					char first = str.charAt(i);
					List<String> temp = getStringPermutations2(str.substring(0,
							i) + str.substring(i + 1, str.length())); // �ݹ���ã���С����Ĺ�ģ
					for (String s : temp) {
						list.add(first + s);
					}
				}
			}
		}
		return list;
	}

	
	/**
	 * @description ���ַ���������ÿ��ѡȡһ��Ԫ�أ���Ϊ����еĵ�һ��Ԫ��;Ȼ�󣬶�ʣ���Ԫ��ȫ����
	 * @author rico
	 * @param s
	 *            �ַ�����
	 * @param from
	 *            ��ʼ�±�
	 * @param to
	 *            ��ֹ�±�
	 */
	public static void getStringPermutations3(char[] s, int from, int to) {
		if (s != null && to >= from && to < s.length && from >= 0) { // �߽��������
			if (from == to) { // �ݹ���ֹ����
				System.out.println(s); // ��ӡ���
			} else {
				for (int i = from; i <= to; i++) {
					swap(s, i, from); // ����ǰ׺,��Ϊ����еĵ�һ��Ԫ�أ�Ȼ���ʣ���Ԫ��ȫ����
					getStringPermutations3(s, from + 1, to); // �ݹ���ã���С����Ĺ�ģ
					swap(s, from, i); // ����ǰ׺����ԭ�ַ�����
				}
			}
		}
	}
	
	/**
	 * @description ���ַ������е��ƶ��ַ����н���
	 * @author rico
	 * @param s
	 * @param from
	 * @param to
	 */
	public static void swap(char[] s, int from, int to) {
		char temp = s[from];
		s[from] = s[to];
		s[to] = temp;
	}



	public static void main(String[] args) {
		System.out.println("�ⷨ����");
		String target = "abcde";
		List<String> list = new ArrayList<String>();
		list = getStringPermutations2(target);
		System.out.println(list.size());
		 
		System.out.println("\n-------------------------\n");
		
		System.out.println("�ⷨ����");
		char[] target1 = { 'a', 'b', 'c' };
		getStringPermutations3(target1, 0, 2);
	}
}
