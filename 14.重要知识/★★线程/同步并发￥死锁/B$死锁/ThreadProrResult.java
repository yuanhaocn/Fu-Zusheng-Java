package B$死锁;

/**
 *使用睡眠唤醒--》然并卵
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
					System.out.println(getId() + "得到了Obj1这把锁");
					synchronized (obj2) {
						System.out.println(getId() + "得到了Obj1和obj2这两个把锁");
					obj2.notify();//唤醒线程ThreadB
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
					//初步解决
					try {
						obj2.wait();//放锁，睡眠
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
//############################	立即执行obj2.notify();//唤醒线程ThreadB	#####################################
//#############################		这样的时候又会死锁		###########################
					System.out.println(getId() + "得到了Obj2这把锁");
					synchronized (obj1) {
						System.out.println(getId() + "得到了Obj1和obj2这两个把锁");
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
