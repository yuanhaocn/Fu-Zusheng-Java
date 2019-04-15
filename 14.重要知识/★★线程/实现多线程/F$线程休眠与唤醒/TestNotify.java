package F$线程休眠与唤醒;
/**
 wait方法详解
	关于使用：
		1）必须和synchronized连用否则无效
		2）必须捕获异常，无法抛出
	效果：
		使得所在的线程陷入WAITTING状态，并且手动释放锁，其他线程获得
		争夺该锁的机会，当前线程由于陷入阻塞状态，所以无法争夺该锁
		wait notify必须放在synchronized里面，否则抛异常，wait和notify必须是同一把锁，否则唤不醒
 */
public class TestNotify {
	private Object obj = new Object();//一把锁，锁住了线程，锁住了休眠与唤醒
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
	// 定义一个单独的唤醒线程																	//$$		
class NotifyThread extends Thread {														//$$			
		@Override																		//$$	
		public void run() {																//$$
			// 千万不要使用死循环，条件是a线程没有执行完毕进行唤醒									//$$
			while (a.getState() != State.TERMINATED) {									//$$	
				// 缺少synchronized														//$$		
				synchronized (obj) {													//$$
//notify方法的使用—————解除因为wait方法的线程等待状态可以唤醒一次因为obj导致的线程等待状态 				//$$
					obj.notify();														//$$	
				}}}}																	//$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	public static void main(String[] args) {
		TestNotify tp = new TestNotify();
		//内部类的两个线程
		ThreadA threadA = tp.new ThreadA();
		NotifyThread nt = tp.new NotifyThread();
		tp.a = threadA;//这个还是要注意一点，要赋值进去
		//准备就绪
		nt.start();
		threadA.start();
	}
}
