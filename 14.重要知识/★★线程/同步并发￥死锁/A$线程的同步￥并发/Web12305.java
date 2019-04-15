package A$线程的同步￥并发;
/**
 * Thread实现并发
 */
public class Web12305  {
	private   int ticket = 1000;
	class ThreadA extends Thread{
		@Override
		public void run() {
			while(ticket>0) {
				ticket-=10;
				System.out.println("fzs取了10张票，还剩"+ticket+"张票");
			}}}
	class ThreadB extends Thread{
		@Override
		public void run() {
			while(ticket>0) {
				ticket-=10;
				System.out.println("lzy取了10张票，还剩"+ticket+"张票");
			}}}
		public static void main(String[] args) {
			 //多个进程访问同一个资源（共享资源）
			Web12305 web12305 = new Web12305();
			//两个内部类以实现Runnable的多个代理功能
			Web12305.ThreadA threadA = web12305.new ThreadA();
			Web12305.ThreadB threadB = web12305.new ThreadB();
			threadA.start();
			threadB.start();
//			new Web12305().new ThreadA().start();//外部对象的内部对象的开始方法，完美
		}}