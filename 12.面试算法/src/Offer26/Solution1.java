package Offer26;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: ��������ĸ���(ʱ�临�Ӷȣ�O(n),�ռ临�Ӷȣ�O(n))
 * Description:����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ�
 * �������ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * 
 * @author rico
 * @created 2017��6��17�� ����11:27:19
 */
public class Solution1 {

	 
	/**  �Կռ任ȡʱ�䣬��CloneListʱ��pHead�����е�node��cHead�����е�nodeƥ��  (@author: rico) */      
	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

	/**
	 * @description Ϊ��CloneList()�õ��������������ø��ڵ�randomָ��
	 * @author rico
	 * @created 2017��6��17�� ����2:35:40
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		RandomListNode cHead = CloneList(pHead);
		RandomListNode cur1 = pHead; // ����pHead��ָ��
		RandomListNode cur2 = cHead; // ����cHead��ָ��

		// ΪcHead�����������ø��ڵ��randomָ��
		while (cur1 != null) {
			RandomListNode tmp1 = cur1.random;
			if (tmp1 != null) {
				cur2.random = map.get(tmp1);  // ����pHead�е�tmp1��ȡcHead�ж�Ӧ�Ľڵ�
			} else {
				cur2.random = null;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cHead;
	}

	/**
	 * @description �ݹ鸴��һ����pHeadһģһ��������(û������randomָ��)
	 * @author rico
	 * @created 2017��6��17�� ����2:35:09
	 * @param pHead
	 * @return
	 */
	public RandomListNode CloneList(RandomListNode pHead) {
		if (pHead == null) { // �ݹ���ֹ����
			return null; // ���龰�µĴ���
		} else { // ��С��ģ���ݹ����
			RandomListNode cHead = CloneList(pHead.next);
			RandomListNode head = new RandomListNode(pHead.label);
			head.next = cHead;
			map.put(pHead, head);
			return head;
		}
	}

	public void print(RandomListNode pHead) {
		if (pHead == null) {
			return;
		} else {
			RandomListNode head = pHead;
			while (head != null) {
				System.out.print(head.label + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		node1.random = node3;
		node2.random = node5;
		node3.random = null;
		node4.random = node2;
		node5.random = null;

		s.print(s.Clone(node1));
		System.out.println(s.map);
	}
}

