package Offer26;

/**
 * Title: ��������ĸ���(ʱ�临�Ӷȣ�O��n^2��)
 * Description:����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ�
 * �������ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * 
 * @author rico
 * @created 2017��6��17�� ����11:27:19
 */
public class Solution {

	/**
	 * @description Ϊ��CloneList()�õ��������������ø��ڵ�randomָ��
	 * @author rico
	 * @created 2017��6��17�� ����2:35:40
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		RandomListNode cHead = CloneList(pHead);
		RandomListNode cur1 = pHead;   // ����pHead��ָ��
		RandomListNode cur2 = cHead;   // ����cHead��ָ��

		//ΪcHead�����������ø��ڵ��randomָ��
		while (cur1 != null) {
			RandomListNode tmp1 = cur1.random;
			if (tmp1 != null) {
				RandomListNode tmp2 = pHead;
				RandomListNode tmp3 = cHead;
				while (tmp2 != tmp1) {
					tmp2 = tmp2.next;
					tmp3 = tmp3.next;
				}
				cur2.random = tmp3;
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
		if (pHead == null) {   // �ݹ���ֹ����
			return null;    // ���龰�µĴ���
		} else {  // ��С��ģ���ݹ����
			RandomListNode cHead = CloneList(pHead.next);
			RandomListNode head = new RandomListNode(pHead.label);
			head.next = cHead;
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
		Solution s = new Solution();
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

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}

	@Override
	public String toString() {
		if (random == null) {
			return "RandomListNode [label=" + label + ", random=" + null + "]";
		}
		return "RandomListNode [label=" + label + ", random=" + random.label + "]";
	}

	
}