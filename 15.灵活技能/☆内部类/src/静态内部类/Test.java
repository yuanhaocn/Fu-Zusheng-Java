package 静态内部类;

import 静态内部类.Outer.Inner;

public class Test {

	public static void main(String[] args) {
		//Outer outer = new Outer(); 沒必要這麽寫
		Inner inner = new Outer.Inner();
		inner.show();
	}

}
