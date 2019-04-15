package Offer67;

/**
 * Title:�����˵��˶���Χ Description:
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * �����ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 =
 * 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * 
 * @author rico
 * @created 2017��7��9�� ����12:11:09
 */
public class Solution {

	public int movingCount(int threshold, int rows, int cols) {
		if (rows < 0 || cols < 0 || threshold < 0) {   // �߽�����
			return 0;
		} else {    
			boolean[] matrix = new boolean[rows * cols];  // ��¼�������Ƿ����ÿ������
			return movingCountCore(matrix, rows, cols, 0, 0, threshold);   // ��λ��(0,0)��ʼ
		}
	}

	/**     
	 * @description �ݹ��㷨
	 * @author rico       
	 * @created 2017��7��9�� ����7:34:45     
	 * @param matrix �����˵��˶�����
	 * @param rows ��������
	 * @param cols ��������
	 * @param i �����˵�ǰ������
	 * @param j �����˵�ǰ������
	 * @param threshold ��ֵ
	 * @return     
	 */
	public int movingCountCore(boolean[] matrix, int rows, int cols, int i, int j,
			int threshold) {
		if (!iscontinue(rows, cols, i, j, matrix, threshold)) {  // �ݹ���ֹ����
			return 0;   // ���龳�µĴ���
		} else {
			int k = i;
			int m = j;
			System.out.println("K : " + k + ", M : " + m);
			matrix[k * cols + m] = true;    // �ﵽ�ø���

			int result1 = 0;
			int result2 = 0;
			int result3 = 0;
			int result4 = 0;

			// ����
			if (m + 1 < cols && !matrix[k * cols + m + 1]
					&& count(k) + count(m + 1) <= threshold) {
				result1 = movingCountCore(matrix, rows, cols, k, m + 1, threshold);
			}

			// ����
			if (k + 1 < rows && !matrix[k * cols + m + cols]
					&& count(k + 1) + count(m) <= threshold) {
				result2 = movingCountCore(matrix, rows, cols, k + 1, m, threshold);
			}

			// ����
			if (m - 1 >= 0 && !matrix[k * cols + m - 1]
					&& count(k) + count(m - 1) <= threshold) {
				result3 = movingCountCore(matrix, rows, cols, k, m - 1, threshold);
			}

			// ����
			if (k - 1 >= 0 && !matrix[k * cols + m - cols]
					&& count(k - 1) + count(m) <= threshold) {
				result4 = movingCountCore(matrix, rows, cols, k - 1, m, threshold);
			}
			return 1 + result1 + result2 + result3 + result4;
		}
	}

	/**
	 * @description ʮ���Ƹ�λ���ĺ�
	 * @author rico
	 */
	public int count(int i) {
		int result = 0;
		do {
			result += i % 10;
			i = i / 10;
		} while (i != 0);
		return result;
	}

	/**
	 * @description �жϻ������ڵ�ǰλ���Ƿ���ƶ�
	 * @author rico
	 */
	public boolean iscontinue(int rows, int cols, int k, int m, boolean[] flag,
			int threshold) {
		int sum = count(k) + count(m);
		boolean flag1 = m < cols && !flag[k * cols + m] && sum <= threshold;
		boolean flag2 = k < rows && !flag[k * cols + m] && sum <= threshold;
		boolean flag3 = m >= 0 && !flag[k * cols + m] && sum <= threshold;
		boolean flag4 = k >= 0 && !flag[k * cols + m] && sum <= threshold;
		return flag1 || flag2 || flag3 || flag4;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int threshold = 3;
		int rows = 3;
		int cols = 2;
		// System.out.println(s.count(0, 1));
		System.out.println(s.movingCount(threshold, rows, cols));
	}
}
