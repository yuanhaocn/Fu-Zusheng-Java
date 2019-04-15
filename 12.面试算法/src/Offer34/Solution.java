package Offer34;

/**
 * Title: ���� Description: ��ֻ��������2��3��5��������������Ugly
 * Number��������6��8���ǳ�������14���ǣ���Ϊ����������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * 
 * @author rico
 * @created 2017��6��23�� ����8:40:35
 */
public class Solution {
	  
	/**     
	 * @description �����ж�ÿ�����Ƿ�Ϊ����
	 * @author rico       
	 * @created 2017��6��24�� ����8:35:11     
	 * @param index
	 * @return     
	 */
	public int GetUglyNumber_Solution(int index) {
		int count = 0;
		int number = 1;
		while (count < index) {
			if (isUglyNumber(number)) {
				count++;
			}
			if (count == index)
				break;
			number++;
		}
		return number;
	}

	  
	/**     
	 * @description �ж�һ�����Ƿ�Ϊ����
	 * @author rico       
	 * @created 2017��6��24�� ����8:33:52     
	 * @param num
	 * @return     
	 */
	public boolean isUglyNumber(int num) {
		int tmp = num;
		if (tmp == 1) {
			return true;
		}else if (tmp % 2 == 0) {
			tmp /= 2;
			return isUglyNumber(tmp);
		} else if (tmp % 3 == 0) {
			tmp /= 3;
			return isUglyNumber(tmp);
		} else  if (tmp % 5 == 0){
			tmp /= 5;
			return isUglyNumber(tmp);
		}else{
			return false;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.GetUglyNumber_Solution(2000));
	}
}
