package C枚举单例模式;

public class Client {

	public static void main(String[] args) {
		SingletonDemo si = SingletonDemo.INSTANCE;
		SingletonDemo  sl=SingletonDemo.INSTANCE;
		System.out.println(si);
		System.out.println(sl);
		si.singletonOperation();//调用枚举单例的一个方法
		
	}

}
