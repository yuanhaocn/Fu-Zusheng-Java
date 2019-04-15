
package D$泛型多态泛型数组;
/**
 * 泛型没有多态!!一棍打死
 */
public class SimulGen {
	public static void main(String[] args) {
	//	A<Fruit> f1 = new A<Apple>();	//Type mismatch: cannot convert from A<Apple> to A<Fruit> 
										// 这是多态的经典写法，但是泛型没有多态
		A<Fruit> f = new A<Fruit>();
	}
	//形参使用多态
	public static void test(A<Fruit> f) {
		
	}
	//返回类型使用多态
	public static A<Fruit> test2() {
		return null ;
	}
}
/**
 * 泛型类
 * 泛型之中能使用多态吗？ 答案是不对的，泛型没有多态
 * @param <T>
 */
 class A<T> {}
