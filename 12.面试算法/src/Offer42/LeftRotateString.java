package Offer42;

/**
 * Title:����ת�ַ��� 
 * Description:�����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S
 * ���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc��
 * ���ǲ��Ǻܼ򵥣�OK���㶨����
 * 
 * @author rico
 * @created 2017��6��29�� ����11:58:15
 */
public class LeftRotateString {
	public String leftRotateString(String str, int n) {
		if (str == null || n >= str.length()) {
			return str;
		} else {
			return str.substring(n, str.length()) + str.substring(0, n);
		}
	}
}
