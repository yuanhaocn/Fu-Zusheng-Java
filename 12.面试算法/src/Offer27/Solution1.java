package Offer27;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Title: ������������˫������(
 * ���� ���������(��������������������������������) + ����ָ�룬��ҪO(n)�����ռ�
 * Description:����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * 
 * @author rico
 * @created 2017��6��18�� ����10:30:03
 */
public class Solution1 {
	public TreeNode Convert(TreeNode pRootOfTree) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		
		//��������ķǵݹ��㷨
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  // ����ջ
		TreeNode cur = pRootOfTree;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}else{
				cur = stack.pop();
				list.add(cur);   // ��ǰ�ڵ���ջ
				cur =cur.right;
			}
		}
		
		System.out.println(list); 
		
		// ����ָ��
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 < list.size()) {
				list.get(i).right = list.get(i+1);
				list.get(i+1).left = list.get(i);
			}
		}
		return pRootOfTree == null ? null : list.get(0);
	}
}
