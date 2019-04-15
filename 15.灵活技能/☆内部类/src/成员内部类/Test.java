package 成员内部类;

import 成员内部类.Outer.Inner;

/**
 * 创建对象
 * 
 * @author FZS
 *
 */
public class Test {
	public static void main(String[] args) {
		Outer outer = new Outer();				//1，构建外部类对象
		Outer.Inner inner = outer.new Inner();	//2，使用外部类对象构建内部类对象
		inner.show();							//3.调用
		
//**********************************************************
		//*这个方法导包
		Inner inner2 = outer.new Inner();
		//Outer.Inner inner = new Outer().new Inner();
//**********************************************************
		
	}
}
