package Offer42;

/**
 * Title: ��ת����˳����(˫ָ�뷨) 
 * Description: ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ
 * ����һ������Fish������������ȴ������������˼�����磬��student. a am
 * I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a
 * student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * 
 * @author rico
 * @created 2017��6��29�� ����12:13:40
 */
public class ReverseSentence {
	public String reverseSentence(String str) {
		if (str != null && str.split(" ").length > 1) {
			StringBuilder sb = new StringBuilder();
			String[] strs = str.split(" ");
			int start = 0; // ͷָ��
			int end = strs.length - 1; // βָ��
			String tmp = null;
			while (end > start) {
				tmp = strs[start];
				strs[start] = strs[end];
				strs[end] = tmp;
				end--;
				start++;
			}
			for (String s : strs) {
				sb.append(s).append(" ");
			}
			return sb.toString().trim();
		}
		return str;
	}

	public static void main(String[] args) {
		ReverseSentence s = new ReverseSentence();
		String str = "student. a am I";
		System.out.println(s.reverseSentence(str));

	}
}
