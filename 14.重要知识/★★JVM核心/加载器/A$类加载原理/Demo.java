package A$类加载原理;

public class Demo {
	static {
		System.out.println("静态初始化Demo");
	}

	public static void main(String[] args) throws Exception {
		/*System.out.println("Demo的main方法");
		A a = new A();
		System.out.println(a.width);
		A a2=new A();//类加载和初始化只有一次
		System.out.println(A.width);//主动引用，会导致A初始化
		System.out.println(A.MAX);//被动引用，不会导致A初始化
		Class<?> cls = Class.forName("JVM原理.A");//反射加载类时，也会导致初始化A
		A[] as = new A[10];//定义A数组不会初始化A
*/		System.out.println(B.width);//当访问一个java类的静态域时，只有真正声明这个域的类才会被初始化， 就是说B不会初始化，A定义了这个静态域，所以A被初始化了
		
	}

}

class B extends A{
	static {
		System.out.println("静态初始化B");
	}
}

class A extends A_Farther{
	public static int width=100;
	public static final int MAX=100;
	static {
		System.out.println("静态初始化类A");
		width=300;//HOHOHO 
	}
	public A() {
		System.out.println("创建A对象");
	}
}

class A_Farther{
	static {
		System.out.println("静态初始化A_Father");
	}
	
}



