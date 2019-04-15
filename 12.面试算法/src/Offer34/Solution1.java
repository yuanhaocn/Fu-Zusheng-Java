package Offer34;

/**
 * Title: ���� 
 * Description: ��ֻ��������2��3��5��������������Ugly
 * Number��������6��8���ǳ�������14���ǣ���Ϊ����������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * 
 * @author rico
 * @created 2017��6��23�� ����8:40:35
 */
public class Solution1 {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0)
			return 0;
		int[] result = new int[index];   // ��Ȼ��Ѱ�ҵ�N����������ô�����СΪN
		result[0] = 1;
		int begin = 1, m2 = 0, m3 = 0, m5 = 0;  // �����г��������У���һ������2��3��5���ڵ�ǰ��������λ��
		while (begin < index) {
			result[begin] = min(result[m2] * 2, result[m3] * 3, result[m5] * 5);// ���ڵ�ǰ��ǰ����������С��
			
			// ���� m2��m3 �� m5 ��λ��
			while ((result[m2] * 2 <= result[begin])) {
				m2++;
			}
			while ((result[m3] * 3 <= result[begin])) {
				m3++;
			}
			while ((result[m5] * 5 <= result[begin])) {
				m5++;
			}
			begin++;
		}
		return result[index - 1];
	}

	public int min(int i, int j, int k) {
		int temp = i < j ? i : j;
		return temp < k ? temp : k;
	}
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.GetUglyNumber_Solution(1500));
	}
}
