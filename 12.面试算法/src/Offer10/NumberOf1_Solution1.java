package Offer10;

/**        
 * Title:��������1�ĸ���     
 * Description: ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * 
 * ������λ����Ȼ������(��һ�������ڼ�����У�-0����С�ĸ�����������0)
 * ������λ����Ȼ�Ǹ���
 * 
 * @author rico       
 * @created 2017��6��4�� ����5:37:32    
 */      
public class NumberOf1_Solution1 {
	  
	/**     
	 * @description �������������Ʊ�ʾ�м�λ��ѭ������
	 * @author rico       
	 * @created 2017��6��5�� ����3:28:36     
	 * @param n
	 * @return     
	 */
	public int NumberOf1(int n) {
		int temp = 1;
		int count = 0;
		while (temp != 0) {    // ѭ��������������1���Ʊ��0��������ж�����λ��ɨ��ͱȶ�
			//��(temp & n) == temp,˵��n�Ķ������ڶ�Ӧλ����Ϊ 1
			count = (temp & n) == temp ? ++count : count;  
			temp = temp << 1;  // temp ����������
		}
		return 	count;
	}
	
	public static void main(String[] args) {
		System.out.println(new NumberOf1_Solution1().NumberOf1(-5));
		System.out.println(new NumberOf1_Solution1().NumberOf1(5));
	}
}
