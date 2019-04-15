package 局部内部类;

public class Test {

	public static void main(String[] args) {
		Outer outer = new Outer();
		InnerHelp inner = outer.getInnerObject();//此时Inner是上转型对象
		inner.show();
	}

}
