package Offer9_2;

/**
 * Title: ��̬��̨��(��ѧ���ɷ�)
 * Description:һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * 
 * @author rico
 * @created 2017��6��4�� ����3:45:34
 */
public class Solution {
	public int JumpFloorII(int target) {
		if (target > 0) {
			if (target == 1) {
				return 1;
			}
			if (target > 1) {
				return 2*JumpFloorII(target-1);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().JumpFloorII(4));
	}
}
