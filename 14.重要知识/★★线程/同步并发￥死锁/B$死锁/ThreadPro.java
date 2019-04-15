package B$死锁;

/**
 * * 死锁的四个条件 
 	* 请求保持---我不会轻易放弃的，灰太狼 
 	* 请求互斥---资源的拥有方本身是矛盾的 
 	* 不可剥夺---不能强行剥夺其他的线程的资源
 	* 形成环路---资源本身是唯一的，不可复制 
 * 握着苹果要吃梨子&握着梨子要吃苹果
 *死锁的解决
 *	死锁无法解决，只能避免
 *	思路：
 	*	1)把进行赋值多份，降低可能性（最简单）
 	*	2)寻找可替代解决方案，打破环路
 	*	3)延时加载，使用完毕之后把资源让出来(常用的决解方案)
 	*	4)
 	*本质：只要打破四个条件中任何一个，死锁都可以避免
 */
public class ThreadPro {
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
					System.out.println(getId() + "得到了Obj2这把锁");
					synchronized (obj1) {
						System.out.println(getId() + "得到了Obj1和obj2这两个把锁");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new ThreadPro().new ThreadA().start();
		new ThreadPro().new ThreadB().start();
	}
}
