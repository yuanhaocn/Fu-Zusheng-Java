package Offer16;

/**
 * Title: ��ת����(�ݹ��㷨,�ڹ���ʱ�������) 
 * Description:����һ��������ת�����������������Ԫ�ء� ʱ�临�Ӷȣ�O(n),�ռ临�Ӷȣ�O(n)
 * 
 * @author rico
 * @created 2017��6��10�� ����5:47:21
 */   
public class Solution3 {
	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null ) {   // �ݹ���ֹ����
			return head;     // ���龰
		}else{
			// ��ת�õ�����nodeָ���ͷ
			ListNode node = ReverseList(head.next);  // ��ȡ�ظ����߼�����С�����ģ
			
			//������ת����β�ڵ�
			ListNode tmp = node;   
			while(tmp.next != null){
				tmp = tmp.next;
			}
			//����ǰ��������Ѿ���ת�õ�����
			tmp.next = head;
			head.next = null;  // ����ǰ�ڵ��ָ���ÿգ���ֹ��ѭ��
			return node;
		}
	}
}
