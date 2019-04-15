package PascalTriangle;

/**
 * Title: Description: ����������ֳ�Pascal�����Σ����ĵ�i+1����(a+b)i��չ��ʽ��ϵ����
 * ����һ����Ҫ�����ǣ��������е�ÿ�����ֵ����������ϵ�������ӡ�
 * 
 * �����������������ε�ǰ4�У� 
 *    1 
 *   1 1
 *  1 2 1
 * 1 3 3 1
 * 
 * �����ʽ���������һ���� n��
 * 
 * �����ʽ�������������ε�ǰn�С�ÿһ�д���һ�еĵ�һ������ʼ����������м�ʹ��һ���ո�ָ���
 * �벻Ҫ��ǰ���������Ŀո�
 * 
 * �������룺4
 * 
 * ���������
 * 1 
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 
 * @author rico
 */

public class PascalTriangle {

	private static int[][] arr = null;

	  
	/**     
	 * @description ����һ������n�е��������
	 * @author rico       
	 * @param n     
	 */
	public static void createPascalTriangle(int n) {
		arr = new int[n][n];
		// ��ʼ���������
		for (int i = 0; i < n; i++) {
			arr[i][0] = arr[i][i] = 1;   // ��һ�кͶԽ����ϵ�ֵ��Ϊ 1
			for (int j = 0; j <= i; j++) {
				if (i != j && j != 0) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
		}
	}

	/**     
	 * @description �ݹ��ȡ�������ָ���С���(��0��ʼ)��ֵ
	 * 				ע�⣺���Ƿ񴴽���������޹�
	 * @author rico 
	 * @x  ָ����
	 * @y  ָ����    
	 */
	public static int getValue(int x, int y) {
		if(y <= x && y >= 0){
			if(y == 0 || x == y){   // �ݹ���ֹ����
				return 1; 
			}else{ 
				// �ݹ���ã���С����Ĺ�ģ
				return getValue(x-1, y-1) + getValue(x-1, y); 
			}
		}
		return -1;
	} 
	
	/**     
	 * @description ��ӡ�������
	 * @author rico       
	 * @created 2017��5��10�� ����4:36:26     
	 * @param n     
	 */
	public static void printPascalTriangle() {
		if (arr == null) {
			System.out.println("���ȴ����������...");
			return;
		}
		
		int n = arr.length;
		
		// ��ӡ�������
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (j <= i) {
					sb.append(arr[i][j]).append(" ");
				}
			}
			System.out.println(sb.toString().substring(0, sb.length() - 1));
		}
	}

	public static void main(String[] args) {
		createPascalTriangle(8);
		System.out.println("�������Ϊ�� ");
		printPascalTriangle();
		
		System.out.println("\n--------------------------\n");
		
		System.out.println("�������ָ��λ�õ�ֵΪ ��" + getValue(7, 4)); 

	}
}
