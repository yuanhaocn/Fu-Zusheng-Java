package Offer59;

/**
 * Title: �ԳƵĶ����� (�ݹ��㷨) 
 * Description:��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * 
 * @author rico
 * @created 2017��7��7�� ����9:07:26
 */
public class Solution {
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		return isSymmetrical(pRoot.left, pRoot.right);
	}

	/**
	 * @description �ж�������(A,B)�Ƿ�Գƣ�A����������B���������Գ� && A����������B���������Գ�
	 * @author rico
	 * @created 2017��7��8�� ����7:39:53
	 * @param t1
	 * @param t2
	 * @return
	 */
	boolean isSymmetrical(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {   // ���ſ����ǶԳƵ�
			return true;
		} else if (t1 != null && t2 != null) { 
			if (t1.val == t2.val) {  // �ж� A����������B���������Գ� && A����������B���������Գ�
				return isSymmetrical(t1.left, t2.right)
						&& isSymmetrical(t1.right, t2.left);
			}
		}
		return false;
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