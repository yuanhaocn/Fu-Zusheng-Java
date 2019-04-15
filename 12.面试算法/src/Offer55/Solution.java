package Offer55;

/**
 * Title:�ַ����е�һ�����ظ����ַ� (ASCII�ַ������׹�ϣ��)
 * Description:��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"
 * ʱ����һ��ֻ����һ�ε��ַ���"g"�����Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 * �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
 * 
 * @author rico
 * @created 2017��7��6�� ����3:40:43
 */
public class Solution {

//	String stringstream = null;
	String stringstream = "avcdvsad";
	StringBuilder sb = new StringBuilder();

	// Insert one char from stringstream
	public void Insert(char ch) {
		stringstream = sb.append(ch).toString();
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		if (stringstream != null) {
			int[] arr = new int[256];
			for (char c : stringstream.toCharArray()) {
				int count = arr[c];
				count++;
				arr[c] = count;
			}
			
			for (char c : stringstream.toCharArray()) {
				if (arr[c] == 1) {
					return c;
				}
			}
		}
		return '#';
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.FirstAppearingOnce());
	}
}
