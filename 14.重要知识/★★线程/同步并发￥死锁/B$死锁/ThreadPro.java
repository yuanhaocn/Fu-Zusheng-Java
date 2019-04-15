package B$����;

/**
 * * �������ĸ����� 
 	* ���󱣳�---�Ҳ������׷����ģ���̫�� 
 	* ���󻥳�---��Դ��ӵ�з�������ì�ܵ� 
 	* ���ɰ���---����ǿ�а����������̵߳���Դ
 	* �γɻ�·---��Դ������Ψһ�ģ����ɸ��� 
 * ����ƻ��Ҫ������&��������Ҫ��ƻ��
 *�����Ľ��
 *	�����޷������ֻ�ܱ���
 *	˼·��
 	*	1)�ѽ��и�ֵ��ݣ����Ϳ����ԣ���򵥣�
 	*	2)Ѱ�ҿ����������������ƻ�·
 	*	3)��ʱ���أ�ʹ�����֮�����Դ�ó���(���õľ��ⷽ��)
 	*	4)
 	*���ʣ�ֻҪ�����ĸ��������κ�һ�������������Ա���
 */
public class ThreadPro {
	private int number = 1;
	private Object obj1 = new Object();
	private Object obj2 = new Object();

	class ThreadA extends Thread {
		@Override
		public void run() {
			while (number == 1) {
				synchronized (obj1) {
					System.out.println(getId() + "�õ���Obj1�����");
					synchronized (obj2) {
						System.out.println(getId() + "�õ���Obj1��obj2����������");
					}
				}
			}
		}
	}

	class ThreadB extends Thread {
		@Override
		public void run() {
			while (number == 1) {
				synchronized (obj2) {
					System.out.println(getId() + "�õ���Obj2�����");
					synchronized (obj1) {
						System.out.println(getId() + "�õ���Obj1��obj2����������");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new ThreadPro().new ThreadA().start();
		new ThreadPro().new ThreadB().start();
	}
}
