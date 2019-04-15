package Offer56;

/**
 * Title: �����л�����ڽ��(����β�ڵ��ָ��) 
 * Description: һ�������а����������ҳ�������Ļ�����ڽ�㣬�ռ临�Ӷ�O(1)
 * 
 * @author rico
 * @created 2017��7��6�� ����4:14:08
 */
public class Solution2 {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null)
			return null;
		ListNode p1 = pHead, p2 = pHead;  	// ����ָ�룬һ��һ����һ����һ��һ��������
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {  // �ҵ���������
				// �һ��е���ڵ�
				p2 = pHead;
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				if (p1 == p2)
					return p1;
			}
		}
		return null;
	}
}
