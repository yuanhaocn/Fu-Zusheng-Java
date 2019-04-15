package Offer23;

import java.util.ArrayList;
import java.util.LinkedList;
/**        
 * Title: �������´�ӡ������(�������Ĺ����������������)
 * Description: �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * @author rico       
 * @created 2017��6��16�� ����9:30:36    
 */      
public class Solution {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  // ��������
		while(root != null || !queue.isEmpty()) {
			if (root != null) {   // ��ǰ�ڵ㲻Ϊ��ʱ�������ýڵ㲢������Ů���
				list.add(root.val);
				queue.add(root.left);
				queue.add(root.right);
			}
			root = queue.pop();  // �Ӷ�ͷ��ȡԪ��
		}
		return list;
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