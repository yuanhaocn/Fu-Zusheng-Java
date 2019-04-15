package Offer28;
import java.util.Arrays;

/**
 * Title: �ַ���ȫ���зǵݹ��㷨(�ֵ���ȫ����)
 * Description: �ֵ���ȫ���У������˼���ǣ�
 * �ȶ���Ҫ�����е��ַ��������ֵ����򣬼��õ�ȫ��������С������.
 * Ȼ��,�ҵ�һ�����������С��ȫ���У�һֱ�ظ���һ��ֱ���ҵ����ֵ,���ֵ������������.
 * 
 * ����Ҫ�����ַ�������
 * 
 * @author rico
 */
public class StringPermutationsLoop {

	/**
	 * @description �ֵ���ȫ����
	 * 
	 * ��һ���ַ���(�ַ�����)��ȫ������n�����ֱ���A1,A2,A3,...,An
	 * 
	 * 1. �ҵ���С������ Ai
	 * 2. �ҵ�һ����Ai�����С�ĺ������Ai+1
	 * 3. �ظ���һ��ֱ��û�������ĺ��
	 * 
	 * �ص��������ҵ�һ�����е�ֱ�Ӻ��:
	 * �����ַ���(�ַ�����)a0a1a2����an,
	 * 1. ��an��a0Ѱ�ҵ�һ�γ��ֵ��������е������ַ�(��ai < ai+1),��ôai+1��һ����ֵ����Ϊai+1֮����ַ�Ϊ�������У��� top=i+1;
	 * 2. ��top��(����top)��ʼ���ұ�ai�����С��ֵaj���� minMax = j;
	 * 3. ����minMax����top-1�����ַ�;
	 * 4. ��תtop֮����ַ�(����top)�����õ�һ�����е�ֱ�Ӻ������
	 * 
	 * @author rico
	 * @param s
	 *            �ַ�����
	 * @param from
	 *            ��ʼ�±�
	 * @param to
	 *            ��ֹ�±�
	 */
	public static void getStringPermutations4(char[] s, int from, int to) {
		
		Arrays.sort(s,from,to+1);  // ���ַ����������Ԫ�ؽ����������У����õ���С���� 
		System.out.println(s);    
		
		char[] descendArr = getMaxPermutation(s, from, to); // �õ��������,����С���е�������
		
		while (!Arrays.equals(s, descendArr)) {  // ѭ����ֹ�������������������
			if (s != null && to >= from && to < s.length && from >= 0) { // �߽��������
				int top = getExtremum(s, from, to); // �ҵ����еļ�ֵ
				int minMax = getMinMax(s, top, to);  // ��top��(����top)���ұ�s[top-1]�����Сֵ���ڵ�λ��
				swap(s, top - 1, minMax);  // ����minMax����top-1�����ַ�
				s = reverse(s, top, to);   // ��תtop֮����ַ�
				System.out.println(s);
			}
		}
	}
	
	/**
	 * @description ���ַ������е��ƶ��ַ����н���
	 * @author rico
	 * @param s
	 * @param from
	 * @param to
	 */
	public static void swap(char[] s, int from, int to) {
		char temp = s[from];
		s[from] = s[to];
		s[to] = temp;
	}

	/**     
	 * @description ��ȡ���еļ�ֵ
	 * @author rico       
	 * @param s ����
	 * @param from ��ʼ�±�
	 * @param to ��ֹ�±�
	 * @return     
	 */
	public static int getExtremum(char[] s, int from, int to) {
		int index = 0;
		for (int i = to; i > from; i--) {
			if (s[i] > s[i - 1]) {
				index = i;
				break;
			}
		}
		return index;
	}
	  
	/**     
	 * @description ��top�����ұ�s[top-1]�����Сֵ���ڵ�λ��
	 * @author rico       
	 * @created 2017��5��10�� ����9:21:13     
	 * @param s
	 * @param top ����ֵ����λ��
	 * @param to
	 * @return     
	 */
	public static int getMinMax(char[] s, int top, int to) {
		int index = top;
		char base = s[top-1];
		char temp = s[top];
		for (int i = top + 1; i <= to; i++) {
			if (s[i] > base && s[i] < temp) {
				temp = s[i];
				index = i;
			}
			continue;
		}
		return index;
	}
	  
	/**     
	 * @description ��תtop(����top)�������
	 * @author rico       
	 * @param s
	 * @param from
	 * @param to
	 * @return     
	 */
	public static char[] reverse(char[] s, int top, int to) {
		char temp;
		while(top < to){
			temp = s[top];
			s[top] = s[to];
			s[to] = temp;
			top ++;
			to --;
		}
		return s;
	}
	  
	/**     
	 * @description ������С���еõ��������
	 * @author rico       
	 * @param s ��С����
	 * @param from ��ʼ�±�
	 * @param to ��ֹ�±�
	 * @return     
	 */
	public static char[] getMaxPermutation(char[] s, int from, int to) {
		//����С���и��Ƶ�һ���µ�������
		char[] dsc = Arrays.copyOfRange(s, 0, s.length);
		int first = from;
		int end = to;
		while(end > first){  // ѭ����ֹ����
			char temp = dsc[first];
			dsc[first] = dsc[end];
			dsc[end] = temp;
			first ++;
			end --;
		}
		return dsc;
	}

	public static void main(String[] args) {
		char[] target = { 'a', 'a', 'b', 'c'};
		getStringPermutations4(target, 0, target.length - 1);
	}
}
