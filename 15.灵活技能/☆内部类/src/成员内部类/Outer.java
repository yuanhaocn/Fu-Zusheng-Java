package ��Ա�ڲ���;

public class Outer {
	private String name="����";
	public Outer() {
		super();
	}
	// �����ڲ���
	class Inner {
		private int age=12;
		public Inner() {
			super();
		}
		public void show() {
			//���Է����ⲿ���˽�����ԣ�����Ҫͨ��������
			System.out.println(name+"����"+age+"��");
		}
	}
}
