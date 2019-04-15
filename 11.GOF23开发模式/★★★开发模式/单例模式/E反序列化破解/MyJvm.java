package E反序列化破解;

import java.io.Serializable;

public class MyJvm implements Serializable{
	private static MyJvm instance;//类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）
	private MyJvm() {}
	
	public static MyJvm getInstance() {
		if(null==instance) {
			synchronized (MyJvm.class) {
				/* 安全，这才是多线程的难点所在，
				 * 就是你不知道在什么地方锁安全有能最大化效率
				 */
				if(null==instance) {
					instance =new MyJvm();
				}
			}
		}
		return instance;
	}
}