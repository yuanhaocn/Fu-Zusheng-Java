package F$线程休眠与唤醒;
/**
  notifyAll()的使用
  关于wait和notify和notifyAll三个方法
	共同点：
		1）都需要在synchronized代码块里面执行，否则抛出异常
		2）都是Object的方法，所以所有的线程锁对象都可以使用
		3）都需要先获得这把锁才可以执行
		
	区别：
		1）wait方法是使得当前线程对象处于等待状态，并且主动释放对象锁
			并且无法再次获得该锁
		2）notify和notifyAll是使得在该锁上处于等待状态的线程恢复活性	
			但是不保证执行，原因是还需要获取时间片才可以，事实上唤醒
			操作使得线程对象还原到Runnable状态
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

		// 设计唤醒线程
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj) {
					System.out.println("我要开始唤醒所有的线程！！！前方高能！！！");
					// 唤醒在该对象上陷入等待的所有的线程
					obj.notifyAll();
				}
			}
		}.start();
	}
}
