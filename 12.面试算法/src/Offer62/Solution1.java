package Offer62;

/**
 * Title:���л�������(ǰ�������㷨���л��������ͷ����л�������) 
 * Description: ��ʵ�������������ֱ��������л��ͷ����л�������
 * 
 * @author rico
 * @created 2017��7��8�� ����10:07:52
 */
public class Solution1 {
	/**
	 * @description ��ǰ���������ʽ���л�������
	 * @author rico
	 * @created 2017��7��8�� ����10:08:22
	 * @param root
	 * @return
	 */
	String Serialize(TreeNode root) {
		String result = "";
		String pre = preOrder(root);
		if (pre.length() > 0) {
			pre = pre.substring(0, pre.length() - 1);
			result = pre + " ";
		}
		String in = inOrder(root);
		if (in.length() > 0) {
			in = in.substring(1);
			result += in;
		}
		return result;
	}

	  
	/**     
	 * @description ǰ������㷨
	 * @author rico       
	 * @created 2017��7��8�� ����2:11:33     
	 * @param root
	 * @return     
	 */
	String preOrder(TreeNode root) {
		if (root == null) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(root.val);
			sb.append(",");
			sb.append(preOrder(root.left));
			sb.append(preOrder(root.right));
			return sb.toString();
		}
	}

	  
	/**     
	 * @description ��������㷨
	 * @author rico       
	 * @created 2017��7��8�� ����2:11:44     
	 * @param root
	 * @return     
	 */
	String inOrder(TreeNode root) {
		if (root == null) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(inOrder(root.left));
			sb.append(",");
			sb.append(root.val);
			sb.append(inOrder(root.right));
			return sb.toString();
		}
	}

	/**
	 * @description ���ݹ�������л�Ϊ������
	 * @author rico
	 * @created 2017��7��8�� ����10:08:22
	 * @param root
	 * @return 12(6(5,7),10(9,11))
	 */
	TreeNode Deserialize(String str) {
		if (str == "") {
			return null;
		} else {
			String[] seq = str.split(" ");
			String pre = seq[0];
			String in = seq[1];
			String[] pres = pre.split(",");
			String[] ins = in.split(",");
			TreeNode root = Deserialize(pres, 0, pres.length - 1, ins, 0,
					ins.length - 1);
			return root;
		}
	}

	  
	/**     
	 * @description ����ǰ����������㷨�ؽ�������
	 * @author rico       
	 * @created 2017��7��8�� ����2:14:30     
	 * @param pre ǰ������
	 * @param from1 ǰ��������ʼλ��
	 * @param to1 ǰ��������ֹλ��
	 * @param in��������
	 * @param from2 ����������ʼλ��
	 * @param to2 ����������ʼλ��
	 * @return     
	 */
	TreeNode Deserialize(String pre[], int from1, int to1, String in[],
			int from2, int to2) {
		if ((from1 > to1) || (from2 > to2)) {
			return null;
		} else {
			String s = pre[from1];
			int index = 0;
			for (int i = from2; i <= to2; i++) {
				if (s.equals(in[i])) {
					index = i;
				}
			}
			TreeNode root = new TreeNode(Integer.valueOf(s));
			root.left = Deserialize(pre, from1 + 1, from1+index-from2, in, from2, index - 1);
			root.right = Deserialize(pre, from1+index-from2 + 1, to1, in, index + 1, to2);
			return root;
		}
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

		Solution1 s = new Solution1();

		String str = s.Serialize(node1);
		System.out.println("ԭ��" + str);
		TreeNode root = s.Deserialize(str);
		System.out.println("�飺" + s.Serialize(root));
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
