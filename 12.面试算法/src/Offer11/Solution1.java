package Offer11;

/**
 * Title: ��ֵ�������η�
 *  Description:����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * 
 * @author rico
 * @created 2017��6��5�� ����4:49:19
 */
public class Solution1 {

	public double Power(double base, int exponent) {
		if (base == 0) { // �߽����
			return 0;
		} else if (exponent == 0) { // �߽����
			return 1;
		}

		int e = Math.abs(exponent);
		double result = getPower(base, e); // ����base��e�η�

		// ����exponent�������ԣ������Ƿ�ȡ����
		return exponent > 0 ? result : (1 / result);
	}

	/**
	 * @description ��һ������n����,����������,������˵Ĵ���(˼��:a^b = a^(b/2)*a^(b/2)),�ݹ��㷨
	 * @author rico
	 * @created 2017��6��5�� ����6:01:32
	 * @param base  ����
	 * @param exponent  ָ��
	 * @return
	 */
	private double getPower(double base, int exponent) {
		// �ݹ���ֹ����
		if (exponent == 0) {
			return 1.0;  	// ���龰
		} else if (exponent == 1) {
			return base;  	// ���龰
		}

		// �ݹ����base��(exponent/2)��
		exponent = exponent >> 1;
		double result = getPower(base, exponent);   // ��ȡ�ظ����߼�����С�����ģ
		result *= result;  	// ������˴���
		if ((exponent & 1) == 1) { 	// �ж�һ�����Ƿ��������������Ļ����������һ��('=='���ȼ�����'&')
			result *= base;
		}

		return result;
	}
}
