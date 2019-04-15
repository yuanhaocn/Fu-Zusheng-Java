package Offer26;

import sun.net.www.content.image.png;

/**
 * Title: ��������ĸ���(ʱ�临�Ӷȣ�O(n),�ռ临�Ӷȣ�O(1))
 * Description:����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ�
 * �������ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * 
 * @author rico
 * @created 2017��6��17�� ����11:27:19
 */
public class Solution2 {

	/**
	 * @description Ϊ��CloneList()�õ��������������ø��ڵ�randomָ��
	 * @author rico
	 * @created 2017��6��17�� ����2:35:40
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		pHead = CloneList(pHead);
		setRandom(pHead);
		RandomListNode splitList = splitList1(pHead);
		return splitList;
	}

	/**
	 * @description �ݹ鸴��pHead�ڵ㲢������pHead����(û������randomָ��)
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
			pHead.next = head;
			head.next = cHead;
			return pHead;
		}
	}

	/**
	 * @description ����randomָ��
	 * @author rico
	 * @created 2017��6��17�� ����3:10:49
	 * @param pHead
	 */
	public void setRandom(RandomListNode pHead) {
		RandomListNode cur = pHead;
		while (cur != null) {
			RandomListNode random = cur.random;
			RandomListNode cnode = cur.next;
			if (random != null) {
				cnode.random = random.next;
			} else {
				cnode.random = null;
			}
			cur = cur.next.next;
		}
	}

	/**
	 * @description ���������
	 * @author rico
	 * @created 2017��6��17�� ����3:29:49
	 * @param pHead
	 * @return
	 */
	public RandomListNode splitList1(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		RandomListNode pClonedHead = null;
		RandomListNode pClonedNode = null;
		
		if (pNode != null) {
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		
		while(pNode != null){
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		return pClonedHead;
	}

	public void print(RandomListNode pHead) {
		if (pHead == null) {
			return;
		} else {
			RandomListNode head = pHead;
			while (head != null) {
				System.out.print(head);
				head = head.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
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
	}
}
