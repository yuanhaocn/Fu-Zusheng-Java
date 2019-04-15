package Offer10;
  
/**        
 * Title: ��A-Z��ʾ��26����ת����10������(A��26���Ʊ�ʾ1)    
 * Description: ��Excel2003�У�A��ʾ��1�У�B��ʾ��2��...Z��ʾ��26�У�
 * AA��ʾ��27�У�AB��ʾ��28��...�Դ����ơ�����һ������ĸ��ʾ���кű��룬������ǵڼ��С�
 * @author rico       
 * @created 2017��6��4�� ����5:23:17    
 */      
public class EXCEL_A_Z {
	
	public static int getColum(String s){
		if (s != null && s.length() != 0) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				int num = s.charAt(s.length()- i - 1) - 'A' + 1;
				count += num*Math.pow(26, i);
			}
			return count;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(EXCEL_A_Z.getColum("AA"));
		System.out.println(EXCEL_A_Z.getColum("SE"));
	}
}
