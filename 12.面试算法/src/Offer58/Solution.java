package Offer58;

/**
 * Title: ����������һ�����
 * Description:����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ��
 * ��ͬʱ����ָ�򸸽���ָ�롣
 * 
 * @author rico
 * @created 2017��7��7�� ����2:00:27
 */
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		TreeLinkNode result = null;
		if (pNode != null) {
			int position = getPositionbyRoot(pNode);  // �����ڵ����������������������Ǹ����
			if (position == 0) {  // �����ڵ��Ǹ����
				result = getLeftNode(pNode.right);
				return result;
			} else if (position == -1) {    // �����ڵ�����������
				result = getLeftNode(pNode.right);   // ����������ߵĽڵ�
				if (result == null) {  // ����������ߵĽڵ�Ϊ��
					int pos = getPositionbyParent(pNode);
					result = pos == -1 ? pNode.next : pNode.next.next;
				}
				return result;
			} else {     // �����ڵ�����������
				result = getLeftNode(pNode.right);   	// ����������ߵĽڵ�
				if (result == null) {   	// ����������ߵĽڵ�Ϊ��
					int pos = getPositionbyParent(pNode);
					result = pos == -1 ? pNode.next : result;
				}
				return result;
			}
		}
		return result;
	}

	/**
	 * @description ��ȡ�ڵ�nodeΪ������������ߵĽ��
	 * @author rico
	 * @created 2017��7��7�� ����8:54:07
	 * @param node
	 * @return
	 */
	public TreeLinkNode getLeftNode(TreeLinkNode node) {
		if (node == null) {
			return null;
		} else {
			TreeLinkNode cur = node;
			if (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		}
	}

	/**
	 * @description ��ȡ�����ڵ�����ڸ�����λ��
	 * @author rico
	 * @created 2017��7��7�� ����8:57:06
	 * @param pNode
	 * @return
	 */
	public int getPositionbyRoot(TreeLinkNode pNode) {
		TreeLinkNode cur = pNode;
		TreeLinkNode root = null;
		TreeLinkNode tmp = null;
		if (cur != null) {
			while (cur.next != null) {
				tmp = cur;
				cur = cur.next;
			}
			root = cur;
		}

		if (root == pNode) {
			return 0; // pNodeΪ�����
		}
		return root.left == tmp ? -1 : 1; // -1 ��ʾpNodeΪ�������ϵĽڵ㣬1��ʾpNodeΪ�������ϵĽڵ�
	}

	/**
	 * @description ��ȡ�����ڵ�������丸�ڵ��λ��
	 * @author rico
	 * @created 2017��7��7�� ����8:57:39
	 * @param pNode
	 * @return
	 */
	public int getPositionbyParent(TreeLinkNode pNode) {
		return pNode.next.left == pNode ? -1 : 1; // -1 ��ʾΪ���ӣ�1��ʾ�Һ���
	}

	public static void main(String[] args) {
		TreeLinkNode node1 = new TreeLinkNode(8);
		TreeLinkNode node2 = new TreeLinkNode(6);
		TreeLinkNode node3 = new TreeLinkNode(10);
		TreeLinkNode node4 = new TreeLinkNode(5);
		TreeLinkNode node5 = new TreeLinkNode(7);
		TreeLinkNode node6 = new TreeLinkNode(9);
		TreeLinkNode node7 = new TreeLinkNode(11);

		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;
		node2.next = node1;

		node3.left = node6;
		node3.right = node7;
		node3.next = node1;

		node4.next = node2;

		node5.next = node2;

		node6.next = node3;

		node7.next = node3;

		Solution s = new Solution();
		System.out.println(s.getPositionbyRoot(node1));
		System.out.println(s.GetNext(node1));
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeLinkNode [val=" + val + "]";
	}
}