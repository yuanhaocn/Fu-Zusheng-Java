package Offer25;

import java.util.ArrayList;

import cn.edu.tju.rico.inttree.BinaryTree;
import cn.edu.tju.rico.inttree.TreeNode;

/**
 * Title: �������к�Ϊĳһֵ��·��(ǰ�������Ӧ��)
 * Description:����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * 
 * @author rico
 * @created 2017��5��31�� ����3:49:33
 */
public class Solution {

	ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();    // ·��(ȫ�ֱ���)
	ArrayList<TreeNode> path = new ArrayList<TreeNode>();   // �������(ȫ�ֱ���)

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root != null) {    // �ݹ���ֹ����
			path.add(root);    // ��;���
			FindPath(root.left, target);  // ���������ң��ݹ����
			FindPath(root.right, target);  // ���������ң��ݹ����

			// Ҷ�ӽ�㣬·�����յ�
			if (root.left == null && root.right == null) {
				//·���ϵĽ�����
				int sum = 0;
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (TreeNode node : path) {
					sum += node.val;
					temp.add(node.val);
				}
				
				// ·���Ͻ��ĺ��Ƿ���Ŀ��ֵ���
				if (sum == target) {   
					paths.add(temp);
				}
			}
			
			// ��ǰ·��
			if (!path.isEmpty()) {
				path.remove(path.size() - 1);
			}
		}
		return paths;
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTree.createBinaryTree(
				"2(3(2(2,3),4),5(0(2,),2(,1)))", null);
		BinaryTree.printBinaryTree(root);
		System.out.println();
		System.out.println("----------------");
		ArrayList<ArrayList<Integer>> paths = new Solution().FindPath(root, 10);
		for (ArrayList<Integer> arrayList : paths) {
			System.out.println(arrayList);
		}
	}
}
