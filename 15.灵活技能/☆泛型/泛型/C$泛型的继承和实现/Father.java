package C$泛型的继承和实现;
/**
 * 父类为泛型类
 * 1，属性
 * 2，方法
 * 要么同时擦出，要么子类大于等于父类的类型
 * 不能子类擦出，父类泛型
 * 1，属性类型 
 * 	父类中，随父类而定
 * 	子类中，随子类而定
 * 2，方法重写
 * 随父类而定
 *  
 * @author FZS
 *
 */
public abstract class Father<T>{
	T name;
	public abstract void test(T t);
}
/*
 * 1，子类使用时（声明时）指定具体类型
 * 属性类型为具体类型
 * 方法同理 
 */
class Child extends Father<String>{
	String t2;
	@Override
	public void test(String t) {
		// TODO Auto-generated method stub
		
	}
	
}
/*
 * 2，子类为泛型类，类型在使用的时候确定
 * 
 */
class Child2<T2,T> extends Father<T>{ //child<T>的泛型参数的名字和分数要和父类一致 ，顺序可以调换,子类Child2的多一点时没关系的
	String t2;
	@Override
	public void test(T t) {
		
	}	
}

/*
 * 3,子类为泛型类，父类不指定类型，叫做泛型的擦除，统一使用Object替换
 */
class Child3<T> extends Father{

	@Override
	public void test(Object t) {		//11行注释对此有解释
		// TODO Auto-generated method stub
		
	}
	
}
/*
 * 4,子类和父类同时擦出
 */
class Child4 extends Father{
//不能使用T
	
	@Override
	public void test(Object t) {	//变成Object类型
		// TODO Auto-generated method stub
		
	}
	
}
/*
 * 错误：5,子类擦除，父类使用泛型
 */
/*
class Child5 extends Father<T>{
	String name;
	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
		
	}
	
}
*/