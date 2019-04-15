package Offer9_3;

/**
 * Title: 쳲��������� (�͸��Ӷȵݹ�ⷨ���Ż��ⷨ)
 * Description: ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�n<=39
 * 
 * @author rico
 * @created 2017��6��4�� ����2:12:34
 */
public class Solution2 {

	public int Fibonacci(int n) {
		return Fibonacci(n, 0, 1);
	}

	  
	/**     
	 * @description ��first��secondΪͷ��쳲��������е�n��ֵ�ļ���
	 * �ȼ�����second��first+secondΪͷ��쳲��������е�n-1��ֵ�ļ���
	 * @author rico       
	 * @created 2017��6��4�� ����2:57:19     
	 * @param n
	 * @param first
	 * @param second
	 * @return     
	 */
	public int Fibonacci(int n, int first, int second) {
		if (n == 0) {
			return 0;
		}else if (n == 1) {
			return 1;
		}else if (n == 2) {
			return first + second;
		}
		return Fibonacci(--n, second, first + second);
	}

	  
	/**     
	 * @description ����
	 * @author rico       
	 * @created 2017��6��4�� ����3:02:18     
	 * @param args     
	 */
	public static void main(String[] args) {
		System.out.println(new Solution2().Fibonacci(42));
	}
}
