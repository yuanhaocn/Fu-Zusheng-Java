package Final变量;
/**空白final
 * Java 1.1 允许我们创建“空白final”，它们属于一些特殊的字段。尽管被声明成final，但却未得到一个初始值。
 * 无论在哪种情况下，空白final 都必须在实际使用前得到正确的初始化。而且编译器会主动保证这一规定得以贯彻。
 * 然而，对于final 关键字的各种应用，空白final 具有最大的灵活性。
 * 举个例子来说，位于类内部的一个final 字段现在对每个对象都可以有所不同，同时依然保持其“不变”的本质。
 * 下面列出一个例子：
 * 现在强行要求我们对final 进行赋值处理——要么在定义字段时使用一个表达 式，要么在每个构建器中。
 * 这样就可以确保final 字段在使用前获得正确的初始化。
 */
class BlankFinal {
	final int i = 0; // Initialized final
	final int j; // Blank final
	final Poppet p; // Blank final handle
	// Blank finals MUST be initialized
	// in the constructor:
	BlankFinal() {
		j = 1; // Initialize blank final
		p = new Poppet();
	}
	BlankFinal(int x) {
		j = x; // Initialize blank final

		p = new Poppet();
	}
	public static void main(String[] args) {
		BlankFinal bf = new BlankFinal();
	}
}

class Poppet { }