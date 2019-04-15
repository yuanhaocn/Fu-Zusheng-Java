package Offer10;

/**        
 * Title: M�Ķ����Ʊ�ʾ��Ҫ�ı����λ���ܱ��N�Ķ����Ʊ�ʾ    
 * Description: ���������ת��������"��������1�ĸ���"����� 
 * �ײ�˼�룺��1�����������
 * ��һ��������ȥ1֮���ٺ�ԭ����������λ�����㣬�õ��Ľ���൱�ڰ�ԭ�����Ķ����Ʊ�ʾ�е����ұ�һ��1���0
 * @author rico       
 * @created 2017��6��5�� ����4:27:46    
 */      
public class M_to_N_Binary {
	  
	/**     
	 * @description ����ı��ʣ�M��N�Ķ����Ʊ�ʾ���ж���λ��ͬ
	 * @author rico       
	 * @created 2017��6��5�� ����4:31:21     
	 * @param M
	 * @param N
	 * @return     
	 */
	public int changeMtoN(int M, int N){
		int temp = M^N;
		int count = 0;
		
		while(temp != 0){
			count ++;
			temp = temp & (temp - 1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new M_to_N_Binary().changeMtoN(10, 13));
	}
}
