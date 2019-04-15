package Offer56;
  
/**        
 * Title: �����л�����ڽ��(����β�ڵ��ָ��)    
 * Description: һ�������а����������ҳ�������Ļ�����ڽ�㡣
 * �ռ临�Ӷ�O(1) 
 * @author rico       
 * @created 2017��7��6�� ����4:14:08    
 */      
public class Solution {
	  
	/**     
	 * @description ��ָ�����ָ���count��(countΪ���нڵ����Ŀ)
	 * @author rico       
	 * @created 2017��7��7�� ����1:46:27     
	 * @param pHead
	 * @return     
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead != null) {
			int count = NodeNuminLoop(pHead);  // ���㻷�нڵ���Ŀ
			if (count != 0) {
				ListNode p1 = pHead;  // ��ָ��
				ListNode p2 = pHead;  // ��ָ��
				while (count > 0) {   // ��ָ�����ָ���count��
					p2 = p2.next;
					count --;
				}
				// ����ָ�뽻�㴦��Ϊ������ڵ�
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				return p1;
			}
		}
		return null;
	}
	
	  
	/**     
	 * @description �������������Ľڵ�������������ʱ������Ϊ0.
	 * @author rico       
	 * @created 2017��7��7�� ����8:41:16     
	 * @param pHead
	 * @return     
	 */
	public int NodeNuminLoop(ListNode pHead){
		ListNode p1 = pHead;   // ��ָ�룬һ����һ��
		ListNode p2 = pHead;   // ��ָ�룬һ��������
		int count = 1;   // ��������Ŀ

		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {   // ��ָ�뽻����һ�����,�ýڵ��Ȼ���ڻ�,���㻷�ڽ����Ŀ
				ListNode tmp = p1;
				while (tmp != p1.next) {
					count++;
					p1 = p1.next;
				}
				return count;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Solution s1 = new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		System.out.println(s1.NodeNuminLoop(node1));
	}
}
