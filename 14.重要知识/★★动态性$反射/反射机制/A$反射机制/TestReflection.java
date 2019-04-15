package A$反射机制;
/**
 *反射机制(reflection)
 *	指的是可以于运行时加载，探知，使用编译期间完全未知的类
 *	程序在运行状态中，可以动态的加载一个只有名字的类，对于任意一个已加载的类，都能够知道这个类的所有属性和方法；对于任何一个对象，都能够调用
 *它的任意一个方法和属性
 *	Class cls=Class.forName("全类名"); //反射里面的核心代码
 *加载完类之后，在堆内存中，就产生了一个Class类型的对象(一个类只有一个Class对象)，这个对象就包含了完整的类的结构信息，
 *我们可以通过这个对象看到类的结构，这个对象就像一面镜子，透过这个镜子看到类的结构，所以我们形象的称之为：反射
 *
 *
 *反射机制的常见作用：
 *	动态加载类，动态获取类的信息(属性，方法，构造器)
 *	动态构造对象
 *	动态调用类和对象的任意方法，构造器
 *	动态调用和处理属性
 *	获取泛型信息
 *	处理注解
 * 测试java.lang.Class对象的获取方式
 * 
 * 
 *Instances of the class Class represent classes and interfaces in a running Java application. 
 *An enum is a kind of class and an annotation is a kind of interface. Every array also belongs 
 *to a class that is reflected as a Class object that is shared by all arrays with the same element 
 *type and number of dimensions. The primitive Java types (boolean, byte, char, short, int, long, 
 *float, and double), and the keyword void are also represented as Class objects. 
 */
public class TestReflection {
	public static void main(String[] args) {
		String path="A$反射机制.User";
		try {
/*
 * 对象是显示或者封装一些数据，一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息会被放到对应的Class对象中
 * 这个Class对象就像一面镜子一样，透过这面镜子我们可以看到对应类的全部信息，也就是说cls这个对象保存了User这个类的全部信息 。
  --获取Class对象第一种方法
  ----Class<?> cls = Class.forName("全类名");
 */
			Class<?> cls = Class.forName(path);
			System.out.println(cls);
			System.out.println(cls.hashCode());
			//同样的一个类只会被加载一次，一个类只有一个反射对象（cls），重复加载的哈希值将会相同，也就代表只有一个对象
			Class<?> cls2 = Class.forName(path);
			System.out.println(cls2.hashCode());
			
		/*
		 * 获取Class对象第二种方法
		 * 	类名.class
		 */
			Class cls3=String.class;
		 /*
		  * 获取Class对象第三种方法
		  * 	类名.class
		  */	
			Class cls4=path.getClass();
			System.out.println(cls3==cls4);//都是字符串，所以是同一个对象
			
			
/*
 * Jump above calculations, group the operations, classify them according to their complexities rather than their appearance;
 * this, I believe,is the mission of future mathematicians; this is the road I'm embarking in thiswork.”
 * （跳出计算，群化运算，按照它们的复杂度而不是表象来分类；我相信，这是未来数学的任务；这也正是我的工作所揭示出来的道路。）
 */
			int[] arr01=new int[10];
			int[] arr02=new int[30];
			//同样的数据类型反射所得的反射对象是同一个对象，感觉和抽象代数一样，抽象出一个模型，归纳万物
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
		} catch (Exception e) {e.printStackTrace();}
	}
}

