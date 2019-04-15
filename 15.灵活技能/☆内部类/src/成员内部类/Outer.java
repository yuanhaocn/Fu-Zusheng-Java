package 成员内部类;

public class Outer {
	private String name="张三";
	public Outer() {
		super();
	}
	// 定义内部类
	class Inner {
		private int age=12;
		public Inner() {
			super();
		}
		public void show() {
			//可以访问外部类的私有属性，不需要通过访问器
			System.out.println(name+"今年"+age+"岁");
		}
	}
}
