 
package C枚举单例模式;
/**
 * 优点：
 * 		避免了反射和反序列化的漏洞
 * 		调用效率也比较高
 * 缺点：
 * 		没有懒加载（延时加载）
 */
public enum SingletonDemo{
	/*
	 * 定义一个枚举的元素，它就代表了Singleton的一个实例，
	 * 这个枚举元素本身就是一个单例对象，直接用SingletionDemo.INSTANCE的方式获取
	 */
	INSTANCE;
	
	
	
	 // 单例可以有自己的操作
	 
	public void singletonOperation() {
		//功能处理
		System.out.println("这是枚举单例模式创造的一个实例");
	}
}


