package Offer39_1;

public class Solution {
	  
	/**     
	 * @description �ж϶������Ƿ�ƽ��
	 * @author rico       
	 * @created 2017��6��26�� ����5:07:51     
	 */
	public boolean isBalanceTree(TreeNode root) {
		if (root == null) {  // �ݹ���ֹ����
			return true;  // ���龰
		} else {
			boolean left = isBalanceTree(root.left);
			boolean right = isBalanceTree(root.right);
			if (left && right) {
				return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) < 2 ? true
						: false;
			} else {
				return false;
			}
		}
	}

	  
	/**     
	 * @description ������������/�߶�
	 * @author rico       
	 * @created 2017��6��26�� ����5:07:31     
	 */
	public int TreeDepth(TreeNode root) {
		if (root == null) { // �ݹ���ֹ����
			return 0; // ���龳�µĴ���
		} else { // ��С��ģ���ݹ����
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