package Offer10;

/**        
 * Title:�ж�һ������2�������η�
 * Description: �ײ�˼�룺��1��
 * ��һ��������ȥ1֮���ٺ�ԭ����������λ�����㣬�õ��Ľ���൱�ڰ�ԭ�����Ķ����Ʊ�ʾ�е����ұ�һ��1���0
 * @author rico       
 * @created 2017��6��5�� ����4:23:23    
 */      
public class isPowerof2_Solution {
	  
	/**     
	 * @description ��һ������2�������η�����ô���Ķ����Ƹ�ʽ��ֻ��һ��1
	 * @author rico       
	 * @created 2017��6��5�� ����4:21:44     
	 * @param n
	 * @return     
	 */
	public boolean isPowerof2(int n){
		return (n & (n - 1)) == 0;  
	}
	
	
	public static void main(String[] args) {
		System.out.println(new isPowerof2_Solution().isPowerof2(5));
		System.out.println(new isPowerof2_Solution().isPowerof2(11122));
		System.out.println(new isPowerof2_Solution().isPowerof2(64));
		System.out.println(new isPowerof2_Solution().isPowerof2(346));
	}
}
