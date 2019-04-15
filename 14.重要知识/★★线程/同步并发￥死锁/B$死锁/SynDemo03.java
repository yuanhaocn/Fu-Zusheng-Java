package B$死锁;
/**
 * 过多的同步方法可能造成死锁
 * 死锁的四个条件
 	* 	请求保持---我不会轻易放弃的，灰太狼
 	* 	请求互斥---资源的拥有方本身是矛盾的
 	* 	不可剥夺---不能强行剥夺其他的线程的资源
 	* 	形成环路---资源本身是唯一的，不可复制
 */
public class SynDemo03 {
	public static void main(String[] args) {
		Object g = new Object();
		Object m = new Object();
		Test t1 = new Test(g,m);
		Test2 t2 = new Test2(g,m);
		Thread proxy=new Thread(t1);
		Thread proxy2=new Thread(t2);
		proxy.start();
		proxy2.start();
	}
}

class Test implements Runnable{
	Object goods ;
	Object money ;
	
			
	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true) {
			test();
		}
	}
	public void test() {
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (goods) {
				
			}
		}
		System.out.println("一手给货");
	}
	
}


class Test2 implements Runnable{
	Object goods ;
	Object money;
			
	
	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true) {
			test();
		}
	}
	public void test() {
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (goods) {
				
			}
		}
		System.out.println("一手给货");
	}
	
}


