package cn.edu.tju.rico.inttree;

/**
 * Title: ����� 
 * Description: �������Ľ��
 * 
 * @author rico
 * @created 2017��4��6�� ����9:55:58
 */
public class TreeNode {

	public int val; // �������
	public TreeNode left; // ָ�����ӽ��
	public TreeNode right; // ָ���Һ��ӽ��
	public boolean flag; // ���ڷǵݹ�������

	/**
	 * ���캯��
	 * 
	 * @description ����һ���½��
	 * @author rico
	 * @created 2017��4��6�� ����9:56:56
	 * @param data
	 *            ��Ԫ������
	 * @param next
	 *            ��Ԫ���������Ͻ��
	 */
	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode() {
	}
	
	@Override
	public String toString() {
		return String.valueOf(val);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TreeNode) {
			TreeNode temp = (TreeNode) obj;
			if (val == temp.val) {
				return true;
			}
		}
		return false;
	}
}
