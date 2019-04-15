package 匿名内部类;
/**
 * 
 * @author FZS
 *
 */
public class Test {
	public static void main(String[] args) {
		InnerHelp inner= new InnerHelp() {

			@Override
			public void show() {
				System.out.println("这是一个匿名内部类");
			}
			
		};
		//方法调用
		inner.show();
	}
}
