package B线程安全的单例模式;

public class SynDemo {
	public static void main(String[] args) {
		JvmThread thread1 = new JvmThread(100);
		JvmThread thread2 = new JvmThread(500);
		thread1.start();
		thread2.start();
	}
}

class JvmThread extends Thread{
	private long time;
	
	public JvmThread() {}
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName()+"-->创建对象"+Jvm.getInstance(time));
	}
}
	/**
	 *单例设计模式
	 *确保一个类只有一个对象
	 *懒汉式 
	 *1.构造器私有化，避免外部直接创建对象
	 *2.申明一个私有的静态变量
	 *3.创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	 *
	 */
class Jvm{
	//2.申明一个私有的静态变量
	private static Jvm instance = null;//懒汉式就是这个地方懒得创建对象，使用的时候再创建
	//1.构造器私有化，避免外部直接创建对象
	private Jvm() {
	}
	
	//3.创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	public static  Jvm getInstance1(long time) {
		if(null == instance) {
			try {
				/*为了增加单例模式的出现错误的概率
				 * 以说明这种单例模式不一定只能产生一个对象，进而引入线程安全的单例模式 
				 * 
				 */
				Thread.sleep(time);//
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance =new Jvm();
			}
		return instance;
		}
	
	
	/*
	 * 简单改进型1，直接加上synchronized在方法头上,方便省事效率低
	 */
	public static synchronized Jvm getInstance2(long time) {
		if(null == instance) {
			try {
				/*为了增加单例模式的出现错误的概率
				 * 以说明这种单例模式不一定只能产生一个对象，进而引入线程安全的单例模式 
				 * 
				 */
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance =new Jvm();
			}
		return instance;
		}
	/*
	 * 该进2，锁的地方
	 */
	public static  Jvm getInstance3(long time) {
		/*
		 * a  b  c  d  e--》此效率不高，因为即使存在对象也需要等待
		 */
		
		
		/*
		 * 双重检查的意义，以及如何锁定静态信息
		 */
		synchronized(Jvm.class){//这就不能锁this 了，因为还没有对象，要锁它的字节码信息
		if(null == instance) {
			try {
			 
				Thread.sleep(time);//
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance =new Jvm();
			}
		return instance;
		}
	
	}
	
	/*
	 * 该进3，锁的地方
	 * ************************
	 * 双重检查（double checking）*
	 * ************************
	 * 
	 * jvm内部还是对象，只不过这些对象放在类加载器里面（class load）
	 * synchronized(Jvm.class){}这一句把模子锁定了，其他人只能在外面等，等它完成
	 * (问题：
	 * 	由于编译器优化原因和JVM底层内部模型原因，偶尔会出问题，不建议使用)
	 * 
	 */
	public static  Jvm getInstance4(long time) {
		//c  d  e---》两个一样的if判断是为了提高效率，提高已经存在对象的访问效率
		if(null == instance) {
			synchronized(Jvm.class){ 
		if(null == instance) {
			try {
				Thread.sleep(time);
				
} catch (InterruptedException e) {e.printStackTrace();}
			instance =new Jvm();}}}
		return instance;
	}
}
/*
 * 改进4
 * 双重检查（double checking）
 */
 class SingletonDemo03 {
	 private static SingletonDemo03 instance = null;
	 public static SingletonDemo03 getInstance() {
		 if (instance == null) {
			 SingletonDemo03 sc;
			 synchronized (SingletonDemo03.class) {
				 sc = instance;
				 if (sc == null) {
					 synchronized (SingletonDemo03.class) {
						 if(sc == null) {
							 sc = new SingletonDemo03();
						 }
					 }
					 instance = sc;
				 }
			 }
		 }
		 return instance;
	 }
	 private SingletonDemo03() {
	 }
}
