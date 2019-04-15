package A$线程的同步￥并发;
/**
 * Runnable实现并发
 * 同步（并发）：多个线程访问同一份资源，确保资源安全--》线程安全
 * 
 ************************************
 *资源不安全实例：						*
 * 黄牛乙（线程名称）强到了0				*
 *路人甲（线程名称）强到了-1				*
 ************************************
 * synchronized->同步（锁）
 * 使用 ：
 * 一，同步块
 * synchronized（引用类型/this/类.class）{
 * }
 *二，同步方法
 */


public class Info {
	public static void main(String[] args) {
	 //多个进程访问同一个资源（共享资源）
		Web12306 web = new Web12306();//真实角色
		//三个代理
		Thread t1 = new Thread(web,"路人甲");//后面的这个部分只是线程的名字，一个线程三个调用
		Thread t2 = new Thread(web,"黄牛乙");
		Thread t3 = new Thread(web,"工程师");
	//	new Thread(new Web12306()).start();
		//启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}

//2）便于共享资源（50张），一个票类，有多个人抢票,这个很想static 变量，每次修改都会留下印记
class Web12306 implements Runnable{
	private int num  =50;
	private boolean flag= true;

	@Override
	public void run() {
		while (flag) {
			test6();
			
		}
	}
	
	//线程不安全的
	public void test1() {

		if (num<=0) {
			flag=false;
		}
		try {
			Thread.sleep(500);	//这一句就导致了线程  不安全，再一个线程sleep时候另一个线程过来访问，更改数据
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
System.out.println(Thread.currentThread().getName() +"（线程名称）强到了"+num--);


	}
	
	//线程安全 锁定正确
	//相当与t1,t2,t3来访问，但是每次只给一个线程同时访问，没结束另一个线程就没法访问，直至真在访问的线程结束，其他的
	//线程才能来访问
	public synchronized void test2() {

		if (num<=0) {
			flag=false;
			return;
		}
		try {
			//模拟延迟
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
System.out.println(Thread.currentThread().getName() +"（线程名称）强到了"+num--);


	}
	
	
	//同步块
	//线程安全 锁定正确
	public  void test3() {
		synchronized(this) {//锁定this-->也就是那个资源（票）
				if (num<=0) {
			flag=false;
			return;
		}
		try {
			//模拟延迟
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +"（线程名称）强到了"+num--);
		}
	}

	//同步块
	//锁定一部分，这就是线程的难点之锁定范围过小
	/*
	 * 线程不安全，锁定资源不正确
	 * 路人甲（线程名称）强到了0
	 *黄牛乙（线程名称）强到了0
	 */
	public  void test4() {
		synchronized(this) {//锁定this-->也就是那个资源（票）
				if (num<=0) {
			flag=false;
			return;
		}

		}
				try {
			//模拟延迟
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +"（线程名称）强到了"+num--);

	}
	
	
	/*线程不安全，锁定资源不正确
	 * 路人甲（线程名称）强到了30
	 * 工程师（线程名称）强到了30
	 * 工程师（线程名称）强到了19
	 * 路人甲（线程名称）强到了19
	 * 黄牛乙（线程名称）强到了3
	 * 工程师（线程名称）强到了3
	 */
	public  void test5() {
		synchronized((Integer)num) {	//锁定number
				if (num<=0) {
			flag=false;
			return;
		}
				try {
			//模拟延迟
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +"（线程名称）强到了"+num--);

	}
	}
	/*
	 * 线程不安全，锁定资源不正确
	 ********************************
	 * 工程师（线程名称）强到了0		*
	 * 黄牛乙（线程名称）强到了-1		*
	 * ******************************
	 * 写代码安不安全的难点就在这里，
	 * 安不安全，锁多少，锁什么	
	 * 锁的过大，会导致效率低下，不能过小，过小锁定不正确
	 * 
	 */
	public  void test6() {
		
				if (num<=0) {
			flag=false;
			return;
		}
		synchronized(this) {//锁定this-->也就是那个资源（票）		
		try {
			//模拟延迟
			Thread.sleep(500);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +"（线程名称）强到了"+num--);
		}
	}
}