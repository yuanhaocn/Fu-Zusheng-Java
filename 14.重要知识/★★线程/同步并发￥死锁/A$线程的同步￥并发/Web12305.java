package A$�̵߳�ͬ��������;
/**
 * Threadʵ�ֲ���
 */
public class Web12305  {
	private   int ticket = 1000;
	class ThreadA extends Thread{
		@Override
		public void run() {
			while(ticket>0) {
				ticket-=10;
				System.out.println("fzsȡ��10��Ʊ����ʣ"+ticket+"��Ʊ");
			}}}
	class ThreadB extends Thread{
		@Override
		public void run() {
			while(ticket>0) {
				ticket-=10;
				System.out.println("lzyȡ��10��Ʊ����ʣ"+ticket+"��Ʊ");
			}}}
		public static void main(String[] args) {
			 //������̷���ͬһ����Դ��������Դ��
			Web12305 web12305 = new Web12305();
			//�����ڲ�����ʵ��Runnable�Ķ��������
			Web12305.ThreadA threadA = web12305.new ThreadA();
			Web12305.ThreadB threadB = web12305.new ThreadB();
			threadA.start();
			threadB.start();
//			new Web12305().new ThreadA().start();//�ⲿ������ڲ�����Ŀ�ʼ����������
		}}