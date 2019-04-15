package A$�̵߳�ͬ��������;
/**
 * Runnableʵ�ֲ���
 * ͬ����������������̷߳���ͬһ����Դ��ȷ����Դ��ȫ--���̰߳�ȫ
 * 
 ************************************
 *��Դ����ȫʵ����						*
 * ��ţ�ң��߳����ƣ�ǿ����0				*
 *·�˼ף��߳����ƣ�ǿ����-1				*
 ************************************
 * synchronized->ͬ��������
 * ʹ�� ��
 * һ��ͬ����
 * synchronized����������/this/��.class��{
 * }
 *����ͬ������
 */


public class Info {
	public static void main(String[] args) {
	 //������̷���ͬһ����Դ��������Դ��
		Web12306 web = new Web12306();//��ʵ��ɫ
		//��������
		Thread t1 = new Thread(web,"·�˼�");//������������ֻ���̵߳����֣�һ���߳���������
		Thread t2 = new Thread(web,"��ţ��");
		Thread t3 = new Thread(web,"����ʦ");
	//	new Thread(new Web12306()).start();
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
	}
}

//2�����ڹ�����Դ��50�ţ���һ��Ʊ�࣬�ж������Ʊ,�������static ������ÿ���޸Ķ�������ӡ��
class Web12306 implements Runnable{
	private int num  =50;
	private boolean flag= true;

	@Override
	public void run() {
		while (flag) {
			test6();
			
		}
	}
	
	//�̲߳���ȫ��
	public void test1() {

		if (num<=0) {
			flag=false;
		}
		try {
			Thread.sleep(500);	//��һ��͵������߳�  ����ȫ����һ���߳�sleepʱ����һ���̹߳������ʣ���������
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
System.out.println(Thread.currentThread().getName() +"���߳����ƣ�ǿ����"+num--);


	}
	
	//�̰߳�ȫ ������ȷ
	//�൱��t1,t2,t3�����ʣ�����ÿ��ֻ��һ���߳�ͬʱ���ʣ�û������һ���߳̾�û�����ʣ�ֱ�����ڷ��ʵ��߳̽�����������
	//�̲߳���������
	public synchronized void test2() {

		if (num<=0) {
			flag=false;
			return;
		}
		try {
			//ģ���ӳ�
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
System.out.println(Thread.currentThread().getName() +"���߳����ƣ�ǿ����"+num--);


	}
	
	
	//ͬ����
	//�̰߳�ȫ ������ȷ
	public  void test3() {
		synchronized(this) {//����this-->Ҳ�����Ǹ���Դ��Ʊ��
				if (num<=0) {
			flag=false;
			return;
		}
		try {
			//ģ���ӳ�
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +"���߳����ƣ�ǿ����"+num--);
		}
	}

	//ͬ����
	//����һ���֣�������̵߳��ѵ�֮������Χ��С
	/*
	 * �̲߳���ȫ��������Դ����ȷ
	 * ·�˼ף��߳����ƣ�ǿ����0
	 *��ţ�ң��߳����ƣ�ǿ����0
	 */
	public  void test4() {
		synchronized(this) {//����this-->Ҳ�����Ǹ���Դ��Ʊ��
				if (num<=0) {
			flag=false;
			return;
		}

		}
				try {
			//ģ���ӳ�
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +"���߳����ƣ�ǿ����"+num--);

	}
	
	
	/*�̲߳���ȫ��������Դ����ȷ
	 * ·�˼ף��߳����ƣ�ǿ����30
	 * ����ʦ���߳����ƣ�ǿ����30
	 * ����ʦ���߳����ƣ�ǿ����19
	 * ·�˼ף��߳����ƣ�ǿ����19
	 * ��ţ�ң��߳����ƣ�ǿ����3
	 * ����ʦ���߳����ƣ�ǿ����3
	 */
	public  void test5() {
		synchronized((Integer)num) {	//����number
				if (num<=0) {
			flag=false;
			return;
		}
				try {
			//ģ���ӳ�
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +"���߳����ƣ�ǿ����"+num--);

	}
	}
	/*
	 * �̲߳���ȫ��������Դ����ȷ
	 ********************************
	 * ����ʦ���߳����ƣ�ǿ����0		*
	 * ��ţ�ң��߳����ƣ�ǿ����-1		*
	 * ******************************
	 * д���밲����ȫ���ѵ�������
	 * ������ȫ�������٣���ʲô	
	 * ���Ĺ��󣬻ᵼ��Ч�ʵ��£����ܹ�С����С��������ȷ
	 * 
	 */
	public  void test6() {
		
				if (num<=0) {
			flag=false;
			return;
		}
		synchronized(this) {//����this-->Ҳ�����Ǹ���Դ��Ʊ��		
		try {
			//ģ���ӳ�
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +"���߳����ƣ�ǿ����"+num--);
		}
	}
}