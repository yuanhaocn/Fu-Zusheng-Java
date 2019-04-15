package PalindromeString;
/**        
 * Title: �����ַ������ж�    
 * Description: �����ַ�����������������һ�����ַ�������"98789", "abccba"���ǻ����ַ���
 * 
 * ���ֽⷨ��
 * 		�ݹ��жϣ�
 * 		ѭ���жϣ�
 *      StringBuilder
 * 
 * @author rico       
 */      
public class PalindromeString {
	
	/**     
	 * @description �ݹ��ж�һ���ַ����Ƿ��ǻ����ַ���
	 * @author rico       
	 * @created 2017��5��10�� ����5:45:50     
	 * @param s
	 * @return     
	 */
	public static boolean isPalindromeString_recursive(String s){
		int start = 0;
		int end = s.length()-1;
		if(end > start){   // �ݹ���ֹ����:����ָ�������ƶ�����start����endʱ������ж�
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}else{
				// �ݹ���ã���С����Ĺ�ģ
				return isPalindromeString_recursive(s.substring(start+1).substring(0, end-1));
			}
		}
		return true;
	}
	
	/**     
	 * @description ѭ���жϻ����ַ���
	 * @author rico       
	 * @param s
	 * @return     
	 */
	public static boolean isPalindromeString_loop(String s){
		char[] str = s.toCharArray();
		int start = 0;
		int end = str.length-1;
		while(end > start){  // ѭ����ֹ����:����ָ�������ƶ�����start����endʱ������ж�
			if(str[end] != str[start]){
				return false;
			}else{
				end --;
				start ++;
			}
		}
		return true;
	}
	  
	/**     
	 * @description ����StringBuilder��reverse()�����ж�
	 * @author rico       
	 * @param s
	 * @return     
	 */
	public static boolean isPalindromeString_stringBuilder(String s){
		StringBuilder sb = new StringBuilder(s);
		return s.equals(sb.reverse().toString());
	}
	
	
	public static void main(String[] args) {
		String s = "1441";
		System.out.println("Loop : " + isPalindromeString_loop(s));
		System.out.println("StringBuilder : " + isPalindromeString_stringBuilder(s));
		System.out.println("Recursive : " + isPalindromeString_recursive(s));
	}
}
