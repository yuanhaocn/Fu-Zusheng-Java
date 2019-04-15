package Offer13;

/**
 * Title: ��O(1)ʱ��ɾ������Ľڵ�(��ɾ���ڵ����м�ڵ㣬��ֻ�踴�ƺ�̽ڵ�����ݲ�ʹ�串�Ǵ�ɾ���ڵ㣬Ȼ����ɾ����ɾ���ڵ�ĺ�̽ڵ㼴��)
 * Description: �������������ͷָ���һ���ڵ��ָ�룬����һ��������O(1)ʱ��ɾ���ýڵ㡣 
 * ʱ�临�Ӷ�(ƽ��)��[(n-1)O(1) + 1*O(n)]/n = O(1)
 * 
 * @author rico
 * @created 2017��6��10�� ����12:01:17
 */
public class Solution {
	public void deleteNode(ListNode head, ListNode target) {
		if (target.next == null) { // ��ɾ���ڵ�û�к�̽ڵ�
			if (head == target) { // ����ֻ��һ���ڵ㣬��������ڵ���Ǳ�ɾ���ڵ�:O(1)
				head = null;
				target = null;
			} else { // ��ɾ���ڵ��������β�ڵ�(��Ҫ������������)��O(n)
				ListNode tmp = head;
				while (head.next != target) {
					tmp = tmp.next;
				}
				tmp.next = null;
				target = null;
			}
		} else { // ��ɾ���ڵ����м�ڵ㣬��ֻ�踴�ƺ�̽ڵ�����ݲ�ʹ�串�Ǵ�ɾ���ڵ㣬Ȼ����ɾ����ɾ���ڵ�ĺ�̽ڵ㼴��
			ListNode tmp = target.next;
			target.data = tmp.data;
			target.next = tmp.next;
			tmp.next = null;
			tmp = null;
		}
	}
}

class ListNode {
	int data;
	ListNode next;
}