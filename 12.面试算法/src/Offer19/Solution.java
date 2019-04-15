package Offer19;

/**        
 * Title: �������ľ���(��ͼ�ҹ��ɣ��ݹ��㷨)��������ǰ�������Ӧ��
 * Description: ���������Ķ�����������任ΪԴ�������ľ���
 * @author rico       
 * @created 2017��6��15�� ����9:30:37    
 */      
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) {   // �ݹ���ֹ����
			return;   // ���龰�Ĵ���
		}else{
			// �ȶԵ���������
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			
			//�ٽ����������ֱ�任Ϊ���Ӧ�ľ���
			Mirror(root.left);   // �ظ��߼�����ȡ����С�����ģ
			Mirror(root.right);  // �ظ��߼�����ȡ����С�����ģ
		}
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