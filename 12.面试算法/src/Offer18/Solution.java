package Offer18;

/**
 * Title: �����ӽṹ (�ݹ��㷨/˼��)
 * Description: �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * 
 * @author rico
 * @created 2017��6��14�� ����5:39:04
 */
public class Solution {

	/**     
	 * @description �ݹ��ж�root2�ǲ���root1���ӽṹ
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) { // �ݹ���ֹ����
			return false; // ���龰��������������һ�������ӽṹ
		} else {
			if (root1.val == root2.val) {   // ����A/B�������ͬ����B��������������A�������������ӽṹ
				boolean flag = compareTree(root1.left, root2.left)
						&& compareTree(root1.right, root2.right);
				if (flag)  
					return true;   // ֱ�ӷ���
			}
			// ���򣬼����ж���B�Ƿ�����A�������������������ӽṹ
			return HasSubtree(root1.left, root2)
					|| HasSubtree(root1.right, root2);
		}
	}

	/**
	 * @description ���϶��µݹ��ж���root2���ڵ��Ƿ�����root1��ͬ
	 * @author rico
	 * @created 2017��6��15�� ����8:19:05
	 * @param root1
	 * @param root2
	 * @return 
	 */
	public boolean compareTree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) { 
			// root1Ϊ����root2��Ϊ�գ�ֱ�ӷ���false;���򣬷���true
			if (root1 == null && root2 != null) {
				return false;
			}
			return true;
		} else if (root1.val != root2.val) {  // root1��root2����
			return false;
		} else {  // �����Ƚ�
			return compareTree(root1.left, root2.left)
					&& compareTree(root1.right, root2.right);
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