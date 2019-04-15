package cn.edu.tju.rico.inttree;

import java.util.LinkedList;



/**
 * Title: ������(�����Խṹ)�Ĺ�������ز��� 
 * Description:
 * �Թ������ʽ���ַ���������������'()'ǰ��ʾ����㣬���������������ö��Ÿ��������Ų���ʡ�� �������Ĳ��/��������㷨
 * ��������ǰ�����򡢺�������ĵݹ�ͷǵݹ��㷨(��ÿ���ڵ���ԣ����ֱ�����ʽ����Ҫ�����ý�����Σ�����Ψһ�������ڸý��ķ���ʱ��)
 * ���ݶ�������ǰ����������򡢺������������������� �������ĸ߶� �������Ľ������ �������ĸ���㸴��һ�Ŷ����� ��ȡ�������ĸ���㣬���ӽڵ�
 * ��ӡ������ �ж����Ŷ������Ƿ����
 * 
 * @author rico
 * @created 2017��5��23�� ����11:16:12
 */
public class BinaryTree {

	/** �������ĸ���� (@author: rico) */
	private TreeNode root;

	/**
	 * �޲ι��캯��
	 * @description Ĭ���޲ι��캯��
	 * @author rico
	 * @created 2017��5��24�� ����3:36:35
	 */
	public BinaryTree() {
		super();
	}

	/**
	 * ���캯��
	 * 
	 * @description ����һ�����ĸ���㸴�ƹ�����
	 * @author rico
	 * @created 2017��5��23�� ����2:17:06
	 * @param TreeNode
	 *            ԭ���ĸ����
	 */
	public BinaryTree(TreeNode TreeNode) {
		this.root = copy(TreeNode);
	}

	/**
	 * ���캯��
	 * 
	 * @description ����һ������ǰ�����������ƹ�����
	 * @author rico
	 * @created 2017��5��24�� ����3:38:02
	 * @param preOrderStr
	 */
	public BinaryTree(char[] preOrderStr) {
		root = createTreeByPreOrederStr(preOrderStr, null);
	}

	/**
	 * ���캯��
	 * 
	 * @description ����һ������ǰ�����+�������(���������+�������)���ƹ�����
	 * @author rico
	 * @created 2017��5��24�� ����3:38:33
	 * @param s1
	 * @param s2
	 * @param isPreIn
	 */
	public BinaryTree(String s1, String s2, boolean isPreIn) {
		if (isPreIn) {
			root = createBinaryTreeByPreAndIn(s1, s2);
		} else {
			root = createBinaryTreeByInAndPost(s1, s2);
		}
	}

	/**
	 * @description ���ݹ������ʽ������
	 * @author rico
	 * @created 2017��5��22�� ����3:16:01
	 * @param exp
	 *            �����
	 */
	public void createBinaryTree(String exp) {
		/*
		 * ��������൱�ڰ�һ���ַ�����������ݱ�ɽڵ㣬Ȼ�������Ÿ����߼���ϵ��
		 * ���ϱ�ǣ����ǽڵ�������Һ���Ӧ�ô�˭�ĵ�ַ
		 * ջ�����������������൱��Ҫ�����ã�����Ѱ�Ҹ��ڵ�
		 */
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); // ����ջ
		TreeNode TreeNode = null; // �½��
		TreeNode temp = null; // ������ջ
		TreeNode parent = null; // ���׽��
		boolean flag = false; // true ��ʾ���뵽����������λ�ã�false��ʾ���븸�����Һ���λ��

		for (int i = 0; i < exp.length(); i++) { // ���������ʽ�ĸ����ַ�
			
//**********************************************************************************************************************************
			/*
			 * 12(2(466,5(7(9,10),12)),3(6(,8(,11)),))
			 * ��һ���ֵ����þ��ǰ������ݵĲ��������ķŽ�sb�У�
			 * Ȼ��ͨ����TreeNode = new TreeNode(Integer.valueOf(sb.toString()));
			 * ��һ�������ַ������һ���ڵ��ֵ������һ���ڵ�
			 * ��'('��','���ı�flag �������ж������ӻ����Һ���
			 */
			char c = exp.charAt(i);
			StringBuilder sb = new StringBuilder();
			if (48 <= c && c <= 57) {
				sb.append(c);
				while (i + 1 < exp.length()) {
					char tmp = exp.charAt(i+1);
					if (48 <= tmp && tmp <= 57) {
						sb.append(exp.charAt(i+1));
						i++;
					}else{
						break;
					}
				}
			}
//**********************************************************************************************************************************
			/*
			 * ��һ��������Ҫ������
			 * '('�����Ͱ���һ��ѭ����tempѹջ����,���Ҹı�flag��ֵ
			 * ')'�����Ͱ���һ��ѭ����temp,Ҳ������һ���γɵĽڵ㣬�ӵ�
			 * ','�����͸ı�flag
			 */
			
			switch (c) {
			case '(': // ��ǰ�ڵ��к��ӽڵ㣬��ջ�Ա������亢��
				stack.push(temp);
				flag = true;
				break;
			case ')': // ���ú���ջ���ڵ�ĺ��ӣ���ջpop��ʾֱ�Ӳ�Ҫջ��Ԫ�أ�����ȥ�˲�ɾ��
				stack.pop();
				break;
			case ',': // ��ǰ�ڵ��޺��ӣ�����Ҫ�����亢�ӽڵ㣬��˲���Ҫ��ջ
				flag = false;
				break;
			default: // �����������ݴ����ڵ�
				TreeNode = new TreeNode(Integer.valueOf(sb.toString()));
				break;
			}
//**********************************************************************************************************************************

			// ���������ڣ��򴴽����ĸ���㣬��������ʱ��ֻ�ᱻִ��һ��
			if (root == null) {
				root = TreeNode;
			}
//**********************************************************************************************************************************
			
			// Ϊջ���ڵ�������Ů
			if (!stack.isEmpty()) {
				if (TreeNode != null) { // ���������'('��')'��','�ַ�ʱ���Թ�
					parent = stack.peek();
					if (flag) {
						parent.left = TreeNode;
					} else {
						parent.right = TreeNode;
					}
				}
			}
//**********************************************************************************************************************************
			
			temp = TreeNode; // ������ջ
			TreeNode = null; // TreeNode������ÿ�
		}
	}

	/**
	 * @description ���ݹ������ʽ������
	 * @author rico
	 * @created 2017��5��22�� ����3:16:01
	 * @param exp
	 *            �����
	 */
	public static TreeNode createBinaryTree(String exp, TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); // ����ջ
		TreeNode TreeNode = null; // �½��
		TreeNode temp = null; // ������ջ
		TreeNode parent = null; // ���׽��
		boolean flag = false; // true ��ʾ���뵽����������λ�ã�false��ʾ���븸�����Һ���λ��

		for (int i = 0; i < exp.length(); i++) { // ���������ʽ�ĸ����ַ�
			char c = exp.charAt(i);
			switch (c) {
			case '(': // ��ǰ�ڵ��к��ӽڵ㣬��ջ�Ա������亢��
				stack.push(temp);
				flag = true;
				break;
			case ')': // ���ú���ջ���ڵ�ĺ��ӣ���ջ
				stack.pop();
				break;
			case ',': // ��ǰ�ڵ��޺��ӣ�����Ҫ�����亢�ӽڵ㣬��˲���Ҫ��ջ
				flag = false;
				break;
			default: // �����������ݴ����ڵ�
				int data = c - 48;
				TreeNode = new TreeNode(data);
				break;
			}

			if (root == null) {
				root = TreeNode;
			}

			// Ϊջ���ڵ�������Ů
			if (!stack.isEmpty()) {
				if (TreeNode != null) { // ���������'('��')'��','�ַ�ʱ���Թ�
					parent = stack.peek();
					if (flag) {
						parent.left = TreeNode;
					} else {
						parent.right = TreeNode;
					}
				}
			}

			temp = TreeNode; // ������ջ
			TreeNode = null; // TreeNode������ÿ�
		}
		return root;
	}

	/**
	 * @description ����/��α�������������
	 * @author rico
	 * @created 2017��5��22�� ����3:05:57
	 * @return
	 */
	public String levelOrder() {
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); // ��������
		if (root != null) {
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode temp = queue.pop();
				sb.append(temp.val).append(" ");

				// �ڱ�����ǰ�ڵ�ʱ��ͬʱ�������Һ������
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
		return sb.toString().trim();
	}

	/**
	 * @description ǰ�����(�ݹ�)
	 * @author rico
	 * @created 2017��5��22�� ����3:06:11
	 * @param root
	 * @return
	 */
	public String preOrder(TreeNode root) {
		StringBuilder sb = new StringBuilder(); // �浽�ݹ����ջ
		if (root != null) { // �ݹ���ֹ����
			sb.append(root.val + " "); // ǰ�������ǰ���
			sb.append(preOrder(root.left)); // ǰ�����������
			sb.append(preOrder(root.right)); // ǰ�����������
		}
		return sb.toString();
	}

	/**
	 * @description ǰ�����(����):�����Խṹ(��)������ջ����ǰ�ڵ���ջ
	 * @author rico
	 * @created 2017��5��24�� ����8:48:09
	 * @return
	 */
	public String preOrder() {

		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); // ����ջ����¼����·��
		TreeNode TreeNode = root;

		while (TreeNode != null || !stack.isEmpty()) { // ��������
			if (TreeNode != null) { // ��ǰ�ڵ㲻Ϊ��
				sb.append(TreeNode.val + " "); // ���ʵ�ǰ�ڵ�
				stack.push(TreeNode); // ��ǰ�ڵ���ջ
				TreeNode = TreeNode.left; // ������������
			} else {
				TreeNode = stack.pop(); // �����丸�ڵ�
				TreeNode = TreeNode.right; // ������������
			}
		}
		return sb.toString();
	}

	/**
	 * @description �������(�ݹ�)
	 * @author rico
	 * @created 2017��5��22�� ����3:06:28
	 * @param root
	 * @return
	 */
	public String inOrder(TreeNode root) {
		StringBuilder sb = new StringBuilder(); // �浽�ݹ����ջ
		if (root != null) { // �ݹ���ֹ����
			sb.append(inOrder(root.left)); // �������������
			sb.append(root.val + " "); // ���������ǰ���
			sb.append(inOrder(root.right)); // �������������
		}
		return sb.toString();
	}

	/**
	 * @description �������(����)�������Խṹ(��)������ջ����ǰ�ڵ���ջ
	 * 
	 * @author rico
	 * @created 2017��5��24�� ����9:22:31
	 * @return
	 */
	public String inOrder() {
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); // ����ջ����¼����·��
		TreeNode TreeNode = root;

		while (TreeNode != null || !stack.isEmpty()) { // ��������
			if (TreeNode != null) { // ��ǰ�ڵ㲻Ϊ��
				stack.push(TreeNode); // ��ǰ�ڵ���ջ
				TreeNode = TreeNode.left; // ������������
			} else {
				TreeNode = stack.pop(); // ���ڵ㵯ջ
				sb.append(TreeNode.val + " "); // ���ʸ��ڵ�
				TreeNode = TreeNode.right; // ����������������
			}
		}
		return sb.toString();
	}

	/**
	 * @description �������(�ݹ�)
	 * @author rico
	 * @created 2017��5��22�� ����3:06:44
	 * @param root
	 * @return
	 */
	public String postOrder(TreeNode root) {
		StringBuilder sb = new StringBuilder(); // �浽�ݹ����ջ
		if (root != null) { // �ݹ���ֹ����
			sb.append(postOrder(root.left)); // �������������
			sb.append(postOrder(root.right)); // �������������
			sb.append(root.val + " "); // ���������ǰ���
		}
		return sb.toString();
	}

	/**
	 * @description �������(����):�����Խṹ(��)������ջ����ǰ�ڵ���ջ
	 *              �����α���һ���ڵ�ʱ�ŷ���,�����Ҫ�ڽڵ�TreeNode������һ��bool�ֶΣ����ڱ���Ƿ���Ҫ�ڱ��η��ʸýڵ�
	 * @author rico
	 * @created 2017��5��24�� ����9:34:48
	 * @return
	 */
	public String postOrder() {
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); // ��¼����·���Ĺ���ջ
		TreeNode TreeNode = root;
		while (TreeNode != null || !stack.isEmpty()) { // ��������
			if (TreeNode != null) { // ��ǰ�ڵ㲻Ϊ��
				TreeNode.flag = true; // �״η��ʸýڵ㣬��Ϊtrue
				stack.push(TreeNode); // ѹջ����
				TreeNode = TreeNode.left; // ��������������
			} else { // ��ǰ�ڵ�Ϊ�յ�����ջ��Ϊ��
				TreeNode = stack.pop(); // ��ǰ�ڵ㵯ջ
				if (TreeNode.flag) {
					TreeNode.flag = false; // �ڶ��η��ʸýڵ�,��Ϊfalse
					stack.push(TreeNode); // ֻ���ڵ����βŷ��ʣ���ˣ�ǰ�ڵ��ٴ�ѹջ
					TreeNode = TreeNode.right; // ���ʸýڵ��������
				} else { // �����η��ʸýڵ�
					sb.append(TreeNode.val + " "); // ����
					TreeNode = null; // ��ǰ�ڵ������������������������ѷ���,��Ҫ���ʹ���ջ�еĽڵ�
				}
			}
		}
		return sb.toString();
	}

	/**
	 * @description ����ǰ�������������ؽ�������
	 * @author rico
	 * @created 2017��5��24�� ����12:24:41
	 * @return
	 */
	public TreeNode createBinaryTreeByPreAndIn(String pre, String in) {
		if (pre.length() > 0) {
			TreeNode root = new TreeNode(pre.charAt(0) - 48);
			int index = in.indexOf(pre.charAt(0));
			root.left = createBinaryTreeByPreAndIn(pre.substring(1, index + 1),
					in.substring(0, index));
			root.right = createBinaryTreeByPreAndIn(
					pre.substring(index + 1, pre.length()),
					in.substring(index + 1, in.length()));
			return root;
		}
		return null;
	}

	/**
	 * @description �������򡢺����������ؽ�������
	 * @author rico
	 * @created 2017��5��24�� ����12:24:43
	 * @return
	 */
	public TreeNode createBinaryTreeByInAndPost(String in, String post) {
		if (post.length() > 0) {
			TreeNode root = new TreeNode(post.charAt(post.length() - 1) - 48);
			int index = in.indexOf(post.charAt(post.length() - 1));

			root.left = createBinaryTreeByInAndPost(in.substring(0, index),
					post.substring(0, index));
			root.right = createBinaryTreeByInAndPost(
					in.substring(index + 1, in.length()),
					post.substring(index, post.length() - 1));
			return root;
		}
		return null;
	}

	/**
	 * @description ����ԭ���ĸ���㸴�Ƴ�һ��һģһ������
	 * @author rico
	 * @created 2017��5��23�� ����2:21:08
	 * @param root
	 * @return
	 */
	public TreeNode copy(TreeNode root) {
		if (root == null)
			return null;
		TreeNode TreeNode = new TreeNode();
		TreeNode.val = root.val;
		TreeNode.left = copy(root.left);
		TreeNode.right = copy(root.right);
		return TreeNode;
	}

	/** ����createTreeByPreOrederStr��Ҫ�õ���ָ�� (@author: rico) */
	private int index = 0;

	/**
	 * @description ����ǰ���
	 * @author rico
	 * @created 2017��5��24�� ����7:51:54
	 * @param preOrderStr
	 * @param temp
	 * @return
	 */
	public TreeNode createTreeByPreOrederStr(char[] preOrderStr, TreeNode temp) {
		if (index < preOrderStr.length) {
			char c = preOrderStr[index++];
			if (c != '#') { // �ݹ���ֹ����
				TreeNode TreeNode = new TreeNode(c - 48);
				TreeNode.left = createTreeByPreOrederStr(preOrderStr, TreeNode); // �ݹ�Ϊ��ǰ�ڵ㴴��������
				TreeNode.right = createTreeByPreOrederStr(preOrderStr, TreeNode); // �ݹ�Ϊ��ǰ�ڵ㴴��������
				return TreeNode;
			}
			return null;
		}
		return null;
	}

	/**
	 * @description
	 * @author rico
	 * @created 2017��6��15�� ����11:40:58
	 * @param root
	 */
	public void Mirror(TreeNode root) {
		if (root == null) { // �ݹ���ֹ����
			return; // ���龰�Ĵ���
		} else {
			// �ȶԵ���������
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;

			// �ٽ����������ֱ�任Ϊ���Ӧ�ľ���
			Mirror(root.left); // �ظ��߼�����ȡ����С�����ģ
			Mirror(root.right); // �ظ��߼�����ȡ����С�����ģ
		}
	}
	
	public void Mirror1(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				// �ȶԵ���������
				TreeNode tmp = root.left;
				root.left = root.right;
				root.right = tmp;
				if (root.right != null) {
					stack.push(root.right);
				}
				root = root.left;
			}else{
				root = stack.pop();
			}
		}
	}

	/**
	 * @description ��ȡ���ĸ����
	 * @author rico
	 * @created 2017��5��22�� ����3:09:18
	 * @return
	 */
	public TreeNode getRoot() {
		return root;
	}

	/**
	 * @description ��õ�ǰ�������ӽ��
	 * @author rico
	 * @created 2017��5��23�� ����11:13:48
	 * @param TreeNode
	 * @return
	 */
	public TreeNode getLeftChild(TreeNode TreeNode) {
		return TreeNode.left;
	}

	/**
	 * @description ��õ�ǰ�����Һ��ӽ��
	 * @author rico
	 * @created 2017��5��23�� ����11:13:50
	 * @param TreeNode
	 * @return
	 */
	public TreeNode getRightChild(TreeNode TreeNode) {
		return TreeNode.right;
	}

	/**
	 * @description ���������˼�룺���нڵ����
	 * @author rico
	 * @created 2017��5��23�� ����11:59:19
	 * @param root
	 * @return
	 */
	public int size(TreeNode root) {
		if (root != null) { // �ݹ���ֹ����
			return size(root.left) + size(root.right) + 1;
		}
		return 0;
	}

	/**
	 * @description ���������˼�룺���ĸ߶�(����Ϊ0)
	 * @author rico
	 * @created 2017��5��23�� ����12:00:08
	 * @param root
	 * @return
	 */
	public int height(TreeNode root) {
		if (root != null) { // �ݹ���ֹ����
			int h1 = height(root.left);
			int h2 = height(root.right);
			return h1 > h2 ? h1 + 1 : h2 + 1;
		}
		return 0;
	}

	/**
	 * @description ���з���ֵ���Թ�������ʽ��ӡ��������ǰ�������Ӧ��
	 * @author rico
	 * @created 2017��5��24�� ����8:13:08
	 * @param root
	 * @return
	 */
	public static String getBinaryTree(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			sb.append(root.val);
			if (root.left != null || root.right != null) {
				sb.append('(');
				sb.append(getBinaryTree(root.left));
				sb.append(',');
				sb.append(getBinaryTree(root.right));
				sb.append(')');
			}
		}
		return sb.toString();
	}

	/**
	 * @description ���޷���ֵ���Թ�������ʽ��ӡ��������ǰ�������Ӧ��
	 * @author rico
	 * @created 2017��5��24�� ����8:13:08
	 * @param root
	 * @return
	 */
	public static void printBinaryTree(TreeNode root) {
		if (root != null) {
			System.out.print(root.val);
			if (root.left != null || root.right != null) {
				System.out.print('(');
				printBinaryTree(root.left);
				System.out.print(',');
				printBinaryTree(root.right);
				System.out.print(')');
			}
		}
	}
	  
	/**     
	 * @description ����������ת��Ϊ������˫������
	 * @author rico       
	 * @created 2017��6��18�� ����11:39:59     
	 * @param pRootOfTree
	 * @return     
	 */
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}else{
			TreeNode list1 = Convert(pRootOfTree.left);  // ������ת����˫������1
			TreeNode list2 = Convert(pRootOfTree.right); // ������ת����˫������2
			
			if (list1 == null && list2 == null) {  // Ҷ�ڵ�
				pRootOfTree.left = pRootOfTree;
				pRootOfTree.right = pRootOfTree;
				return pRootOfTree;
			}else if (list1 == null && list2 != null) {  // ����Ϊ��
				TreeNode tmp = list2.left;  // �����β�ڵ�
				pRootOfTree.right = list2;
				list2.left = pRootOfTree;
				
				pRootOfTree.left = tmp;
				tmp.right = pRootOfTree;
				
				return pRootOfTree;
			}else if (list1 != null && list2 == null){  // �Һ���Ϊ��
				TreeNode tmp = list1.left;  // �����β�ڵ�
				tmp.right = pRootOfTree;
				pRootOfTree.left = tmp;
				
				list1.left = pRootOfTree;
				pRootOfTree.right = list1;
				
				return list1;
			}else{          // ���Һ���
				// ˫������1��β�ڵ�����������
				TreeNode tmp1 = list1.left;  // ˫������1��β���			
				tmp1.right = pRootOfTree;
				pRootOfTree.left = tmp1;
				
				// ˫������1��ͷ�����˫������2��β�ڵ�����
				TreeNode tmp2 = list2.left;  // ˫������2��β���
				list1.left = tmp2;
				tmp2.right = list1;
				
				// �������˫������2��ͷ�ڵ�����
				pRootOfTree.right = list2;
				list2.left = pRootOfTree;
				return list1;
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return levelOrder();
	}

	/**
	 * @description �������ĸ�����ж��������Ƿ����
	 * @author rico
	 * @created 2017��5��23�� ����3:05:35
	 * @param src
	 *            ԭ���ĸ����
	 * @param des
	 *            Ŀ�����ĸ����
	 * @return
	 */
	private boolean equals0(TreeNode src, TreeNode des) {
		if (src == null && des == null) { // �������
			return true;
		} else if (src == null || des == null) { // ������ǿ��������
			return false;
		} else { // �ǿ�����ǿ����Ƿ���ȣ���ǰ�ڵ��Ƿ���� && �������Ƿ���� && �������Ƿ����
			return src.equals(des) && equals0(src.left, des.left)
					&& equals0(src.right, des.right);
		}
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof BinaryTree) { // �Է��Ƿ�Ҳ��һ�Ŷ�����
			BinaryTree tree = (BinaryTree) obj;
			return equals0(this.root, tree.root);
		}
		return false;
	}
}