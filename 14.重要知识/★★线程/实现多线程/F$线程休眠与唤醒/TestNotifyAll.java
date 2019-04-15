package F$�߳������뻽��;
/**
  notifyAll()��ʹ��
  ����wait��notify��notifyAll��������
	��ͬ�㣺
		1������Ҫ��synchronized���������ִ�У������׳��쳣
		2������Object�ķ������������е��߳������󶼿���ʹ��
		3������Ҫ�Ȼ��������ſ���ִ��
		
	����
		1��wait������ʹ�õ�ǰ�̶߳����ڵȴ�״̬�����������ͷŶ�����
			�����޷��ٴλ�ø���
		2��notify��notifyAll��ʹ���ڸ����ϴ��ڵȴ�״̬���ָ̻߳�����	
			���ǲ���ִ֤�У�ԭ���ǻ���Ҫ��ȡʱ��Ƭ�ſ��ԣ���ʵ�ϻ���
			����ʹ���̶߳���ԭ��Runnable״̬
 */
public class TestNotifyAll {
	public static void main(String[] args) {
		Object obj = new Object();
		Thread[] ts = new Thread[10];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new Thread() {
				@Override
				public void run() {
					synchronized (obj) {
						System.out.println(getId());
						try {
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(getId());
					}}};
			ts[i].start();
		}

		// ��ƻ����߳�
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj) {
					System.out.println("��Ҫ��ʼ�������е��̣߳�����ǰ�����ܣ�����");
					// �����ڸö���������ȴ������е��߳�
					obj.notifyAll();
				}
			}
		}.start();
	}
}
