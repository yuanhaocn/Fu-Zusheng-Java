package Offer39;

/**
 * Title:����������� (�ݹ��㷨�������Ӧ��)
 * Description:����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * 
 * @author rico
 * @created 2017��6��26�� ����4:02:00
 */
public class Solution {
	public int TreeDepth(TreeNode root) {
		if (root == null) {  // �ݹ���ֹ����
			return 0;  // ���龳�µĴ���
		} else {  // ��С��ģ���ݹ����
			int h1 = TreeDepth(root.left);
			int h2 = TreeDepth(root.right);
			return h2 > h1 ? h2 + 1 : h1 + 1;
		}
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}
