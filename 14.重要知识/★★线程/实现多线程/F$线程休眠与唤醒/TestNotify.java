package F$�߳������뻽��;
/**
 wait�������
	����ʹ�ã�
		1�������synchronized���÷�����Ч
		2�����벶���쳣���޷��׳�
	Ч����
		ʹ�����ڵ��߳�����WAITTING״̬�������ֶ��ͷ����������̻߳��
		��������Ļ��ᣬ��ǰ�߳�������������״̬�������޷��������
		wait notify�������synchronized���棬�������쳣��wait��notify������ͬһ���������򻽲���
 */
public class TestNotify {
	private Object obj = new Object();//һ��������ס���̣߳���ס�������뻽��
	public ThreadA a;
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	class ThreadA extends Thread {														//$$
		@Override																		//$$
		public void run() {																//$$
			for (int i = 0; i < 10; i++) {												//$$
				synchronized (obj) {													//$$	
					System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");			//$$
					try {																//$$			
						obj.wait();														//$$				
					} catch (InterruptedException e) {									//$$
						e.printStackTrace();											//$$	
					}}}}}																//$$
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%$
	// ����һ�������Ļ����߳�																	//$$		
class NotifyThread extends Thread {														//$$			
		@Override																		//$$	
		public void run() {																//$$
			// ǧ��Ҫʹ����ѭ����������a�߳�û��ִ����Ͻ��л���									//$$
			while (a.getState() != State.TERMINATED) {									//$$	
				// ȱ��synchronized														//$$		
				synchronized (obj) {													//$$
//notify������ʹ�á��������������Ϊwait�������̵߳ȴ�״̬���Ի���һ����Ϊobj���µ��̵߳ȴ�״̬ 				//$$
					obj.notify();														//$$	
				}}}}																	//$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	public static void main(String[] args) {
		TestNotify tp = new TestNotify();
		//�ڲ���������߳�
		ThreadA threadA = tp.new ThreadA();
		NotifyThread nt = tp.new NotifyThread();
		tp.a = threadA;//�������Ҫע��һ�㣬Ҫ��ֵ��ȥ
		//׼������
		nt.start();
		threadA.start();
	}
}
