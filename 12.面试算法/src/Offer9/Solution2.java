package Offer9;

/**
 * Title: ��̨�� Description: һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * 
 * @author rico
 * @created 2017��6��4�� ����3:45:34
 */
public class Solution2 {

	// ��������
	int count = 0;
	
	public int JumpFloor(int target) {
		
		if (target > 0) {
			JumpFloor(target - 1);  // ����һ����
			JumpFloor(target - 2);  // Ҳ����������
		}
		if (target == 0) {  // ���ܳɹ�����һ��n����̨��,����������1
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution2().JumpFloor(10));
	}
}
