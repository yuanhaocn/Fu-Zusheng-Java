package Final����;
/**final�Ա���
 * Java 1.1 �������ǽ��Ա������final ���ԣ����������Ա����б��ж����ǽ����ʵ���������
 * ����ζ����һ���������ڲ������ǲ��ܸı��Ա������ָ��Ķ�����
 * ������ʾ��ע���ʱ��Ȼ��Ϊfinal �Ա�������һ��null���գ������ͬʱ���������Ჶ������
 * �������ǶԷ�final �Ա�����ȡ�Ĳ�����һ���ġ�
 * ����f()��g()������չʾ���������͵��Ա���Ϊfinal ʱ�ᷢ��ʲô���������ֻ�ܶ�ȡ�Ա��������ɸı�����
 */
public class FinalArguments {
	void with(final Gizmo g) {
		// ! g = new Gizmo(); // Illegal -- g is final
		g.spin();
	}

	void without(Gizmo g) {
		g = new Gizmo(); // OK -- g not final
		g.spin();
	}

	//void f(final int i) { i++; } // Can't change
	// You can only read from a final primitive:
	int g(final int i) {
		return i + 1;
	}

	public static void main(String[] args) {
		FinalArguments bf = new FinalArguments();
		bf.without(null);
		bf.with(null);
	}
}

class Gizmo {
	public void spin() {
	}
}