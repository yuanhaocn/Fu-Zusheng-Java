package ThreadLocal;
/**
 * ֧�ַ��ͣ��ṩһ�����ݴ洢����������ݹ����ÿ���߳�ÿ���̶߳������ɵ���ɾ�Ĳ飬����
 * ��������޸Ķ���ʧЧ��
 *
 */
class Demo{
	public static void main(String[] args) {
		/*����ThreadLocal���󣬲��ҳ�ʼ���̱߳��ض���
		 * �̵߳ĳ�ʼ��������Ψһ����
		 */
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {//����ķ��ͱ�ҪҪд�����򱨴�
			@Override
			protected Integer initialValue() {
				return 10;
			}
		};
	}
}