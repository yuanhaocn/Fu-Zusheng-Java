package A单例模式;
/**
 * 核心是static的对象只有一份的思想。
 * 任何的修改改动都是在一个东西上的操作
 * 单例模式
 * 这三个final是最后加上去的，小心
 * 饿汉式：
 */
public final class CEO {
	//创建private的static 的本类对象
	private  static final CEO ceo = new CEO();
	//构造方法私有化
	private CEO() {
	}
	//创建public 的static的返回值CEO类型的方法
	public  static final CEO getInstance() {
		return ceo;
	}
}

/**
 * 懒汉式
 */
class CEO2 {
	//创建private的static 的本类对象
	private  static  CEO2 ceo2 ;
	//构造方法私有化
	private CEO2() {
	}
	//创建public 的static的返回值CEO类型的方法
	public  static  CEO2 getInstance() {
		if (null==ceo2) {
			ceo2= new CEO2();
		}
		return ceo2;
	}
}