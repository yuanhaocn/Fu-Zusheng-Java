package Offer16;

/**
 * Title: ��ת����(˫ָ�뷨) 
 * Description:����һ��������ת�����������������Ԫ�ء� ʱ�临�Ӷȣ�O(n),�ռ临�Ӷȣ�O(n)
 * 
 * @author rico
 * @created 2017��6��10�� ����5:47:21
 */
public class Solution1 {
	public ListNode ReverseList(ListNode head) {
		ListNode p1 = null;    // ��ָ��
		ListNode p2 = head;    // ��ָ��
		ListNode tmp = null;
		while (p2 != null) {
			tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		head = p1;    // headָ��ת����ı�ͷ
		return head;
	}
}
