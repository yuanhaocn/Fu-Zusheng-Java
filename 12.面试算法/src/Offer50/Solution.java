package Offer50;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Title: ��������������͹�������
 * Description: ����������������͹������ȣ��������Ƕ�����������û��ָ�򸸽ڵ��ָ�롣
 * 
 * @author rico
 * @created 2017��7��2�� ����5:25:26
 */
public class Solution {

	/**
	 * @description ����㵽Ŀ��ڵ��·��(�ȸ��������)
	 * @author rico
	 * @created 2017��7��2�� ����6:27:51
	 * @param root
	 *            �����
	 * @param target
	 *            Ŀ��ڵ�
	 * @return
	 */
	public static LinkedList<TreeNode> getPathFromRootToTarget(TreeNode root,
			TreeNode target) {
		LinkedList<TreeNode> path = new LinkedList<TreeNode>();
		if (root == null) { // �ݹ���ֹ����1��������Ŀ��ڵ�
			return path;
		} else if (root == target) { // �ݹ���ֹ����2������Ŀ��ڵ�
			path.push(root);
			return path;
		} else { // ��С��Χ���ݹ鴦��
			LinkedList<TreeNode> children = root.children;
			LinkedList<TreeNode> tmp;
			for (TreeNode node : children) {
				tmp = getPathFromRootToTarget(node, target);
				if (tmp.size() != 0) { // �������Ķ��壬�ڵ����ֻ�ܴ�����һ������
					path = tmp;
					break;
				}
			}
			if (path.size() != 0) { // ���а���Ŀ��ڵ�
				path.push(root);
			}
			return path;
		}
	}

	/**
	 * @description �������ڵ��·����Ѱ������͹�������
	 * @author rico
	 * @created 2017��7��2�� ����6:29:09
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static TreeNode getLastCommonParent(TreeNode root, TreeNode node1,
			TreeNode node2) {
		if (root == null || node1 == null || node2 == null) { // �߽�����
			return null;
		} else {
			// root�ڵ�ֱ���Ŀ��ڵ�node1��node2��·��
			LinkedList<TreeNode> path1 = getPathFromRootToTarget(root, node1);
			System.out.println("path1 : " + path1);
			LinkedList<TreeNode> path2 = getPathFromRootToTarget(root, node2);
			System.out.println("path2 : " + path2);
			if (path1 == null || path2 == null) {
				return null;
			}
			TreeNode lastCommonParent = null; // ��͹�������
			Iterator<TreeNode> iter1 = path1.iterator();
			Iterator<TreeNode> iter2 = path2.iterator();
			while (iter1.hasNext() && iter2.hasNext()) {
				TreeNode tmp1 = iter1.next();
				TreeNode tmp2 = iter2.next();
				if (tmp1 != null && tmp2 != null) {
					if (tmp1 == tmp2) {
						lastCommonParent = tmp1; // ������͹�������
					} else {
						break;
					}
				}
			}
			return lastCommonParent;
		}
	}

	public static void main(String[] args) {
		test01();
		System.out.println("==========");
	}

	public static void test01() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);

		n1.children.add(n2);
		n1.children.add(n3);

		n2.children.add(n4);
		n2.children.add(n5);

		n4.children.add(n6);
		n4.children.add(n7);

		n5.children.add(n8);
		n5.children.add(n9);
		n5.children.add(n10);

		System.out.println("LastCommonParent : "
				+ getLastCommonParent(n1, n6, n8));
		// System.out.println(getPathFromRootToTarget(n1, n10));
	}

}

class TreeNode {
	int val;
	LinkedList<TreeNode> children = new LinkedList<TreeNode>(); // ����һ���ʾ��(�������)

	TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}
}