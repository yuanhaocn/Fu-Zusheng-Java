package �����ڲ���;
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
				System.out.println("����һ�������ڲ���");
			}
			
		};
		//��������
		inner.show();
	}
}
