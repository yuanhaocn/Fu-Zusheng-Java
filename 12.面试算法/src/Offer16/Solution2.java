package Offer16;

/**        
 * Title: ��ת����()   
 * Description:����һ��������ת�����������������Ԫ�ء�
 * ʱ�临�Ӷȣ�O(n),�ռ临�Ӷȣ�O(n)
 * @author rico       
 * @created 2017��6��10�� ����5:47:21    
 */ 
public class Solution2 {
	public ListNode ReverseList(ListNode head) {
		if (head != null) {
			ListNode reverseListHead = null;  // ����ת��ı�ͷ
			ListNode pre = null;    // ǰ���ڵ�
			ListNode cur = head;   // ��ǰ�ڵ�
			ListNode next = null;   // ��̽ڵ�
			while(cur != null){
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			reverseListHead = pre;
			return reverseListHead;
		}
		return head;
	}
}
