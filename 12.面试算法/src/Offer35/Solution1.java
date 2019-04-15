package Offer35;

/**
 * Title:��һ��ֻ����һ�ε��ַ�(ʹ��char[256]���洢�ṹ)
 * Description: ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 * 
 * ʱ�临�Ӷȣ�O(n)
 * �ռ临�Ӷȣ�O(1)
 * @author rico
 * @created 2017��6��24�� ����8:51:27
 */
public class Solution1 {
	public int FirstNotRepeatingChar(String str) {
		if (str != null && str.length() != 0) {
			char[] arr = new char[256];
			for (char c : str.toCharArray()) {
				arr[c] ++;
			}
			for (char c : str.toCharArray()) {
				if (arr[c] == 1) {
					return str.indexOf(c);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String str = "google";
		System.out.println(s.FirstNotRepeatingChar(str));
	}
}
