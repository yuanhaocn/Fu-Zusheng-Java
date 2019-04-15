package B线程安全的单例模式;
/**
 * 单利创建的几种模式
 * 1.懒汉式(延迟加载，懒加载)	---》创建一个对象代价很高时用之
	 *a.构造器私有化，避免外部直接创建对象
	 *b.申明一个私有的静态变量
	 *c.创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
 *
 */
public class MyJvm {
	private static MyJvm instance;//类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）
	private MyJvm() {}
	
	public static MyJvm getInstance() {
		if(null==instance) {
			synchronized (MyJvm.class) {
				/* 安全，这才是多线程的难点所在，
				 * 就是你不知道在什么地方锁安全有能最大化效率
				 */
				if(null==instance) {
					instance =new MyJvm();
				}
			}
		}
		return instance;
	}
}

/**
 * 2.饿汉式---》类的调用频率很多，用之
 * 
 * 	 *a.构造器私有化，避免外部直接创建对象
	 *b.申明一个私有的静态变量，同时创建该对象
	 *c.创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	 *
 *这个是安全的，因为类加载时创建对象
 */

 class MyJvm2 {
	 /*
	  * 类初始化，立即加载这个对象（没有延时加载的优势）。加载类时，天然的是线程安全的
	  
	      优化：
	   		不使用public static MyJvm2 getInstance() {}这个方法，属性也会被初始化
	  */
	private static MyJvm2 instance=new MyJvm2();//饿了就要吃东西嘛，所以直接就创建一个对象
	private MyJvm2() {}
	
	//方法没有同步锁 ，调用效率高
	public static MyJvm2 getInstance() {
		return instance;
	}
}
 

 /*
  * *****************************************
  * *为了解决饿汉式的效率问题，我们改进，把它放进内部类中*
  * *****************************************
  * 优点：
  *		线程安全+调用效率高+要有懒加载
  *
  *类在使用的时候加载（），此方法延缓了加载时间
  *比如，我加载了MyJvm3但是不一定加载JVMholder这个内部类
  *用到的时候再去加载，，只要我不用到public static MyJvm3 getInstance（）{}
  *这个方法，这个内部类就永远不会加载
  *
  *属性一定会被初始化，方法是在调用的时候才会使用：
  *就比如说，你使用MyJvm3这个类，那么他的属性就一定会被初始化
  *但是他的方法只有在调用的时候才会使用
  */
 class MyJvm3 {
	 private static class JVMholder{
		 private static  MyJvm3 instance=new MyJvm3(); //final加不加都可以
	 }
	 private MyJvm3() {}
	 
	 public static MyJvm3 getInstance() {
		 return JVMholder.instance;
	 }
}