package Offer7;

import java.util.Stack;

/**        
 * Title:����ջ��ʵ��һ������     
 * Description: ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop����,�����е�Ԫ��Ϊint���͡�
 * 				��Ҫ�ⷨ��һ��ջ������ӣ���һ��ջ���ڳ���
 * @author rico       
 * @created 2017��5��30�� ����10:21:26    
 */      
public class ImplementQueuebyStack {
	Stack<Integer> stack1 = new Stack<Integer>();  // �������
    Stack<Integer> stack2 = new Stack<Integer>();  	// ��������
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if (stack2.isEmpty()) {
    		while(!stack1.isEmpty())
    			stack2.push(stack1.pop());
		}
    	return stack2.pop();
    }
}
