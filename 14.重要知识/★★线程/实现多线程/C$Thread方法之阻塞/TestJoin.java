package C$Thread方法之阻塞;
/**
 * 线程阻塞
 * join:合并线程是Thread中的方法，用法：对象.join() 把对象的线程加进来，
 * 所在位置的线程遭到阻塞，并且要等待对象线程运行结束
 * 大白话：就是在一个线程里面join另一个线程，就是用法不是静态的
 */
public class TestJoin extends Thread {
	public static void main(String[] args) throws InterruptedException {
		TestJoin Demo = new TestJoin();
		Thread t = new Thread(Demo);//新生
		t.start();//就绪
//###############################################################			
//##################一步到位#######################################	
		new Thread(new TestJoin()).start();		           	//###
//###############################################################			
//###############################################################			
		
		//CPU调度
		for (int i = 0; i < 100; i++) {
			if(50==i) {
				//main阻塞
	//遇到这里就要等待run()全部运行完才行，如果没有这一部分就是双线程，你运行一部分，我也运行一部分
			t.join();
			}
			System.out.println("main..."+i);
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("join..."+i);
		}
	}
}
