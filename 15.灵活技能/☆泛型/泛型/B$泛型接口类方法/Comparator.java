package B$泛型接口类方法;
/**
 * 
 * 接口中泛型字母只能使用在方法中，不能使用在全局常量中
 * @param <T>
 */
public interface Comparator<T> {
	//public static final T a=10;
	void compare(T t);		//抽象方法
}
