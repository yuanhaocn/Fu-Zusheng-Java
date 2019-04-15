package Offer31;
/**
 * Title:���������������
 * 
 * Description:HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����
 * ,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,������
 * �Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * ��᲻�ᱻ������ס��(�������ĳ���������1)
 * 
 * ʱ�临�Ӷ�O(n)
 * 
 * @author rico
 * @created 2017��6��20�� ����10:39:07
 */
public class Solution {
	public int FindGreatestSumOfSubArray(int[] array) {
		if ((array == null) || array.length <= 0) {  // �߽�����
			return 0;
		}
		int curSum = 0;  // ���浱ǰ����������ĺ�
		int greatestSum = Integer.MIN_VALUE;   // ��������������͵����ֵ
		for (int i = 0; i < array.length; i++) {
			if (curSum <= 0) {  // ֻҪcurSum������0���������ۼ�
				curSum = array[i];
			} else {    // ֻҪcurSum����0���Ͳ����ۼ�
				curSum += array[i];
			}
			if (curSum > greatestSum) {  //ÿ���ж�curSum��greatestSum��ֵ������ʱ����
				greatestSum = curSum;
			}
		}
		return greatestSum;
	}

	public static void main(String[] args) {
		// int[] test = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int[] test = { 6, -3, -2, 7, -15, 1, 2, 2 };
		System.out.println(new Solution().FindGreatestSumOfSubArray(test));
	}
}
