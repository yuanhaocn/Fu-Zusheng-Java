package Offer46;

/**
 * Title:��1+2+3+...+n
 * Description:��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch
 * ��case�ȹؼ��ּ������ж���䣨A?B:C����
 * 
 * @author rico
 * @created 2017��7��2�� ����11:26:35
 */
public class Solution {
	public int Sum_Solution(int n) {
		if (n == 1) {
			return 1;
		} else {
			return Sum_Solution(n - 1) + n;
		}
	}
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.Sum_Solution(5));
	}
}
