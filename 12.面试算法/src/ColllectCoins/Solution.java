package ColllectCoins;

/**
 * Title: ��Ӳ������(��̬�滮) Description: �����������ֵΪ1Ԫ��3Ԫ��5Ԫ��Ӳ������ö����������ٵ�Ӳ�Ҵչ�nԪ��
 * 
 * ��̬�滮�㷨ͨ������һ�����ƹ�ʽ��һ��������ʼ״̬����ǰ������Ľ⽫����һ��������Ľ��Ƴ���ʹ�ö�̬�滮������ֻ��Ҫ����ʽʱ�临�Ӷȣ�������Ȼ��ݷ���
 * ��������Ҫ����ࡣ
 * 
 * ״̬ת�Ʒ��̣� d(i) = min{ d(i-vj)+ 1 }������i-vj >=0��vj��ʾ��j��Ӳ�ҵ���ֵ
 * 
 * @author rico
 * @created 2017��6��20�� ����5:18:28
 */
public class Solution {

	public int calculateCoins(int target, int[] coins) {

		// ��״̬0~״̬target,�� (target+1)��״̬
		int[] dp = new int[target + 1];
		dp[0] = 0;   // ��ʼ״̬
		for (int i = 1; i < dp.length; i++) {  // ��״̬�ĳ�ʼ��
			dp[i] = Integer.MAX_VALUE;
		}

		// ���õ��ƹ�ʽ�����״̬�µ�ȡֵ
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j] && dp[i - coins[j]] + 1 < dp[i]) {
					dp[i] = dp[i - coins[j]] + 1;
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 3, 5 };
		System.out.println(new Solution().calculateCoins(11, coins));
	}
}
