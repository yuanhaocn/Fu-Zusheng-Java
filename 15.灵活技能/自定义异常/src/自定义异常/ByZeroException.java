package 自定义异常;
//		1).必须继承异常类的父类Throwable，Throwbale是一个普通类
public class ByZeroException extends Throwable {
//		2).本类需要实现一个参数为String类型的有参构造,构建一个方法，进行触发运算
	public ByZeroException(String message) {
		super(message);
	}
	/*
	 * 一个方法里面可能会抛出很多异常
	 * 所以需要在方法头上使用throws抛出异常的祖先类类型 
	 * 异常和返回值一样，最后抛给方法调用者，继承和多态的应用
	 */
public static double chufa(double a,double b) throws ByZeroException,NullPointerException {
//		3).除数b进行非零判断
		if (b==0) {
			/*
			 * 出现异常了
			 * throw是抛出的含义，指的是把Throwable的子类对象从方法中抛出去
			 * 最后的message会经过本类的构造方法传给Throwable，Throwable对象会把message
			 * 传回本类对象
			 */
			throw new ByZeroException("除数不得为零!");
		}
		if(b==1) {
			throw new NullPointerException();
		}
		
		
		else {
			//不是0正常运算
			return a/b;
		}
	}
	public static void main(String[] args) {
		/*
		 * 如果调用的方法里面存在异常抛出行为，那么方法调用会划红线
		 * 处理异常方案有两个：
		 * 		1)使用try...catch...语法自动捕获该异常并处理，一般采用第一个
		 * 		2)不处理，把该异常继续往上抛出   throws Throwable
		 */
		try {
			double res = ByZeroException.chufa(12, 0);
			System.out.println(res);
		} catch (Throwable e) {
			System.out.println("hello world");
			e.printStackTrace();
		}
//************************************************************************
		try {
			ByZeroException.chufa(12, 0);
		} catch (Throwable e) {
			//直接获取简略的信息
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}
