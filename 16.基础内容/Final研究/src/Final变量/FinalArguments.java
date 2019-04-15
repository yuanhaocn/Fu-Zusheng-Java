package Final变量;
/**final自变量
 * Java 1.1 允许我们将自变量设成final 属性，方法是在自变量列表中对它们进行适当的声明。
 * 这意味着在一个方法的内部，我们不能改变自变量句柄指向的东西。
 * 如下所示：注意此时仍然能为final 自变量分配一个null（空）句柄，同时编译器不会捕获它。
 * 这与我们对非final 自变量采取的操作是一样的。
 * 方法f()和g()向我们展示出基本类型的自变量为final 时会发生什么情况：我们只能读取自变量，不可改变它。
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