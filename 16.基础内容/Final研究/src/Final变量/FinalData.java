package Final变量;
/**
 * 许多程序设计语言都有自己的办法告诉编译器某个数据是“常数”。常数主要应用于下述两个方面：
(1) 编译期常数，它永远不会改变
(2) 在运行期初始化的一个值，我们不希望它发生变化
对于编译期的常数，编译器（程序）可将常数值“封装”到需要的计算过程里。也就是说，计算可在编译期
间提前执行，从而节省运行时的一些开销。在Java 中，这些形式的常数必须属于基本数据类型
（Primitives），而且要用final 关键字进行表达。在对这样的一个常数进行定义的时候，必须给出一个值。
无论static 还是final 字段，都只能存储一个数据，而且不得改变。
若随同对象句柄使用final，而不是基本数据类型，它的含义就稍微让人有点儿迷糊了。对于基本数据类
型，final 会将值变成一个常数；但对于对象句柄，final 会将句柄变成一个常数。进行声明时，必须将句柄
初始化到一个具体的对象。而且永远不能将句柄变成指向另一个对象。然而，对象本身是可以修改的。Java
对此未提供任何手段，可将一个对象直接变成一个常数（但是，我们可自己编写一个类，使其中的对象具有
“常数”效果）。这一限制也适用于数组，它也属于对象。
 */
public class FinalData {
	// Can be compile-time constants
	/*
	 * 由于i1 和I2 都是具有final 属性的基本数据类型，并含有编译期的值，
	 * 所以它们除了能作为编译期的常数使用外，在任何导入方式中也不会出现任何不同
	 */
	final int i1 = 9;
	static final int I2 = 99;
	
	
	
	// Typical public constant:
	/*
	 * I3 是我们体验此类常数定义时更典型的一种方式：public表示它们可在包外使用；
	 * Static 强调它们只有一个；而final 表明它是一个常数。
	 * 注意对于含有固定初始化值（即编译期常数）的fianl static 基本数据类型，
	 * 它们的名字根据规则要全部采用大写。也要注意i5 在编译期间是未知的，所以它没有大写
	 */
	public static final int I3 = 39;
	
	
	
	// Cannot be compile-time constants:
	/*
	 * 不能由于某样东西的属性是final，就认定它的值能在编译时期知道。
	 * i4 和i5 向大家证明了这一点。它们在运行期间使用随机生成的数字。
	 * 例子的这一部分也向大家揭示出将final 值设为static 和非static 之间的差异。
	 * 只有当值在运行期间初始化的前提下，这种差异才会揭示出来。
	 * 因为编译期间的值被编译器认为是相同的。这种差异可从输出结果中看出：
	 * fd1: i4 = 15, i5 = 9
     * Creating new FinalData
     * fd1: i4 = 15, i5 = 9
     * fd2: i4 = 10, i5 = 9
     * 注意对于fd1 和fd2 来说，i4 的值是唯一的，但i5 的值不会由于创建了另一个FinalData 对象而发生改变。
     * 那是因为它的属性是static，而且在载入时初始化，而非每创建一个对象时初始化。
     * 从v1 到v4 的变量向我们揭示出final 句柄的含义。正如大家在main()中看到的那样，并不能认为由于v2
     * 属于final，所以就不能再改变它的值。然而，我们确实不能再将v2 绑定到一个新对象，因为它的属性是final。
     * 这便是final 对于一个句柄的确切含义。我们会发现同样的含义亦适用于数组，后者只不过是另一种类型的句柄而已。
     * 将句柄变成final 看起来似乎不如将基本数据类型变成final 那么有用。
	 */
	final int i4 = (int) (Math.random() * 20);
	static final int i5 = (int) (Math.random() * 20);
	
	
	
	
	Value v1 = new Value();
	final Value v2 = new Value();
	static final Value v3 = new Value();
	// ! final Value v4; // Pre-Java 1.1 Error:
	// no initializer
	// Arrays:
	final int[] a = { 1, 2, 3, 4, 5, 6 };

	public void print(String id) {
		System.out.println(id + ": " + "i4 = " + i4 + ", i5 = " + i5);
	}

	public static void main(String[] args) {
		FinalData fd1 = new FinalData();
		// ! fd1.i1++; // Error: can't change value
		fd1.v2.i++; // Object isn't constant!
		fd1.v1 = new Value(); // OK -- not final
		for (int i = 0; i < fd1.a.length; i++)
			fd1.a[i]++; // Object isn't constant!
		// ! fd1.v2 = new Value(); // Error: Can't
		// ! fd1.v3 = new Value(); // change handle
		// ! fd1.a = new int[3];
		fd1.print("fd1");
		System.out.println("Creating new FinalData");

		FinalData fd2 = new FinalData();
		fd1.print("fd1");
		fd2.print("fd2");
	}
}

class Value {
	int i = 1;
}