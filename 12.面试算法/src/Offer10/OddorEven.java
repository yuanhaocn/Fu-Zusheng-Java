package Offer10;

  
/**        
 * Title: �ж�һ����������ż��    
 * Description: 
 * @author rico       
 * @created 2017��6��6�� ����10:06:29    
 */      
public class OddorEven {
	
	/**     
	 * @description �ж�һ����������ż��     
	 * @author rico       
	 * @created 2017��6��6�� ����10:07:54     
	 * @param target
	 * @return  true:����, false:ż��   
	 */
	public static boolean isodd(int target){
		return (target & 1) == 1;
	}
	
	public static void main(String[] args) {
		System.out.println(OddorEven.isodd(1));
		System.out.println(OddorEven.isodd(2));
		System.out.println(OddorEven.isodd(0));
		System.out.println(OddorEven.isodd(823));
		System.out.println(OddorEven.isodd(988));
		System.out.println(OddorEven.isodd(-1));
		System.out.println(OddorEven.isodd(-12));
	}
}
