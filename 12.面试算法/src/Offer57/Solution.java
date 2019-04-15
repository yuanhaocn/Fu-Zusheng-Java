package Offer57;

/**
 * Title:ɾ���������ظ��Ľ��(˫ָ�뷨)
 * Description:��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * 
 * @author rico
 * @created 2017��7��6�� ����4:28:30
 */
public class Solution {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead != null) {
			ListNode p1 = pHead; // ��ָ��
			ListNode p2 = pHead.next; // ��ָ��
			ListNode tmp = null; // ȥ���ظ����
			ListNode head = null; // ���ս�������ͷ
			boolean flag = false; // �������ڵ��ظ�ʱ��Ϊtrue
			while (p2 != null) {
				if (p1.val != p2.val) { // p1��p2���ظ�
					if (!flag && head == null) { // ͷ���Ĵ���
						head = p1;
					}
					if (flag) {
						if (tmp != null) {
							tmp.next = p2;
						}
						flag = false;
					} else {
						tmp = p1;
					}
					p1 = p2;
					p2 = p2.next;
				} else { // p1��p2�ظ�
					flag = true;
					p2 = p2.next;
				}
			}
			if (flag && tmp != null) { // β�ڵ�Ĵ���
				tmp.next = null;
			}
			if (!flag && head == null) { // ͷ���Ĵ���
				head = p1;
			}
			return head;
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