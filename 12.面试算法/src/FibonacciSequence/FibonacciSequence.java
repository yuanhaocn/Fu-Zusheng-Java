package FibonacciSequence;
/**
 * Title: 쳲���������
 * 
 * Description: 쳲��������У��ֳƻƽ�ָ����У�ָ��������һ�����У�1��1��2��3��5��8��13��21������
 * ����ѧ�ϣ�쳲��������������±��Եݹ�ķ������壺F0=0��F1=1��Fn=F(n-1)+F(n-2)��n>=2��n��N*����
 * 
 * ���ֵݹ�ⷨ������ⷨ���Ż��ⷨ
 * ���ַǵݹ�ⷨ�����Ʒ������鷨
 * 
 * @author rico
 */
public class FibonacciSequence {

	/**
	 * @description ����ݹ鷨���
	 * 
	 * 쳲������������£�
	 * 
	 * 	1,1,2,3,5,8,13,21,34,...
	 * 
	 * ��ô������fib(5)ʱ����Ҫ����1��fib(4),3��fib(3),3��fib(2)������fib(1)������
	 * 
	 *  fib(5) = fib(4) + fib(3)
	 *  
	 * 	fib(4) = fib(3) + fib(2) ��fib(3) = fib(2) + fib(1)
	 *  
	 *  fib(3) = fib(2) + fib(1)
	 *  
	 * ���������������ظ����㣬��ʵ��������ֻ�����fib(4)��fib(3)��fib(2)��fib(1)��һ�μ��ɣ�
	 * �����optimizeFibonacci�����������Ż���ʹʱ�临�ӶȽ�����O(n).
	 * 
	 * @author rico
	 * @created 2017��5��10�� ����12:00:42
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n) {
		if (n > 0) {
			if (n == 1 || n == 2) { // �ݹ���ֹ����
				return 1;
			}
			return fibonacci(n - 1) + fibonacci(n - 2); // �ݹ���ã���С����Ĺ�ģ
		}
		return -1;
	}


	/**     
	 * @description �Ծ���ݹ鷨���Ż�
	 * 
	 * 쳲������������£�
	 * 
	 * 	1,1,2,3,5,8,13,21,34,...
	 * 
	 * ��ô�����ǿ�����������fib(1,1,5) = fib(1,2,4) = fib(2,3,3) = 5
	 * 
	 * Ҳ����˵����1,1��ͷ��쳲��������еĵ�����������1,2��ͷ��쳲��������еĵ����
	 * ����1,2��ͷ��쳲��������еĵ�����Ҳ������2,3��ͷ��쳲��������еĵ����
	 * ��ֱ�ӵأ����ǾͿ���һ����λ��fib(2,3,3) = 2 + 3 = 5,��������� 
	 * 
	 * ע�⣬ǰ�������������еĿ�ͷ��������������������������ǰ����������ͷ�����еĵڼ��
	 * 
	 * ʱ�临�Ӷȣ�O(n)
	 * 
	 * @author rico       
	 * @param first ���еĵ�һ��
	 * @param second ���еĵڶ���
	 * @param n Ŀ����
	 * @return     
	 */
	public static int optimizeFibonacci(int first, int second, int n) {
		if (n > 0) {
			if(n == 1){
				return first;
			}else if(n == 2){
				return second;
			}else if (n == 3) {
				return first + second;
			}
			return optimizeFibonacci(second, first + second, n - 1);
		}
		return -1;
	}
	
	
	/**
	 * @description �ǵݹ�ⷨ����ȥ�޻�
	 * @author rico
	 * @created 2017��5��10�� ����12:03:04
	 * @param n
	 * @return
	 */
	public static int fibonacci_loop(int n) {

		if (n > 0) {

			if (n == 1 || n == 2) {
				return 1;
			}

			int result = -1;
			int first = 1; // �Լ�ά����"ջ",�Ա�״̬����
			int second = 1; // �Լ�ά����"ջ",�Ա�״̬����

			for (int i = 3; i <= n; i++) { // ѭ��
				result = first + second;
				first = second;
				second = result;
			}
			return result;
		}
		return -1;
	}

	  
	/**     
	 * @description ʹ������洢쳲���������
	 * @author rico       
	 * @param n
	 * @return     
	 */
	public static int fibonacci_array(int n) {
		if (n > 0) {
			int[] arr = new int[n];   // ʹ����ʱ����洢쳲���������
			arr[0] = arr[1] = 1;

			for (int i = 2; i < n; i++) {   // Ϊ��ʱ���鸳ֵ
				arr[i] = arr[i-1] + arr[i-2];
			}
			return arr[n - 1];
		}
		return -1;
	}
	

	public static void main(String[] args) {
		System.out.println(fibonacci_loop(7));
		System.out.println(optimizeFibonacci(1, 1, 1000));
		System.out.println(fibonacci(1000));
		System.out.println(fibonacci_array(7));
	}
}
