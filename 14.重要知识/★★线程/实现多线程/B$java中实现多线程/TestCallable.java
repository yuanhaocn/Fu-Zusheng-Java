package B$java中实现多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java中实现多线程（三）
 * 
 * 
 * 通过Callable（回调函数）接口实现多线程
 *
 * 优点：可以获得返回值
 * 
 * Callable与Future接口
 * Callable是类似与Runnable的接口，实现Callable接口的类和实现Runnable的类都是可以被其它线程执行的任务
 * Callable和Runable的不同点：
 	* 	 (1)Callable规定的方法是call() 而Runnable规定的方法是run();
 	* 	 (2) call()方法可能抛出异常，而run()方法是不抛异常的
 	* 	 (3)Callable的任务执行后可返回值，运行Callable任务可拿到一个Future对象，以等待计算的完成，并检验计算的结构
 * Future表示异步计算的结果，它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果
 * 通过Future对象可了解任务执行的情况，可取消任务的执行，还可获得任务执行的结果
 * 
 * 缺点：繁琐
 * 
 * 思路：
 	* 		1)创建Callable实现类+重写call方法
 	* 		2)借助执行调度服务ExceptorService，获得Future对象
 	* 			ExecutorService ser = Executors.newFixedThreadPool(2);
 	* 			Future result = ser.submit(实现类对象);
 	*		3)获得值result.get()
 	*		4)停止服务ser.shutdownNow();
 */
public class TestCallable implements Callable<Integer>{
	//加一个延迟
	private String name;		//名称
	private int time;		//延时的时间（比如网上购物，总要等几秒），这里表示乌龟和兔子的运动间隔
	private boolean flag =true;
	private int step=0;	//龟兔赛跑里面的第几步
	@Override
	public Integer call() throws Exception {//《《--线程体
		while(flag) {
			Thread.sleep(time);//延时--》走的多慢多块
			step++;
		}
		return  step;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程
		ExecutorService ser = Executors.newFixedThreadPool(2);
		TestCallable tortoise= new TestCallable("千年王八",1000);
		TestCallable rabbit= new TestCallable("小兔子",500);
		//获得值
		Future<Integer> result1 = ser.submit(tortoise);
		Future<Integer> result2 = ser.submit(rabbit);
		
		Thread.sleep(5000); //两秒之后就停下来,停止线程体的循环
		tortoise.setFlag(false);
		rabbit.setFlag(false);
		
		int num1 =result1.get();
		int num2 =result2.get();
		System.out.println("乌龟跑了--》"+num1+"步");
		System.out.println("兔子跑了--》"+num2+"步");
		//停止服务ser.shutdownNow();
		ser.shutdownNow();
		
	}
	
//#################################################################################################################################################	
//####################下面没了，不用看##################################################################################################################################################
//#################################################################################################################################################	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public TestCallable() {
		super();
	}

	public TestCallable(String name, int time) {
		super();
		this.name = name;
		this.time = time;
	}
	public TestCallable(String name, int time, boolean flag, int step) {
		super();
		this.name = name;
		this.time = time;
		this.flag = flag;
		this.step = step;
	}



	

}
