package Offer17;

/**
 * Title: �ϲ�������������� (����ѭ����)
 * Description: ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 * @author rico
 * @created 2017��6��14�� ����3:59:10
 */
public class Solution {
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode target = null;  // �ϲ��������
		ListNode p1 = list1;  // ָ��list1��ָ��
		ListNode p2 = list2;  // ָ��list2��ָ��
		ListNode p3 = null;     // ָ��target�����һ���ڵ�
		
		// ��list1��list2��ѡȡһ���ڵ���ӵ�target�� 
		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				p3 = add(p3, p2);
				p2 = p2.next;
			} else {
				p3 = add(p3, p1);
				p1 = p1.next;
			}
			// targetָ������ͷ��� 
			if (target == null) {
				target = p3;
			}
		}
		
		// ��list1��list2��ʣ��Ľڵ�����target�� 
		if (target != null) {
			if (p1 == null) {
				add(p3, p2);
			} else if (p2 == null) {
				add(p3, p1);
			}
			return target;
		}
		
		// list1��list2����һ��Ϊ�յ�����
		return p1 == null ? p2 : p1;
	}
	
	  
	/**     
	 * @description ����p3Ϊͷ������������ӽڵ㣬�����ظ����������һ���ڵ�
	 * @author rico       
	 * @created 2017��6��14�� ����5:02:24     
	 * @param target
	 * @param node
	 * @return     
	 */
	public ListNode add(ListNode p3, ListNode node){
		ListNode cur = null;
		if (p3 == null) {
			p3 = node;
			cur = p3;
		}else{
			p3.next = node;
			cur = node;
		}
		return cur;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}