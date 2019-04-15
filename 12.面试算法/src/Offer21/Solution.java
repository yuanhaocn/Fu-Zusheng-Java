package Offer21;

import java.util.Stack;

/**
 * Title:����min������ջ 
 * Description: ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * 
 * @author rico
 * @created 2017��6��15�� ����4:19:59
 */
public class Solution {

	private Stack<Integer> storeStack = new Stack<Integer>();  // �洢ջ
	private Stack<Integer> minStack = new Stack<Integer>();   // �洢��Сֵ��ջ

	public void push(int node) {  // ��ջ����
		storeStack.push(node);
		if (minStack.isEmpty() || (!minStack.isEmpty() && node <= minStack.peek())) {  // ��������ʱ������ֵͬʱ����Сֵջ
			minStack.push(node);
		}
	}

	public void pop() {  // ��ջ����
		if (!storeStack.isEmpty()) {
			int tmp = storeStack.pop();
			if (tmp == minStack.peek()) {  //��������Ԫ������Сֵջջ��Ԫ����ͬ����ô����Сֵջ��Ҳִ�е�ջ����
				minStack.pop();
			}
		}
	}

	public int top() {   // ���ص�ǰջ��Ԫ��
		if (!storeStack.isEmpty()) {
			return storeStack.peek();
		}
		return Integer.MIN_VALUE;
	}

	public int min() {  // ���ص�ǰջ����Сֵ 
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		return Integer.MIN_VALUE;
	}
}