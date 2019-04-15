package Offer15;

/**        
 * Title: �����е�����k����� (˫ָ�뷨(һ������һ���켸��))
 * Description: ����һ����������������е�����k����㡣
 * @author rico       
 * @created 2017��6��10�� ����5:44:16    
 */      
public class Solution {
	public ListNode FindKthToTail(ListNode head, int k) {
		
		if (k < 1 || head == null) {  // �߽�����
			return null;
		}
		
		ListNode pre = head;
		ListNode post = head;
		for (int i = 1; i < k; i++) { // pre����k-1��
			if (pre != null) {
				pre = pre.next;
			}
		}
		if (pre != null) {
			// ��pre�ߵ�����ĩ��ʱ��post����ָ������K���ڵ�
			while (pre != null && pre.next != null) {
				pre = pre.next;
				post = post.next;
			}
			return post;
		}
		return null;
	}
}

class ListNode{
	int data;
	ListNode next;
}
