package Offer25;

import java.util.ArrayList;
import java.util.LinkedList;

import cn.edu.tju.rico.inttree.BinaryTree;
import cn.edu.tju.rico.inttree.TreeNode;

/**
 * Title: �������к�Ϊĳһֵ��·��(�ݹ�˼·��FindPath(TreeNode root, int target) =
 * FindPath(root.left, target - root.val) + FindPath(root.right, target -
 * root.val)) 
 * Description:����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * 
 * @author rico
 * @created 2017��5��31�� ����3:49:33
 */
public class Solution1 {
	public ArrayList<LinkedList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null) {  // �ݹ���ֹ����1 �� �����Ϊ�գ�ֱ�ӷ���
			ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
			return list;
		} else if (root.left == null && root.right == null) {  // �ݹ���ֹ����2 �� Ҷ�ڵ�ʱ�Ĵ���
			if (root.val == target) {   // Ҷ�ڵ�պõ���Ŀ��ֵ
				ArrayList<LinkedList<Integer>> list1 = new ArrayList<LinkedList<Integer>>();
				LinkedList<Integer> list2 = new LinkedList<Integer>();
				list2.add(root.val);
				list1.add(list2);
				return list1;
			}
			return null;  // Ҷ�ڵ㲻����Ŀ��ֵ
		} else {
			ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
			ArrayList<LinkedList<Integer>> left = FindPath(root.left, target
					- root.val);  // �ݹ���ã���С��Χ
			ArrayList<LinkedList<Integer>> right = FindPath(root.right, target
					- root.val);  // �ݹ���ã���С��Χ
			
			if (left != null || right != null) {  // ������Ҫ���·��������ǰ������·����
				if (left != null) {
					for (LinkedList<Integer> list1 : left) {
						list1.push(root.val);
						result.add(list1);
					}
				}
				if (right != null) {
					for (LinkedList<Integer> list1 : right) {
						list1.push(root.val);
						result.add(list1);
					}
				}
				return result;
			} else {    // ��������Ҫ���·����ֱ�ӷ��� null
				return null;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTree.createBinaryTree(
				"2(3(2(2,3),4),5(0(2,),2(,1)))", null);
		BinaryTree.printBinaryTree(root);
		System.out.println();
		System.out.println("----------------");
		ArrayList<LinkedList<Integer>> paths = new Solution1()
				.FindPath(root, 10);
		for (LinkedList<Integer> arrayList : paths) {
			System.out.println(arrayList);
		}
	}

}