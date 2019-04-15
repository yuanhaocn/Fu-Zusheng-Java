package 静态内部类;
/**
 * 静态内部类成为静态成员内部类，和成员内部类
 * @author FZS
 *
 */
public class Outer {
	private static String name="李莲英";
	
	//静态内部类
	static class Inner{
		private int age= 76;
		public void  show() {
			System.out.println(name+"今年"+age+"嵗了。。");
		}
	}
	
	
}
