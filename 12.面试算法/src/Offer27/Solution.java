package Offer27;

/**
 * Title: ������������˫������(�ݹ��㷨)
 * Description:����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * 
 * @author rico
 * @created 2017��6��18�� ����10:30:03
 */
public class Solution {

	public TreeNode Convert(TreeNode pRootOfTree) {
		TreeNode list = Convert1(pRootOfTree);
		if (list != null) { // ��Ŀ����ָ��˫�����������������ϵ�˫��������Ϊ���ס�β��δ�໥ָ��
			list.left.right = null;
			list.left = null;
		}
		return list;
	}

	/**
	 * @description ������������ת��Ϊ�����˫������(��λ�໥ָ���˫������)
	 * @author rico
	 * @created 2017��6��18�� ����2:17:51
	 * @param pRootOfTree
	 * @return
	 */
	public TreeNode Convert1(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {   // �ݹ���ֹ����
			return null;   // �ݹ���ֹ�����£����龰�Ĵ���
		} else {
			TreeNode list1 = Convert1(pRootOfTree.left);  // ������ת����˫������1
			TreeNode list2 = Convert1(pRootOfTree.right);  // ������ת����˫������2

			if (list1 == null && list2 == null) { // Ҷ�ڵ�
				pRootOfTree.left = pRootOfTree;
				pRootOfTree.right = pRootOfTree;
				return pRootOfTree;
			} else if (list1 == null && list2 != null) { // ����Ϊ��
				TreeNode tmp = list2.left; // �����β�ڵ�
				pRootOfTree.right = list2;
				list2.left = pRootOfTree;

				pRootOfTree.left = tmp;
				tmp.right = pRootOfTree;

				return pRootOfTree;
			} else if (list1 != null && list2 == null) { // �Һ���Ϊ��
				TreeNode tmp = list1.left; // �����β�ڵ�
				tmp.right = pRootOfTree;
				pRootOfTree.left = tmp;

				list1.left = pRootOfTree;
				pRootOfTree.right = list1;

				return list1;
			} else { // ���Һ���
				// ˫������1��β�ڵ�����������
				TreeNode tmp1 = list1.left; // ˫������1��β���
				tmp1.right = pRootOfTree;
				pRootOfTree.left = tmp1;

				// ˫������1��ͷ�����˫������2��β�ڵ�����
				TreeNode tmp2 = list2.left; // ˫������2��β���
				list1.left = tmp2;
				tmp2.right = list1;

				// �������˫������2��ͷ�ڵ�����
				pRootOfTree.right = list2;
				list2.left = pRootOfTree;
				return list1;
			}
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