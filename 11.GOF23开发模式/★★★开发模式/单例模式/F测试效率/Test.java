package F测试效率;
import java.util.concurrent.CountDownLatch;

import A单例模式.*;
import B线程安全的单例模式.*;
import C枚举单例模式.*;

/**
 * 测试5中创建单例模式的效率（多线程大并发）
 * 多线程测试环境CountDownLatch的使用---》多线程测试经常用到
 * 	同步辅导类，在完成一组正在其他线程中执行的操作之前，它允许一个或者多个线程一直等待
 * 	countDown()当前线程调用这个方法，则计数减一
 * await()调用此方法会一直阻塞当前线程，知道计时器的值为0
 * 
 * 饿汉式：A单例模式.CEO
 * 懒汉式：A单例模式.CEO2
 * 静态内部类式：B线程安全的单例模式.MyJvm3
 * 枚举式：C枚举单例模式.SingletonDemo
 * 双重检查锁式：B线程安全的单例模式.SingletonDemo03
 */

public class Test{
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		int threadNum=10;//线程数--》即使下面循环造出来的线程数
	 final	CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		
		for (int j = 0; j < 10; j++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						CEO o = CEO.getInstance();//---->>>这个可以更改，就可以检测所有了
					}
					//此时此线程已经结束了，计数器减一
					countDownLatch.countDown();
				}
			}).start();
		}
		
		/*这个时候时间是不准确的，因为main线程和自己定义的这些匿名内部类的线程是齐头并进的，
		 * 所以有可能其他线程还没结束，main线程就已经执行到这一句了，所以计算耗时的这句要等待
		 *等待上面的10个线程都执行完了，我们才开始计算耗时的执行，我们要构建辅助线程
		 *CountDownLatch就相当与计数器，有多少个线程就是赋值为几，线程结束的地方调用.countDown()方法，计数器就减一，
		 */		
		countDownLatch.await();//main线程阻塞，只到计数器变为0，才会继续往下执行
		long end = System.currentTimeMillis();
		System.out.println("总耗时"+(end-start));
	}
}





