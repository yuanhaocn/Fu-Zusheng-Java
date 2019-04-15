package Offer66;

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
public class Solution {

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
			boolean result = false;
			int index = 0;
			char target = str[index];
			// ��Ѱ�����Դ��������λ�ÿ�ʼ���ң�ֱ����·����strƥ���û�ж�Ӧ����ڿ���ʹ·����strƥ��
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (matrix[i * cols + j] == target) { // ��ڴ�
						boolean[] flag = new boolean[matrix.length];
						result = hasPathCore(matrix, rows, cols, i, j, str,
								index, flag);
						if (result) { // ���ɹ�����ֱ�ӷ��أ����򣬴���һ����ڴ�����
							return result;
						}
					}
				}
			}
			return result;
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
		if (index == str.length - 1) {
			return true;
		} else {
			boolean result = false;
			int k = i;
			int m = j;
			System.out.println("K : " + k + ", M : " + m);
			System.out.println("index : " + index);
			flag[k * cols + m] = true;

			
			
			
			// ������ֿ���
			boolean r1 = false;
			boolean r2 = false;
			boolean r3 = false;
			boolean r4 = false;

			// ����
			if (m + 1 < cols && !flag[k * cols + m + 1]
					&& str[index + 1] == matrix[k * cols + m + 1]) {
				flag[k * cols + m + 1] = true;
				r1 = hasPathCore(matrix, rows, cols, i, j + 1, str, index + 1,
						flag);
			}

			// ����
			if (k + 1 < rows && !flag[k * cols + m + cols]
					&& str[index + 1] == matrix[k * cols + m + cols]) {
				flag[k * cols + m + cols] = true;
				r2 = hasPathCore(matrix, rows, cols, i + 1, j, str, index + 1,
						flag);
			}

			// ����
			if (m - 1 >= 0 && !flag[k * cols + m - 1]
					&& str[index + 1] == matrix[k * cols + m - 1]) {
				flag[k * cols + m - 1] = true;
				r3 = hasPathCore(matrix, rows, cols, i, j - 1, str, index + 1,
						flag);
			}

			// ����
			if (k - 1 >= 0 && !flag[k * cols + m - cols]
					&& str[index + 1] == matrix[k * cols + m - cols]) {
				flag[k * cols + m - cols] = true;
				r4 = hasPathCore(matrix, rows, cols, i - 1, j, str, index + 1,
						flag);
			}

			result = r1 || r2 || r3 || r4; // ���
			if (!result) {
				--index;
				flag[k * cols + m] = false;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		// char[] matrix = { 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'S', 'F',
		// 'C', 'S', 'L', 'O', 'P', 'Q', 'A', 'D', 'E', 'E', 'M', 'N',
		// 'O', 'E', 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M', 'V', 'C',
		// 'E', 'I', 'F', 'G', 'G', 'S' };
		char[] matrix = { 'A', 'B', 'D', 'B', 'C', 'O' };
		int rows = 2;
		int cols = 3;
		// char[] str = { 'S', 'G', 'G', 'F', 'I', 'E', 'C', 'V', 'A', 'A', 'S',
		// 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G', 'Q', 'E', 'M' };
		char[] str = { 'A', 'B', 'C', 'B', 'D' };
		System.out.println(s.hasPath(matrix, rows, cols, str));
	}
}
