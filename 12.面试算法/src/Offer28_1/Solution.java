package Offer28_1;

import java.util.ArrayList;
import java.util.List;
  
/**        
 * Title:�ַ����������ַ������(���� + �ݹ�) 
 * Description: ����һ���ַ�����������ַ����������ַ����������
 * �������ߣ��ַ������ظ��ַ�ȥ�أ��ֱ��ȡ��1...n���ַ�����ϣ�����һ�����õ���������Ϻϲ� 
 * @author rico       
 * @created 2017��6��18�� ����6:03:20    
 */      
public class Solution {

	/**     
	 * @description ����һ���ַ�����������ַ����������ַ���������� 
	 * @author rico       
	 * @created 2017��6��18�� ����5:46:26     
	 * @param s
	 * @return     
	 */
	public static List<String> getStringCombinations(String s) {
		s = deleteRepeatChar(s);
		List<String> list = new ArrayList<String>();
		if (s == null) {
			return list;
		}else{
			for (int i = 1; i <= s.length(); i++) {
				list.addAll(getStringCombinations(s, i));
			}
		}
		return list;
	}

	/**
	 * @description ��n���ַ����ַ���s�еĺ�m���ַ����������
	 * @author rico
	 * @created 2017��6��18�� ����5:14:15
	 * @param s
	 * @param n
	 * @param m
	 * @return
	 */
	public static List<String> getStringCombinations(String s, int m) {
		List<String> list = new ArrayList<String>();
		if (s.length() < m) { // �߽�����
			return list;
		}else if (s.length() == m) {  // �ݹ���ֹ������sǡ�ð���m���ַ�
			list.add(s);
			return list;
		} else if (m == 1) {   // �ݹ���ֹ�������ַ���s�����������ֻ����һ���ַ������ 
			char[] chars = s.toCharArray();
			for (char c : chars) {
				list.add(String.valueOf(c));
			}
			return list;
		} else {   // ��С���ⷶΧ����ʼ�ݹ�:���������
			
			// ���ַ� + �ӳ����ַ������ʣ��m-1���ַ���ѡȡm-1���ַ�
			List<String> tmp = getStringCombinations(s.substring(1), m - 1);
			for (String str : tmp) {
				list.add(s.charAt(0) + str);
			}
			
			// �����ַ������ʣ��m-1���ַ���ѡȡm���ַ�
			list.addAll(getStringCombinations(s.substring(1), m));
			return list;
		}
	}
	
	  
	/**     
	 * @description �ַ���ȥ���ظ��ַ�(ɾ���ظ��ַ���ʹ�ַ����� �ַ�����)���ݹ��㷨
	 * @author rico       
	 * @created 2017��6��18�� ����5:59:58     
	 * @param target
	 * @return     
	 */
	public static String deleteRepeatChar(String target){
		if (target == null) {
			return target;
		}else if (target.length() == 1) {
			return target;
		}else{
			char c = target.charAt(0);
			String temp = deleteRepeatChar(target.substring(1));
			temp = temp.replaceAll(String.valueOf(c), "");
			return c + temp;
		}
	}
	
	public static void main(String[] args) {
		String test = "abcbcd";
		System.out.println(getStringCombinations(test));
		
		System.out.println(deleteRepeatChar("adasada"));
	}
}
