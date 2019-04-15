package Offer5;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Title:��β��ͷ��ӡ����(�ݹ�Ľ��˼·/˼ά������������"��ȥ"�����������"����",Ҳ����˵��ֻ�а�����Ľ��˼·��������������д���ݹ����)
 * Description: ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * 
 * @author rico
 * @created 2017��5��29�� ����8:53:30
 */
public class PrintLinkedListfromTailtoHead {
	  
	/**     
	 * @description �ݹ�ʵ��
	 * @author rico       
	 * @created 2017��5��29�� ����9:51:49     
	 * @param listNode
	 * @return     
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (listNode != null) { 	// �ݹ���ֹ����
			ListNode next = listNode.next;
			list.addAll(printListFromTailToHead(next)); 	// �ȵݹ��ӡ������(��С��ģ)
			list.add(listNode.data); 	// �ٴ�ӡ����
		}
		return list;
	}
	
	  
	/**     
	 * @description ѭ��ʵ�֣�����ջ
	 * @author rico       
	 * @created 2017��5��29�� ����9:51:43     
	 * @param listNode
	 * @return     
	 */
	public ArrayList<Integer> printListFromTailToHeadwithStack(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		// ��ջ
		while (listNode != null) { 	
			stack.push(listNode.data);
			listNode = listNode.next;
		}
		
		// ��ջ
		for (Integer i : stack) {
			list.add(i);
		}
		return list;
	}
}

  
/**        
 * Title: ������   
 * Description: 
 * @author rico       
 * @created 2017��5��29�� ����8:56:09    
 */      
class ListNode {
	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
	}
}