package B$java中实现多线程;
/**
 *  java中实现线程（二）
 * 
 * 推荐使用Runnable创建创建线程
 	* 	1）避免单继承的局限性（代理角色我们不需要自己创建（Thread））
 	* 	2）便于共享资源
 *
 * 继承Thread类方法的缺点（Rabbit.java）， 那就是如果我们的类已经从一个类继承
 * （如小程序必须继承自Applet类），则无法再继承Thread类
 * 通过Runnable接口实现多线程（实际上是实现了一种模式：静态代理）
 * 优点：可以同时实现继承，实现Runnable接口方式要通过一些
 	* 	1）避免单继承
 	* 	2）方便共享资源 ，同一份资源，多个代理访问
 * 
 * 使用Runna创建线程
 	* 	1）类实现runnable +重写run()方法--》真实角色类
 	* 	2)启动多线程，使用静态代理
 	* 		a.创建真实角色
 	* 		b.创建代理角色+真实角色的引用
 	* 		c.调用.start()方法启动线程
 */
public class TestRunnable implements Runnable	{

	@Override//线程体
	public void run() {
		for (int i = 0; i < 100; i++) {			
			System.out.println("一边敲hello world");
		}
	}
	
	//应用
	public static void main(String[] args) {
//a.创建真实角色
		TestRunnable pro= new TestRunnable();
//b.创建代理角色+真实角色的引用
		Thread proxy = new Thread(pro);
//c.调用.start()方法启动线程
		proxy.start();							//《《---一条线程
		
		for (int i = 0; i < 100; i++) {			//《《----一条线程
			System.out.println("一边聊天");
		}
		
//################################################################################################################
		//2）便于共享资源，一个票类，有多个人抢票，必须只创建一个对象，提供给所有的线程使用
		Web12306 web = new Web12306();//真实角色
		//三个代理
		Thread t1 = new Thread(web,"路人甲");//后面的这个部分只是线程的名字，一个线程三个调用
		Thread t2 = new Thread(web,"黄牛乙");
		Thread t3 = new Thread(web,"工程师");
		//启动线程
		t1.start();
		t2.start();
		t3.start();
		
	
	}

}


//	2）便于共享资源（50张），一个票类，有多个人抢票,这个很想static 变量，每次修改都会留下印记
class Web12306 implements Runnable{
	private int num  =50;
	@Override
	public void run() {
		while (true) {		//死循环
			if (num<=0) {
				break ;//跳出循环
			}
			System.out.println(Thread.currentThread().getName() +"（线程名称）抢到了"+num--);
		}
	}
	
}
