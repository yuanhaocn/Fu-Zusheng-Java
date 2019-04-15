package Offer20;

/**        
 * Title: ˳ʱ���ӡ����(��һ���Ƿ���)    
 * Description:����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10. 
 * @author rico       
 * @created 2017��6��15�� ����12:13:22    
 */
import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix != null) {
			int minrow = 0;
			int maxrow = matrix.length - 1;
			int mincol = 0;
			int maxcol = matrix[0].length - 1;
			result = printMatrix(matrix, minrow, maxrow, mincol, maxcol);
		}
		return result;
	}

	/**
	 * @description ��ӡһȦ(�����������Σ�����һȦ��ֻ��һ�У�ֻ��һ�У�ֻ��һ��Ԫ��)���ݹ��㷨
	 * @author rico
	 * @created 2017��6��15�� ����3:43:39
	 * @param matrix
	 *            ԭʼ����
	 * @param minrow
	 *            ��Ȧ�е�������
	 * @param maxrow
	 *            ��Ȧ�е�������
	 * @param mincol
	 *            ��Ȧ�е�������
	 * @param maxcol
	 *            ��Ȧ�е�������
	 * @return
	 */
	public ArrayList<Integer> printMatrix(int[][] matrix, int minrow,
			int maxrow, int mincol, int maxcol) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (maxrow < 0 || maxcol < 0 || minrow > maxrow || mincol > maxcol) { // �ݹ���ֹ����1������������
			return result;
		} else if (minrow == maxrow && mincol == maxcol) { // �ݹ���ֹ����2��ֻʣ�����м�һ��Ԫ��
			result.add(matrix[minrow][minrow]);
			return result;
		} else if (minrow == maxrow) { // �ݹ���ֹ����3��ֻʣһ��
			for (int i = mincol; i <= maxcol; i++) {
				result.add(matrix[minrow][i]);
			}
			return result;
		} else if (mincol == maxcol) { // �ݹ���ֹ����4��ֻʣһ��
			for (int i = minrow; i <= maxrow; i++) {
				result.add(matrix[i][maxcol]);
			}
			return result;
		} else { // ���ж��У���С��ģ���ݹ�ִ��
			for (int i = mincol; i < maxcol; i++) {
				result.add(matrix[minrow][i]);
			}
			for (int i = minrow; i < maxrow; i++) {
				result.add(matrix[i][maxcol]);
			}
			for (int i = maxcol; i > mincol; i--) {
				result.add(matrix[maxrow][i]);
			}
			for (int i = maxrow; i > minrow; i--) {
				result.add(matrix[i][mincol]);
			}
			result.addAll(printMatrix(matrix, ++minrow, --maxrow, ++mincol,
					--maxcol)); // �ݹ�ִ��
			return result;
		}
	}
}
