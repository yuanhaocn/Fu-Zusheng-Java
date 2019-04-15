package C$泛型的继承和实现;
/**
 * 泛型接口：与继承时同理的
 * 重写方法随父类而定
 * @author FZS
 *
 * @param <T>
 */
public interface Comparable<T> {
 void compare(T t);		//以下每个重写的方法随父类而定
}
//声明子类指定具体类型
class Comp  implements Comparable<Integer>{

	@Override
	public void compare(Integer t) {
		// TODO Auto-generated method stub
		
	}}
//泛型擦除
class Comp1 implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub
		
	}}
//父类擦除，子类泛型
class Comp2<T> implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub
		
	}}
//子类泛型>=父类泛型
class Comp3<T,T2> implements Comparable<T>{

	@Override
	public void compare(T t) {
		// TODO Auto-generated method stub
		
	}}
//父类泛型，子类擦除错误