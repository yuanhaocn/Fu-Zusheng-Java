package Final类;
/**
 * 如果说整个类都是final（在它的定义前冠以final 关键字），就表明自己不希望从这个类继承，或者不允许其他任何人采取这种操作。
 * 换言之，出于这样或那样的原因，我们的类肯定不需要进行任何改变；或者出于安全方面的理由，我们不希望进行子类化（子类处理）。
除此以外，我们或许还考虑到执行效率的问题，并想确保涉及这个类各对象的所有行动都要尽可能地有效。
如下所示：。。。。。。。。。
 *注意数据成员既可以是final，也可以不是，取决于我们具体选择。应用于final 的规则同样适用于数据成员，无论类是否被定义成final。
 *将类定义成final 后，结果只是禁止进行继承——没有更多的限制。
 *然而，由于它禁止了继承，所以一个final 类中的所有方法都默认为final。因为此时再也无法覆盖它们。
 *所以与我们将一个方法明确声明为final 一样，编译器此时有相同的效率选择。可为final 类内的一个方法添加final 指示符，但这样做没有任何意义。
 *
 */
final class Dinosaur {
	int i = 7;
	int j = 1;
	SmallBrain x = new SmallBrain();
	void f() {}
	}
	//! class Further extends Dinosaur {}
	// error: Cannot extend final class 'Dinosaur'
	public class Jurassic {
		public static void main(String[] args) {
			Dinosaur n = new Dinosaur();
			n.f();
			n.i = 40;
			n.j++;
		}
	}
class SmallBrain {}