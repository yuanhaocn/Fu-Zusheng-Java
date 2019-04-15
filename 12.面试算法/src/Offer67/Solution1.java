package Offer67;

import java.util.Arrays;

/**
 * Title:�����˵��˶���Χ(���������п��Դﵽ�ĸ��ӵ�����)
 * Description:������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * �����ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 =
 * 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * 
 * @author rico
 * @created 2017��7��9�� ����12:11:09
 */
public class Solution1 {

	public int movingCount(int threshold, int rows, int cols) {
		if (rows < 0 || cols < 0 || threshold < 0) { // �߽�����
			return 0;
		} else {
			boolean[] matrix = new boolean[rows * cols]; // ��¼�������Ƿ����ÿ������
			System.out.println("�����ʼ״̬ �� " + Arrays.toString(matrix));
			System.out.println("-----------------------------------");
			return movingCountCore(matrix, rows, cols, 0, 0, threshold); // ��λ��(0,0)��ʼ
		}
	}

	/**
	 * @description �ݹ��㷨
	 * @author rico
	 * @created 2017��7��9�� ����7:34:45
	 * @param matrix
	 *            �����˵��˶�����
	 * @param rows
	 *            ��������
	 * @param cols
	 *            ��������
	 * @param i
	 *            �����˵�ǰ������
	 * @param j
	 *            �����˵�ǰ������
	 * @param threshold
	 *            ��ֵ
	 * @return
	 */
	public int movingCountCore(boolean[] matrix, int rows, int cols, int i,
			int j, int threshold) {
		if (!iscontinue(matrix, rows, cols, i, j, threshold)) {     //��ǰλ�ò��ɴ�����ѵ���
			return 0; 	//���龳�µĴ���
		} else {
			System.out.println("I : " + i + ", J : " + j);
			matrix[i * cols + j] = true;  // ����ø���
			System.out.println(Arrays.toString(matrix));
			System.out.println("-----------------------------------");

			int result1 = 0;
			int result2 = 0;
			int result3 = 0;
			int result4 = 0;

			// �����ܹ�����ĸ���
			result1 = movingCountCore(matrix, rows, cols, i, j + 1, threshold);

			// �����ܹ�����ĸ���
			result2 = movingCountCore(matrix, rows, cols, i + 1, j, threshold);

			// �����ܹ�����ĸ���
			result3 = movingCountCore(matrix, rows, cols, i, j - 1, threshold);

			// �����ܹ�����ĸ���
			result4 = movingCountCore(matrix, rows, cols, i - 1, j, threshold);

			// ��ǰ�ĸ��� + ���ҡ��ϡ����ܹ�����ĸ���
			return 1 + result1 + result2 + result3 + result4;
		}
	}

	/**
	 * @description ʮ���Ƹ�λ���ĺ�
	 * @author rico
	 */
	public int count(int i) {
		int result = 0;
		while (i != 0) {
			result += i % 10;
			i = i / 10;
		}
		return result;
	}

	/**
	 * @description �жϻ������ڵ�ǰλ���Ƿ���ƶ�
	 * @author rico
	 */
	public boolean iscontinue(boolean[] matrix, int rows, int cols, int i,
			int j, int threshold) {
		int sum = count(i) + count(j);
		// ����������߽硢����������������λ֮�Ͳ�����threshold����Ҫȥ��λ�û�δ�����
		if (i >= 0 && i < rows && j >= 0 && j < cols && sum <= threshold
				&& !matrix[i * cols + j]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int threshold = 3;
		int rows = 3;
		int cols = 2;
		System.out.println("�������ܹ��ﵽ���ٸ����� : "
				+ s.movingCount(threshold, rows, cols));
	}
}
