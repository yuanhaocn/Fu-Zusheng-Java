package cn.edu.tju.rico.inttree;

import cn.edu.tju.rico.inttree.BinaryTree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree("1(2(4,5(7(9,10),12)),3(6(,8(,11)),))");
//		tree.createBinaryTree("A(B(D,E(G(I,J),M)),C(F(,H(,K)),))");

		System.out.println();
		System.out.println("tree�Ĳ��(����)���� �� " + tree.levelOrder());
		System.out.println("\n----------------------------------------------\n");
		System.out.println("tree��ǰ����� (�ݹ�)�� " + tree.preOrder(tree.getRoot()));
		System.out.println("tree��ǰ����� (����)�� " + tree.preOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree��������� (�ݹ�)�� " + tree.inOrder(tree.getRoot()));
		System.out.println("tree��������� (����)�� " + tree.inOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree�ĺ������ (�ݹ�)�� " + tree.postOrder(tree.getRoot()));
		System.out.println("tree�ĺ������ (����)�� " + tree.postOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree�ĸ���� �� " + tree.getRoot());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree�ĸ߶� �� " + tree.height(tree.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree�Ľ���� �� " + tree.size(tree.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// ���Ʋ�������
		BinaryTree tree2 = new BinaryTree(tree.getRoot());
		System.out.println("treeΪ �� " + tree.getBinaryTree(tree.getRoot()));
		System.out.println("����treeΪtree2 �� " + tree2.getBinaryTree(tree2.getRoot()));
		// �ж� tree2 �� tree �Ƿ����
		System.out.println("tree2 �� tree �Ƿ����: " + tree.equals(tree2));
		System.out.println("\n----------------------------------------------\n");

		// ����tree1
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree("1(2(4,5(7(9,10),)),3(6(,8(,11)),))");
		System.out.println("treeΪ �� " + tree.getBinaryTree(tree.getRoot()));
		System.out.println("����tree1Ϊ �� " + tree1.getBinaryTree(tree1.getRoot()));
		// �ж� tree1 �� tree �Ƿ����
		System.out.println("tree1 �� tree �Ƿ����: " + tree.equals(tree1));
		System.out.println("\n----------------------------------------------\n");

		// ����ǰ�����������
		BinaryTree tree3 = new BinaryTree(
				"123##45#6##7###".toCharArray());
		System.out.println("����ǰ���������������: " + tree3.getBinaryTree(tree3.getRoot()));
		System.out.println("ǰ�����tree3�� " + tree.preOrder(tree3.getRoot()));
		System.out.println("�������tree3�� " + tree.inOrder(tree3.getRoot()));
		System.out.println("�������tree3�� " + tree.postOrder(tree3.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// �Թ�������ʽ��ӡ������
		System.out.println("�Թ�������ʽ��ӡtreeΪ ��" + tree.getBinaryTree(tree.getRoot()));
		System.out.println("�Թ�������ʽ��ӡtree1Ϊ ��" + tree1.getBinaryTree(tree1.getRoot()));
		System.out.println("�Թ�������ʽ��ӡtree2Ϊ ��" + tree2.getBinaryTree(tree2.getRoot()));
		System.out.println("�Թ�������ʽ��ӡtree3Ϊ ��" + tree3.getBinaryTree(tree3.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// ����tree���������������������������
//		String pre = tree.preOrder().replace(" ", "");
//		String in = tree.inOrder().replace(" ", "");
//		BinaryTree tree4 = new BinaryTree(pre, in, true);
//		System.out.println("����tree���������������������������tree4Ϊ ��"
//				+ tree.getBinaryTree(tree4.getRoot()));
//		System.out.println("tree��tree4�Ƿ���ȣ� " + tree.equals(tree4));
//		System.out.println("\n----------------------------------------------\n");
		
		// ����tree����������ͺ���������������
//		String post = tree.postOrder().replace(" ", "");
//		BinaryTree tree5 = new BinaryTree(in, post, false);
//		System.out.println("����tree����������ͺ���������������tree5Ϊ ��"
//				+ tree.getBinaryTree(tree5.getRoot()));
//		System.out.println("tree��tree5�Ƿ���ȣ� " + tree.equals(tree5));
//		System.out.println("\n----------------------------------------------\n");
		
		BinaryTree tree19 = new BinaryTree();
		tree19.createBinaryTree("8(6(5,7),2(9,4))");
		System.out.println("�Թ�������ʽ��ӡtree19Ϊ ��" + tree19.getBinaryTree(tree19.getRoot()));
		System.out.println(tree19.getRoot());
		tree19.Mirror1(tree19.getRoot());
		System.out.println("�Թ�������ʽ��ӡtree19Ϊ ��" + tree19.getBinaryTree(tree19.getRoot()));
		tree19.Mirror(tree19.getRoot());
		System.out.println("�Թ�������ʽ��ӡtree19Ϊ ��" + tree19.getBinaryTree(tree19.getRoot()));
		System.out.println("\n----------------------------------------------\n");
		
		BinaryTree tree20 = new BinaryTree();
//		tree20.createBinaryTree("5(2(1,4),8(6,9))");
//		tree20.createBinaryTree("5(2(1,),8(6,9))");
		tree20.createBinaryTree("5(,8(1,))");
//		tree20.createBinaryTree("5");
		System.out.println("�Թ�������ʽ��ӡtree20Ϊ ��" + tree20.getBinaryTree(tree20.getRoot()));
		System.out.println("tree20��Ϊ�� " + tree20.getRoot());
//		TreeNode delist = tree20.Convert(tree20.getRoot());
//		TreeNode cur1 = delist;
//		System.out.println("�����ӡdelist�� ");
//		while(cur1!= null){
//			System.out.print(cur1.val + " ");
//			cur1 = cur1.right;
//			if (cur1.right == delist) {
//				System.out.print(cur1.val + " ");
//				break;
//			}
//		}
//		System.out.println();
//		
//		System.out.println("�����ӡdelist�� ");
//		while(cur1!= null){
//			System.out.print(cur1.val + " ");
//			cur1 = cur1.left;
//			if (cur1 == delist ) {
//				System.out.print(cur1.val + " ");
//				break;
//			}
//		}
//		System.out.println();
	}
}
