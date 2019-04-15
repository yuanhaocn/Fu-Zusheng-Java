package Offer24;

/**
 * Title:�����������ĺ���������� (������ < ��  < ������)
 * Description: ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * 
 * @author rico
 * @created 2017��6��16�� ����11:57:30
 */
public class Solution {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null) {
			return true;
		}else if (sequence.length == 0) {
			return false;
		}else {
			return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
		}
	}

	  
	/**     
	 * @description �жϸ��������ǲ���ĳ�����������ĺ�������Ľ��
	 * @author rico       
	 * @created 2017��6��17�� ����9:00:08     
	 * @param sequence
	 * @param from
	 * @param to
	 * @return     
	 */
	public boolean VerifySquenceOfBST(int[] sequence, int from, int to) {
		if (to - from <= 1) {   // �ݹ���ֹ������ֻʣ�����ڵ�ʱ
			return true;  // ���龳�µĴ���
		} else {
			int root = sequence[to];  //�����
			// �ҵ����������ı߽�
			int border = from; 
			for (int i = from; i < to; i++) {
				if (sequence[i] < root) {
					border++;
				} else {
					break;
				}
			}
			
			// �ж��������ǲ��Ƕ����ڸ����
			for (int i = border + 1; i < to; i++) {
				if (sequence[i] < root) {
					return false;
				}
			}
			
			// �ݹ���ã���С����Ĺ�ģ
			return VerifySquenceOfBST(sequence, from, border-1)
					&& VerifySquenceOfBST(sequence, border, to-1);
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] test = {4,8,6,12,16,14,10};
		System.out.println(s.VerifySquenceOfBST(test));
	}
}
