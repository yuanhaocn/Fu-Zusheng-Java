package Offer60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Title:��֮����˳���ӡ������
 * Description:��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ
 * �������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * 
 * @author rico
 * @created 2017��7��8�� ����7:45:27
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (pRoot == null) {
			return result;
		}else{
			queue.add(pRoot);
			int count1 = 1;    // ��¼��ǰ��Ľڵ����
			int count2 = 0;    // ��¼��ǰ�����һ��Ľڵ����
			boolean flag = false;    // ��ʶ��ӡ����
			while (!queue.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<Integer>();  // ���ÿһ��ڵ�
				TreeNode tmp = null;
				while(count1 > 0){   // ���δ�ӡ��ǰ��ڵ㲢����һ��ڵ���ӣ�ͬʱ��¼��һ��ڵ�ĸ���
					tmp = queue.pop();   // ��ǰ��ڵ����γ���
					if (tmp.left != null) {  // ��ǰ��ڵ���������
						queue.add(tmp.left);
						count2 ++;
					}
					if (tmp.right != null) {  // ��ǰ��ڵ���Һ������
						queue.add(tmp.right);
						count2 ++;
					}
					list.add(tmp.val);
					count1 --;
				}
				if (flag) {  // ���ƴ�ӡ����
					Collections.reverse(list);
				}
				result.add(list);
				count1 = count2;
				count2 = 0;
				flag = !flag;
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(11);

		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		
		Solution s = new Solution();
		System.out.println(s.Print(node1));
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