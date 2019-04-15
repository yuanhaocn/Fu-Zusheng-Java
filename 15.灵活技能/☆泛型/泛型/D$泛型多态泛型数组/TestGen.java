package D$泛型多态泛型数组;
/**
* 多态的复习
 		* 对Fruit进行应用
 		* 多态的两种形态 
 */
public class TestGen {
	//形参使用多态
	public static void test(Fruit f) {}
	//返回类型使用多态
	public static Fruit test2() {return new Apple();}
	
	public static void main(String[] args) {
		Fruit f = new Apple();		//发生多态 父类引用指向子类对象
		test(new Apple());		//抛一个子类过去具体实现就是子类的重写部分
	}
}

class Fruit {}//父类
class Apple extends Fruit{}//子类