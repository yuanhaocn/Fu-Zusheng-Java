package 自定义异常;
/**
 * finally
 * 		1）finally里面的代码不管是否发生异常一定会执行通常用来收尾，比如在IO操作里面关闭流操作
		2）finally比retrun厉害，即便出现了retrun，finally代码依然可以执行
		3）finally代码永远都会执行，除非关闭jvm
 * 
 *
 */
public class Test02 {
	public static void main(String[] args) {
		double myFun = myFun();
		System.out.println(myFun);
	}

	public static double myFun() {
		try {
			double result = ByZeroException.chufa(12, 0);
			return result ;
		} catch (Throwable e) {
			return 0;
		} finally {
			System.out.println("this  is  finally code...");
		}
	}
}
