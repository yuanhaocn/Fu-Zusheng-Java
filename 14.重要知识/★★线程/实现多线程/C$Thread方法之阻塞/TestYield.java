package C$Thread方法之阻塞;

/**
 * 静态yield方法,“礼让”自己的线程
 */
public class TestYield extends Thread {
	public static void main(String[] args) {
		TestYield Demo = new TestYield();
		Thread t = new Thread(Demo);//新生
		t.start();//就绪
		//CPU调度
		
		for (int i = 0; i < 100; i++) {
			if(i%20==0) {
//暂停本线程main,写在谁的线程体里面就暂停谁，是不是真的暂停了，就要看CPU调度了，程序本身是没办法
//管到CPU调度的，没有严格意义的暂停，Thread.yield(时间);
				Thread.yield();
			}
			System.out.println("main..."+i);
		} 
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("yield..."+i);
		}
	}

}
