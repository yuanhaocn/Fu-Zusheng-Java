package Offer22;

import java.util.LinkedList;

/**
 * Title: ջ��ѹ�롢��������(����һ��ջ��ģ����ջ���к͵�ջ���У�ͨ�����ջ�Ƿ�Ϊ���ж���ջ�����뵯ջ�����Ƿ�ƥ��)
 * Description:���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳��,����4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
 * 
 * ˼·���ڰ�pushA��Ԫ�ص�˳����ջʱ������ÿһ��Ԫ�أ��޷��������������ջ�����ϵ���(��������һϵ��Ԫ�صĵ�ջ)��������һ��Ԫ�ؽ�����ջ
 * 
 * @author rico
 * @created 2017��6��15�� ����4:56:55
 */

public class Solution {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null && popA == null) { // �߽�����1����Ϊ��
			return true;
		} else if (pushA == null || popA == null) { // �߽�����2��һ��Ϊ�գ�һ����Ϊ��
			return false;
		} else if (pushA.length != popA.length) { // �߽�����3�����Ȳ���
			return false;
		}

		int n = pushA.length;
		int popA_index = 0;
		// ջstackͬʱģ��ѹջ����pushA�͵�ջ����popA,���stack��Ϊ��,��popA��pushA��Ӧ
		LinkedList<Integer> stack = new LinkedList<Integer>(); // ģ��pushA�����и�Ԫ�ص�ѹջ����
		for (int i = 0; i < n; i++) {
			// ģ����ջ
			stack.push(pushA[i]); 
			
			// ģ�ⵯջ������ǰջ��Ԫ����popA[popA_index]��ͬ����ջ
			while (!stack.isEmpty() && stack.peek() == popA[popA_index]) {
				stack.pop();
				popA_index++;
			}
		}
		return stack.isEmpty(); // ջ�Ƿ�Ϊ�գ�ջΪ�գ���ƥ��ɹ�������ʧ�ܡ�
	}

	public static void main(String[] args) {
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 4, 5, 3, 2, 1 };
		Solution s = new Solution();
		System.out.println(s.IsPopOrder(pushA, popA));
	}
}
