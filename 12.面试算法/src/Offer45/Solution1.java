package Offer45;

/**
 * Title:�����ǵ���Ϸ(ԲȦ�����ʣ�µ���) 
 * Description: ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��
 * ,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:����,��С������Χ��һ����Ȧ
 * ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�
 * ,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ
 * ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���
 * ,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 * 
 * @author rico
 * @created 2017��7��2�� ����9:39:03
 */
public class Solution1 {
	  
	/**     
	 * @description �ҹ��ɣ���ݹ鹫ʽ���ݹ��㷨
	 * @author rico       
	 * @created 2017��7��2�� ����1:59:07     
	 * @param n
	 * @param m
	 * @return     
	 */
	public int LastRemaining_Solution(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		} else if (n == 1) {
			return 0;
		} else {
			return (LastRemaining_Solution(n - 1, m) + m) % n;
		}
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.LastRemaining_Solution(5, 3));
	}
}
