package B$����;

/**
 *ʹ��˯�߻���--��Ȼ����
 */
public class ThreadProrResult {
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
					obj2.notify();//�����߳�ThreadB
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
					//�������
					try {
						obj2.wait();//������˯��
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//############################	����ִ��obj2.notify();//�����߳�ThreadB	#####################################
//#############################		������ʱ���ֻ�����		###########################
					System.out.println(getId() + "�õ���Obj2�����");
					synchronized (obj1) {
						System.out.println(getId() + "�õ���Obj1��obj2����������");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new ThreadProrResult().new ThreadA().start();
		new ThreadProrResult().new ThreadB().start();
	}
}
