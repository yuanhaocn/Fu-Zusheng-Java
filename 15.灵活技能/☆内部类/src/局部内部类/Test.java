package �ֲ��ڲ���;

public class Test {

	public static void main(String[] args) {
		Outer outer = new Outer();
		InnerHelp inner = outer.getInnerObject();//��ʱInner����ת�Ͷ���
		inner.show();
	}

}
