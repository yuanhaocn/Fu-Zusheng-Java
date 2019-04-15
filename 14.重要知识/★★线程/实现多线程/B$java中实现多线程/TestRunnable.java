package B$java��ʵ�ֶ��߳�;
/**
 *  java��ʵ���̣߳�����
 * 
 * �Ƽ�ʹ��Runnable���������߳�
 	* 	1�����ⵥ�̳еľ����ԣ������ɫ���ǲ���Ҫ�Լ�������Thread����
 	* 	2�����ڹ�����Դ
 *
 * �̳�Thread�෽����ȱ�㣨Rabbit.java���� �Ǿ���������ǵ����Ѿ���һ����̳�
 * ����С�������̳���Applet�ࣩ�����޷��ټ̳�Thread��
 * ͨ��Runnable�ӿ�ʵ�ֶ��̣߳�ʵ������ʵ����һ��ģʽ����̬����
 * �ŵ㣺����ͬʱʵ�ּ̳У�ʵ��Runnable�ӿڷ�ʽҪͨ��һЩ
 	* 	1�����ⵥ�̳�
 	* 	2�����㹲����Դ ��ͬһ����Դ������������
 * 
 * ʹ��Runna�����߳�
 	* 	1����ʵ��runnable +��дrun()����--����ʵ��ɫ��
 	* 	2)�������̣߳�ʹ�þ�̬����
 	* 		a.������ʵ��ɫ
 	* 		b.���������ɫ+��ʵ��ɫ������
 	* 		c.����.start()���������߳�
 */
public class TestRunnable implements Runnable	{

	@Override//�߳���
	public void run() {
		for (int i = 0; i < 100; i++) {			
			System.out.println("һ����hello world");
		}
	}
	
	//Ӧ��
	public static void main(String[] args) {
//a.������ʵ��ɫ
		TestRunnable pro= new TestRunnable();
//b.���������ɫ+��ʵ��ɫ������
		Thread proxy = new Thread(pro);
//c.����.start()���������߳�
		proxy.start();							//����---һ���߳�
		
		for (int i = 0; i < 100; i++) {			//����----һ���߳�
			System.out.println("һ������");
		}
		
//################################################################################################################
		//2�����ڹ�����Դ��һ��Ʊ�࣬�ж������Ʊ������ֻ����һ�������ṩ�����е��߳�ʹ��
		Web12306 web = new Web12306();//��ʵ��ɫ
		//��������
		Thread t1 = new Thread(web,"·�˼�");//������������ֻ���̵߳����֣�һ���߳���������
		Thread t2 = new Thread(web,"��ţ��");
		Thread t3 = new Thread(web,"����ʦ");
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
		
	
	}

}


//	2�����ڹ�����Դ��50�ţ���һ��Ʊ�࣬�ж������Ʊ,�������static ������ÿ���޸Ķ�������ӡ��
class Web12306 implements Runnable{
	private int num  =50;
	@Override
	public void run() {
		while (true) {		//��ѭ��
			if (num<=0) {
				break ;//����ѭ��
			}
			System.out.println(Thread.currentThread().getName() +"���߳����ƣ�������"+num--);
		}
	}
	
}
