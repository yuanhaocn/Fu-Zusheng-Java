package E$�̵߳Ļ�����Ϣ;
/**
 * isAlive()�ж��߳��Ƿ񻹻��ţ����߳��Ƿ�δ��ֹ
 * getPrioroty()����̵߳����ȼ���ֵ��������ȼ��Ǹ��ʵ���˼�����Ǿ��Ե����ȼ���
 * setPriority()�����̵߳����ȼ���ֵ
 * setName()���߳�һ������
 * getName()ȡ���̵߳�����
 * Thread.currentThread()ȡ�õ�ǰ�������е��̶߳���Ҳ����ȡ���Լ�����
 *
 */
public class Info implements Runnable{
	private boolean flag=true;
	private int num=0;
	@Override
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName()+"-->"+num++);
		}
		
	}
	public void stop() {
		this.flag=!this.flag;
	}

	public static void main(String[] args) throws InterruptedException {
		Info info = new Info();
		Thread proxy = new Thread(info,"TI");//�ù�����ȡ������
		proxy.setName("IT");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());
		proxy.start();
		
		System.out.println("�������״̬"+proxy.isAlive());
		
		//��һ����ֹ����
		Thread.sleep(20);
		info.stop();
		
		System.out.println("�رպ��״̬"+proxy.isAlive());

	}
}
