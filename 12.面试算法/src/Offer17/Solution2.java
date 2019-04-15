package Offer17;

/**
 * Title: �ϲ�������������� (�ݹ鷨,����ʱ���Ͻ������)
 * Description: ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 * @author rico
 * @created 2017��6��14�� ����3:59:10
 */
public class Solution2 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {  // �ݹ���ֹ����1
			return list2;   // �ݹ���ֹʱ�Ĵ���취
		}else if (list2 == null) {  // �ݹ���ֹ����2
			return list1;   // �ݹ���ֹʱ�Ĵ���취
		}else {
			ListNode target = null;
			if (list1.val > list2.val) {
				target = list2;
				target.next = Merge(list1, list2.next);  // ��ȡ�ظ����߼�����С�����ģ
			}else{
				target = list1;
				target.next = Merge(list1.next, list2);  // ��ȡ�ظ����߼�����С�����ģ
			}
			return target;
		}
	}
}
