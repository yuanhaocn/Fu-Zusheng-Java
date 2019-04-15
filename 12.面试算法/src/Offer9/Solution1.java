package Offer9;

/**
 * Title: ��̨��(쳲��������е�Ӧ��),�Ż��㷨
 * Description: һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * @author rico
 * @created 2017��6��4�� ����3:45:34
 */
public class Solution1 {

	public int JumpFloor(int target) {
		return JumpFloor(target, 1, 2);
	}

	/**
	 * @description ��������һ��n��̨�׵��������� = ��������һ��n-1��̨�׵��������� + ��������һ��n-2��̨�׵���������
	 * @author rico
	 * @created 2017��6��4�� ����3:47:34
	 * @param target
	 * @param first
	 * @param second
	 * @return
	 */
	public int JumpFloor(int target, int first, int second) {
		if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		} else if (target == 3) {
			return first + second;
		}
		return JumpFloor(--target, second, first + second);
	}

	public static void main(String[] args) {
		System.out.println(new Solution1().JumpFloor(10));
	}
}
