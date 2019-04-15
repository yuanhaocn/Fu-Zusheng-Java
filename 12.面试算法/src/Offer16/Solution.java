package Offer16;

import java.util.LinkedList;

/**        
 * Title: ��ת����(���ν�������ڵ������ѹջ��Ȼ�����ν��е�ջ���������丳ֵΪ������ڵ��data�ֶ�)   
 * Description:����һ��������ת�����������������Ԫ�ء�
 * ʱ�临�Ӷȣ�O(n),�ռ临�Ӷȣ�O(n)
 * @author rico       
 * @created 2017��6��10�� ����5:47:21    
 */      
public class Solution {
	public ListNode ReverseList(ListNode head) {
		LinkedList<Integer> stack = new LinkedList<Integer>();   // �����ռ�
		ListNode cur = head;
		while(cur != null){
			stack.push(cur.data);
			cur = cur.next;
		}
		
		// �����޸�����Ľڵ�data�ֶ�
		cur = head;
		while (cur!= null) {
			cur.data = stack.pop();
			cur = cur.next;
		}
		return head;
    }
}

class ListNode{
	int data;
	ListNode next;
}