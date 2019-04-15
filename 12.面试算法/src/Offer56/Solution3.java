package Offer56;

import java.util.HashSet;
import java.util.Set;
  
/**        
 * Title: �����л�����ڽ��(����β�ڵ��ָ��)    
 * Description: һ�������а����������ҳ�������Ļ�����ڽ�㡣 
 * @author rico       
 * @created 2017��7��6�� ����4:14:08    
 */      
public class Solution3 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead != null) {
			Set<ListNode> set = new HashSet<ListNode>();
			ListNode cur = pHead;
			while (cur != null) {
				if (set.contains(cur)) {
					return cur;
				}else{
					set.add(cur);
					cur = cur.next;
				}
			}
		}
		return null;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}