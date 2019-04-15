package Offer63;

/**
 * Title:�����������ĵ�k�����(�ݹ��㷨��������������������������) 
 * Description: ����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4
 * 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 * 
 * @author rico
 * @created 2017��7��9�� ����9:15:26
 */
public class Solution {
	/**     
	 * @description ��϶�����������������������
	 * @author rico       
	 * @created 2017��7��9�� ����9:41:46     
	 * @param pRoot 
	 * @param k
	 * @return     
	 */
	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k < 0) {
			return null;
		}else{
			int count = count(pRoot.left);
			if (k == count + 1) {  // ����ڵ㼴Ϊ����
				return pRoot;
			}else if (k < count + 1) {  // ����ڵ�����������
				return KthNode(pRoot.left, k);
			}else{
				return KthNode(pRoot.right, k-count-1);  // ����ڵ�����������(K�������Ľڵ���ʱ������null)
			}
		}
	}
	  
	/**     
	 * @description ǰ�������Ӧ�ã��������нڵ���Ŀ
	 * @author rico       
	 * @created 2017��7��9�� ����9:38:50     
	 * @param pRoot
	 * @return     
	 */
	public int count(TreeNode pRoot){
		if (pRoot == null) {
			return 0;
		}else{
			int left = count(pRoot.left);
			int right = count(pRoot.right);
			return left + right + 1;
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