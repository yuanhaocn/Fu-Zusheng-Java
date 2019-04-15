package Offer66;

import java.util.Arrays;

/**
 * Title:�����е�·��
 * Description:�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ
 * ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� ���� a b c e s f c
 * s a d e e
 * �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��
 * ·�������ٴν���ø��ӡ�
 * 
 * �ռ临�Ӷȣ������ռ�O(rows*cols) + �ݹ����ջ
 * 
 * @author rico
 * @created 2017��7��9�� ����12:09:59
 */
public class Solution1 {

	/**
	 * @description �������е���ڣ�Ѱ����str��ƥ���·��
	 * @author rico
	 * @created 2017��7��9�� ����3:25:35
	 * @param matrix
	 *            ����
	 * @param rows
	 *            ��������
	 * @param cols
	 *            ��������
	 * @param str
	 *            ��ƥ��·��
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || matrix.length == 0 || str == null
				|| str.length == 0) { // �߽�����
			return false;
		} else {
			int index = 0;
			boolean[] flag = new boolean[matrix.length];
			System.out.println("��ʼ״̬ �� " + Arrays.toString(flag));
			System.out.println("-----------------------------------");
			// ���Դ��������λ�ÿ�ʼ����
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (hasPathCore(matrix, rows, cols, i, j, str, index, flag)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	/**
	 * @description �ݹ��㷨�����˼·
	 * @author rico
	 * @created 2017��7��9�� ����3:24:06
	 * @param matrix
	 *            ��������
	 * @param rows
	 *            ��������
	 * @param cols
	 *            ��������
	 * @param i
	 *            ��ǰ��������
	 * @param j
	 *            ��ǰ��������
	 * @param str
	 *            Ŀ�괮
	 * @param index
	 *            ��ǰ�ַ���λ��
	 * @param flag
	 *            ��¼�����Ƿ񱻾���
	 */
	public boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j,
			char[] str, int index, boolean[] flag) {
		if (i >= 0 && i < rows && j >= 0 && j < cols && !flag[i * cols + j]
				&& str[index] == matrix[i * cols + j]) {
			if (index == str.length-1) {  // �ݹ���ֹ����
				return true;
			}
			boolean result = false;
			System.out.println("I : " + i + ", J : " + j);
			System.out.println("index : " + index);
			flag[i * cols + j] = true;
			index++;
			System.out.println("״̬ �� " + Arrays.toString(flag));
			System.out.println("-----------------------------------");

			// ������ֿ���
			boolean r1 = false;
			boolean r2 = false;
			boolean r3 = false;
			boolean r4 = false;

			// ����
			r1 = hasPathCore(matrix, rows, cols, i, j + 1, str, index, flag);
			// ����
			r2 = hasPathCore(matrix, rows, cols, i + 1, j, str, index, flag);
			// ����
			r3 = hasPathCore(matrix, rows, cols, i, j - 1, str, index, flag);
			// ����
			r4 = hasPathCore(matrix, rows, cols, i - 1, j, str, index, flag);

			result = r1 || r2 || r3 || r4; // ���

			// ·������
			if (!result) {
				--index;
				flag[i * cols + j] = false;
				System.out.println("����״̬ �� " + Arrays.toString(flag));
			}
			return result;
		} else { // �ݹ���ֹ����
			return false;
		}
	}

	public static void main(String[] args) {
		Solution1 s = new Solution1();
//		char[] matrix = { 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'S', 'F',
//				'C', 'S', 'L', 'O', 'P', 'Q', 'A', 'D', 'E', 'E', 'M', 'N',
//				'O', 'E', 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M', 'V', 'C',
//				'E', 'I', 'F', 'G', 'G', 'S' };
		 char[] matrix = { 'A', 'B', 'D', 'B', 'C', 'O' };
		 int rows = 2;
		 int cols = 3;
//		int rows = 5;
//		int cols = 8;
//		char[] str = { 'S', 'G', 'G', 'F', 'I', 'E', 'C', 'V', 'A', 'A', 'S',
//				'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'Q', 'E', 'M' };
		 char[] str = { 'A', 'B', 'C', 'B', 'D' };
		System.out.println(s.hasPath(matrix, rows, cols, str));
	}
}
