package Offer9_3;

/**        
 * Title: 쳲���������(�߸��Ӷȵݹ�ⷨ)
 * Description: ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�n<=39
 * @author rico       
 * @created 2017��6��4�� ����2:12:34    
 */      
public class Solution1 {
	
	public int Fibonacci(int n) {
		if (n == 0) {   // �ݹ���ֹ����
			return 0;
		}else if (n == 1) {   // �ݹ���ֹ����
			return 1;
		}
		return Fibonacci(n-1) + Fibonacci(n-2);  //��С��Χ���ݹ����
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Solution1().Fibonacci(42));
	}
}

