package Offer32;

/**
 * Title: ������1���ֵĴ�������1��n������1���ֵĴ�����
 * Description: ʱ�临�Ӷȣ�O(n*lgn)
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������1
 * ��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�����
 * 
 * ���Ƽ���ÿ�����Ķ����Ʊ�ʾ��1�ĸ�������������ͨ����2(ֻ��������)������1�ĸ�����ʮ����ͨ����10������1�ĸ���
 * 
 * ʮ���Ƶ�λ����lgN+1
 * 
 * @author rico
 * @created 2017��6��20�� ����9:15:47
 */
public class Solution {
      
    /**     
     * @description �������	
     * @author rico       
     * @created 2017��6��20�� ����10:45:31     
     * @param n
     * @return     
     */
    public int NumberOf1Between1AndN_Solution(int n) {
    	int count = 0;
    	for (int i = 1; i <= n; i++) {
			count += NumberOf1(i);
		}
    	return count;
    }
      
    /**     
     * @description ����ÿ������1�ĸ�������������ͨ����2(ֻ��������)������1�ĸ�����ʮ����ͨ����10������1�ĸ���
     * @author rico       
     * @created 2017��6��20�� ����10:45:09     
     * @param n
     * @return     
     */
    public int NumberOf1(int n) {
    	int count = 0;
    	while( n != 0){
    		if (n%10 == 1) {
				count ++;
			}
    		n = n/10;
    	}
    	return count;
    }
    
      
    /**     
     * @description ����һ��ʮ��������λ��
     * @author rico       
     * @created 2017��6��21�� ����7:36:00     
     * @param N
     * @return     
     */
    public static int countDigit(int N){
    	return (int) (Math.log10(N) + 1);
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.NumberOf1Between1AndN_Solution(101));
		
		System.out.println(Solution.countDigit(1000));
	}
}
