package ��̬�ڲ���;
/**
 * ��̬�ڲ����Ϊ��̬��Ա�ڲ��࣬�ͳ�Ա�ڲ���
 * @author FZS
 *
 */
public class Outer {
	private static String name="����Ӣ";
	
	//��̬�ڲ���
	static class Inner{
		private int age= 76;
		public void  show() {
			System.out.println(name+"����"+age+"���ˡ���");
		}
	}
	
	
}
