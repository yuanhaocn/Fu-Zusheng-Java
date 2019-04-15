package Offer62;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Title:���л�������(ǰ�������Ӧ��,����Null�������ַ�"#"����) 
 * Description: ��ʵ�������������ֱ��������л��ͷ����л�������
 * 
 * @author rico
 * @created 2017��7��8�� ����10:07:52
 */
public class Solution2 {

	/**
	 * @description ǰ�����л�
	 * @author rico
	 * @created 2017��7��9�� ����9:11:04
	 * @param root
	 * @return
	 */
	String Serialize(TreeNode root) {
		if (root == null)
			return "#,";
		StringBuilder sb = new StringBuilder(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	  
	/**     
	 * @description �����л�
	 * @author rico       
	 * @created 2017��7��9�� ����9:12:26     
	 * @param str
	 * @return     
	 */
	TreeNode Deserialize(String str) {
		String[] strs = str.split(",");
		Queue<String> q = new LinkedList<String>(Arrays.asList(strs));
		return PreOrder(q);
	}

	
	/**
	 * @description ǰ�����л����ݹ����ջ��ÿ��ջ֡��������ͬ�Ķ���q����q��������Ԫ���Ǳ仯��
	 * @author rico
	 * @created 2017��7��9�� ����9:03:25
	 * @param q
	 * @return
	 */
	TreeNode PreOrder(Queue<String> q) {
		String val = q.poll();
		if (val.equals("#"))
			return null;
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = PreOrder(q);
		node.right = PreOrder(q);
		return node;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(12);
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

		Solution2 s = new Solution2();

		String str = s.Serialize(node1);
		System.out.println("ԭ��" + str);
		TreeNode root = s.Deserialize(str);
		System.out.println("�飺" + s.Serialize(root));
	}
}
