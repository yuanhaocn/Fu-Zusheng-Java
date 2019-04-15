package B$java中实现多线程;
/**
 *  java中实现线程（一）
 * 
 * 模拟龟兔赛跑
 * 1，创建多线程，继承Thread+重写run(成为线程体，一切从run开始	)
 * 2.使用线程：创建子类对象 +调用对象.start()方法
 *
 */

public class TestThread{
		/*
		 * 线程数（粗略） main + rab + tor+gc()+异常
		 * 一般来说是从上往下依逻辑顺序执行
		 * 但是这个却是你执行一点，我执行一点
		 */
		public static void main(String[] args) {//  《---也是一个线程
			//2.使用线程：创建子类对象 ,只是创建对象，不过是线程类的对象
			Rabbit rab = new Rabbit();
			Tortoise tor = new Tortoise();
		
			
			//调用对象.start()方法
//只是加载到线程组里面等待CPU调用，这步叫做启动线程（不等于线程运行），不要调用run()方法程序内部调用run方法
			rab.start();
			tor.start();
			/*
			 * rab.run();
			 * tor.run();	
//这样会导致从上往下的正常逻辑顺序，这就是一条路径了，，想要多条路径，就要调用start方法，加载到线程池，由CPU把控
			*/
			for (int i = 0; i <100; i++) {
				System.out.println("main===>"+i);
			}
		}
}



 class Rabbit extends Thread{
	@Override
	public void run() {
		//线程体
		for (int i = 0; i < 100; i++) {
			System.out.println("兔子跑了"+i+"步");
		}
	}

}


class Tortoise extends Thread{
	@Override
	public void run() {//线程体
		for (int i = 0; i < 100; i++) {
			System.out.println("乌龟跑了"+i+"步");
		}
	}
	
}