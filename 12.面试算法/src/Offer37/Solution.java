package Offer37;

/**
 * Title: ��������ĵ�һ���������(˫ָ�뷨��һ��ָ�����һ��ָ���)������Ϊ����ͬ���ȵ�������ĵ�һ����ͬ�ڵ� 
 * Description:�������������ҳ����ǵĵ�һ��������㡣
 * 
 * ʱ�临�Ӷȣ�O(n)
 * 
 * @author rico
 * @created 2017��6��25�� ����3:43:37
 */
public class Solution {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		} else {
			int size1 = size(pHead1);
			int size2 = size(pHead2);
			int num = size1 - size2; // һ��ָ�����һ��ָ���num��
			if (num == 0) { // �����������
				return FindFirstCommonNode1(pHead1, pHead2);
			} else if (num > 0) { // ����pHead1��pHead2��
				ListNode p1 = pHead1;
				int tmp = 0;
				while (tmp < num) {
					p1 = p1.next;
					tmp++;
				}
				return FindFirstCommonNode1(p1, pHead2);
			} else { // ����pHead2��pHead1��
				num = Math.abs(num);
				ListNode p2 = pHead2;
				int tmp = 0;
				while (tmp < num) {
					p2 = p2.next;
					tmp++;
				}
				return FindFirstCommonNode1(pHead1, p2);
			}
		}
	}

	/**
	 * @description ��ͬ���ȵ�������ĵ�һ����ͬ�ڵ�
	 * @author rico
	 * @created 2017��6��25�� ����4:34:25
	 */
	public ListNode FindFirstCommonNode1(ListNode p1, ListNode p2) {
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	/**
	 * @description ���㵥����ĳ���
	 * @author rico
	 * @created 2017��6��25�� ����4:20:31
	 */
	public int size(ListNode pHead) {
		int size = 1;
		ListNode node = pHead;
		while (node.next != null) {
			node = node.next;
			size++;
		}
		return size;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}