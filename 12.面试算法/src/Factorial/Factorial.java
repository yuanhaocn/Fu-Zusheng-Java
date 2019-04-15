package Factorial;

/**
 * Title: �׳˵�ʵ�� 
 * Description:
 * 		�ݹ�ⷨ
 * 		�ǵݹ�ⷨ
 * @author rico
 */
public class Factorial {

	  
	/**     
	 * @description �׳˵ĵݹ�ʵ��
	 * @author rico       
	 * @created 2017��5��10�� ����8:45:48     
	 * @param n
	 * @return     
	 */
	public static long f(int n) {
		if (n == 1) // �ݹ���ֹ����
			return 1;

		return n * f(n - 1); // // �ݹ���ã���С����Ĺ�ģ
	}

	  
	/**     
	 * @description �׳˵ķǵݹ�ʵ��
	 * @author rico       
	 * @created 2017��5��10�� ����8:46:43     
	 * @param n
	 * @return     
	 */
	public static long f_loop(int n) {
		long result = n;
		while (n > 1) {
			n--;
			result = result * n;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Recursive : " + f(6));
		System.out.println("Recursive : " + f(20));
		System.out.println("Loop : " + f_loop(6));
		System.out.println("Loop : " + f_loop(20));
	}
}
