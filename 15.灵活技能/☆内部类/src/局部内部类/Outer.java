package 局部内部类;

/**
 * 局部内部类 位于方法内部定义，和局部变量平级
 * 
 * @author FZS
 *
 */
public class Outer {
	private String name = "阿兰.图灵";

	// 方法
	//返回值类型是上转型对象类型
	public InnerHelp getInnerObject() {
		// 定义局部内部类
		class Inner implements InnerHelp {
			// 内部类自己的属性
			private int age = 12;
			// 内部类自己的方法
			public void show() {
				System.out.println(name + "今年" + age + "岁了。。。");
			}
		}
		// 返回Inner對象
		return new Inner();
	}

}
