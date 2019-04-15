package ThreadLocal;
/**
 * 支持泛型，提供一个数据存储，把这个数据共享给每个线程每个线程都能自由的增删改查，但是
 * 但是最后修改都是失效的
 *
 */
class Demo{
	public static void main(String[] args) {
		/*构造ThreadLocal对象，并且初始化线程本地对象
		 * 线程的初始化方法，唯一方法
		 */
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {//后面的泛型必要要写，否则报错
			@Override
			protected Integer initialValue() {
				return 10;
			}
		};
	}
}