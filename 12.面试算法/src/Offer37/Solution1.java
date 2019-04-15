package Offer37;

import java.util.LinkedList;

/**
 * Title: ��������ĵ�һ���������(�����ڸ���ջ���Ӻ���ǰ��ʼ�Ƚ�) 
 * Description:�������������ҳ����ǵĵ�һ��������㡣
 * 
 * ʱ�临�Ӷȣ�O(n)
 * �ռ临�Ӷȣ�O(n)
 * 
 * @author rico
 * @created 2017��6��25�� ����3:43:37
 */
public class Solution1 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		} else {
			LinkedList<ListNode> stack1 = getNodes(pHead1);
			LinkedList<ListNode> stack2 = getNodes(pHead2);
			ListNode result = null;
			while (!stack1.isEmpty() && !stack2.isEmpty()) {
				ListNode tmp1 = stack1.pop();
				ListNode tmp2 = stack2.pop();
				if (tmp1 == tmp2) {
					result = tmp1;
				}else{
					break;
				}
			}
			return result;
		}
	}

	/**
	 * @description ����������нڵ���ջ
	 * @author rico
	 * @created 2017��6��25�� ����4:20:31
	 */
	public LinkedList<ListNode> getNodes(ListNode pHead) {
		LinkedList<ListNode> stack = new LinkedList<ListNode>();
		ListNode node = pHead;
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		return stack;
	}
}