package Offer9;

/**
 * Title: ��̨�� 
 * Description: һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * 
 * @author rico
 * @created 2017��6��4�� ����3:45:34
 */
public class Solution {
	public int JumpFloor(int target) {
		if (target > 0) {
			if (target == 1) {
				return 1;
			} else if (target == 2) {
				return 2;
			}
			// ��������һ��n��̨�׵��������� = ��������һ��n-1��̨�׵��������� + ��������һ��n-2��̨�׵���������
			return JumpFloor(target - 1) + JumpFloor(target - 2);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().JumpFloor(0));
	}
}
