package E$泛型通配符;
class Fruit {}	//父类
class Apple extends Fruit{}	//子类 
/**
 * 通配符?的使用
 	* 1).?表示类型不定，使用时确定类型，换句话说就是在main()方法中定类型，
 	* 2).可以在声明类型及声明方法参数上，不能用在声明类上和使用时
 	* 3).?可以接受泛型的任意类型，只能接受和输出，不能修改（方法声明时参数无法正确知道具体的类型，因此不能修改）
 	* 4).? extends 泛型上限 ：表示指定的类要<= 继承的类 ，是它自身或者是他的子类
 	* 5).? super泛型下限 ：>=下限 指定的类型自身或者父类
 */
public class Student<T> {
	T score;
	
	public static void test(Student<?> stu) {}	//声明方法可以用 ,形参不定类型，编译的使用加进去类型
	//? extends 泛型上限 表示指定的类比如34行的Apple这个类要<= 继承的类比如19行的Fruit类
	public static void test02(Student<? extends Fruit> stu) {}
	public static void test03(Student< Fruit> stu) {}
	//? super泛型下限 ：>=下限 指定的类型自身或者父类
	public static void test04(Student<? super Fruit> stu) {}
	
	
	
//****************************************************************************************************//
	public static void main(String[] args) {
	//	Student<?> stu2= new Student<?>();	//?可以在声明类型及声明方法参数上使用，不能用在声明类上和使用时使用
		Student<?> stu = new Student<String>();	//前半部Student<?> stu是声明 ，后一个部分new Student<String>()是使用 
		test(new Student<Integer>());
		test02(new Student<Apple>());	//这就实现了类似与多态的情况
	// 	test03(new Student<Apple>());  //报错，因为泛型没有多态
	//	test04(new Student<Apple>());	//报错，应为test4使用的是super,所以类型就不能用Apple 要比Fruit要大，大的意思是自身或者父类
		test04(new Student<Object>());
		test04(new Student<Fruit>());	//Object是Fruit的父类，所以传进去没问题
	//	test04(stu); //使用时确定类型  
	}
//******************************************************************************************************//
}
