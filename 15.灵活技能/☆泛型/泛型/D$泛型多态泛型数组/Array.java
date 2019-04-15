package D$泛型多态泛型数组;

import E$泛型通配符.Student;

/**		“泛型数组”的实现----》其实就是ArrayList<E>的理论基础
 * 没有泛型数组，不能创建泛型数组
 * 可以只有声明，可以使用吗？
 * A<String>[] a1 = null;
 * A<?>[] a2 = new A<?>[10];
 */
public class Array {

	public static void main(String[] args) {
		Integer[] arr = new Integer[4];
		Student<String>[] arr2;			//声明可以用 ，但没啥意义	———其实还是有意义的ArrayList中的remove(T[] a)就是应用
//	arr2 = new Student<String>[10];  //报错，不能够创建使用 Cannot create a generic array of Student<String>

	
//***********************************************************************************//
	MyArrayList<String> strList  = new MyArrayList<String>();	//使用一下MyArrayList<E>
	strList.add(0,"Fu Zusheng is the best programmer");		//在外层使用Object数组进行接受，使用的时候再弄回来
	String elem = strList.getElem(0);
	System.out.println(elem);
	}

}
/**
 * 就是ArrayList的精简版
 */
class MyArrayList<E>{
	//E[] cap = new E[10];	//这样使用时错误的 前一半声明没有问题，后一半使用就有问题了
	//E[] cap = new Object[10]; //也是不可以的
	Object[] cap = new Object[10];	//使用Object数组可以接受任何东西，下面再强制类型转换
	public void add(int idx,E e) {
		cap[idx] = e;
	}
	@SuppressWarnings("unchecked")		//压制警告
	public E[] getAll() {
		return (E[]) cap;		//强制类型转换
	}
	@SuppressWarnings("unchecked")	//压制警告
	public E getElem(int idx) {
		return(E) cap[idx];		//强制类型转换
	}
	
	
}
