package Offer19;

import java.util.LinkedList;

/**
 * Title: �������ľ���(��ͼ�ҹ��ɣ������㷨)��������ǰ�������Ӧ�� 
 * Description: ���������Ķ�����������任ΪԴ�������ľ���
 * 
 * @author rico
 * @created 2017��6��15�� ����9:30:37
 */
public class Solution1 {
	public void Mirror(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();   // ��ʱ�洢ջ
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				// �ȶԵ���������
				TreeNode tmp = root.left;
				root.left = root.right;
				root.right = tmp;
				
				stack.push(root.right);   // ����������������ջ
				root = root.left;  // ����������������ľ���
			} else {
				root = stack.pop();
			}
		}
	}
}