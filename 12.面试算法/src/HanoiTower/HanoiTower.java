package HanoiTower;
/**
 * Title: ��ŵ������ 
 * Description:�Ŵ���һ��������������������A��B��C��A������64�����ӣ����Ӵ�С���ȣ�������£�С�����ϡ�
 * ��һ�����������64�����Ӵ�A���Ƶ�C������ÿ��ֻ�������ƶ�һ�����ӣ��������ƶ������У�3�����ϵ�����ʼ�ձ��ִ������£�
 * С�����ϡ����ƶ������п�������B����Ҫ�������������������ÿ��������ƶ��ġ�
 * 
 * @author rico
 * @created 2017��5��8�� ����10:44:40
 */
public class HanoiTower {
	
	/**     
	 * @description �ڳ����У����ǰ�����������ӳ�Ϊ��һ�����ӣ�������������ӳ�Ϊ��N������
	 * @author rico       
	 * @param level�����ӵĸ���
	 * @param from ���ӵĳ�ʼ��ַ
	 * @param inter ת������ʱ������ת
	 * @param to ���ӵ�Ŀ�ĵ�ַ
	 */
	public static void moveDish(int level, char from, char inter, char to) {

		if (level == 1) { // �ݹ���ֹ����
			System.out.println("��" + from + " �ƶ�����" + level + " �ŵ�" + to);
		} else {
			// �ݹ���ã���level-1�����Ӵ�from�Ƶ�inter(����һ�����ƶ���ÿ��ֻ���ƶ�һ������,����to������ת)
			moveDish(level - 1, from, to, inter); // �ݹ���ã���С����Ĺ�ģ
			// ����level�����Ӵ�A���Ƶ�C��
			System.out.println("��" + from + " �ƶ�����" + level + " �ŵ�" + to); 
			// �ݹ���ã���level-1�����Ӵ�inter�Ƶ�to,from ������ת
			moveDish(level - 1, inter, from, to); // �ݹ���ã���С����Ĺ�ģ
		}
	}

	public static void main(String[] args) {
		int nDisks = 30;
		moveDish(nDisks, 'A', 'B', 'C');
	}
}
