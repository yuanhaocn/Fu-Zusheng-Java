package Offer49;

/**
 * Title: ���ַ���ת��������
 * Description:��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 * ��������: ����һ���ַ���,����������ĸ����,����Ϊ�� 
 * �������:����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
 *
 *
 * ���룺
 * +2147483647
 * 1a33
 * 
 * 
 * ���
 * 2147483647
 * 0
 * @author rico
 * @created 2017��7��2�� ����3:03:46
 */
public class Solution {
	  
	/**     
	 * @description ʹ��Integer�Ĺ��췽������
	 * @author rico       
	 * @created 2017��7��2�� ����3:15:39     
	 * @param str
	 * @return     
	 */
	public int StrToInt(String str) {
		try{
			Integer num = new Integer(str);
			return num;
		}catch(Exception e){
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = null;
		System.out.println(s.StrToInt(str));
	}
}
