package 开发模式;
/**
 * 重点：一个场景,共同的资源
 * 生产者消费者模式，信号灯法
 	*	1).wait()等待，会释放锁（sleep不释放锁）
 	*	2).notify/notifyAll唤醒
 	*	3).与synchronized共同使用
 */
public class Movie {
	private String pic;//播放的东西
	/*
	 * 信号灯
	 * flag-->true时 生产者生产，消费者等待,生产完成后通知消费
	 * flag-->false时 消费者消费，生产者等待，消费完成后 通知生产
	 */
	private boolean flag=true;
	
	
	public synchronized  void play(String pic) {
		if(!flag) {//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产了->"+pic);
		//生产完毕
		this.pic=pic;
		//通知消费
		this.notify();
		//生产者要停下
		this.flag=false;
	}
	public synchronized void watch() {
		if(flag) {//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费了--》"+pic);
		//消费完毕
		//通知生产
		this.notify();
		//消费停止
		this.flag=true;
		
	}
	public static void main(String[] args) {
		//共同的资源
		Movie m = new Movie();
		//多线程
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		//代理，开启线程
		new Thread(p).start();
		new Thread(w).start();
		
	}
}


/* 生产者*/
class Player implements Runnable {
	private Movie m;
	
	public Player(Movie m) {super();this.m = m;}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(0==i%2) {
				m.play("左青龙");
			}else {
				m.play("右白虎");
			}
		}
	}

}
/*消费者 */
class Watcher implements Runnable {
	private Movie m;
	
	public Watcher(Movie m) {super();this.m = m;}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			m.watch();
		}
	}

}

