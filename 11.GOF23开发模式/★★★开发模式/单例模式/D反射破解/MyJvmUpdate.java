package D反射破解;
/**
 * 优化代码，防止反射破坏规则
 */
public class MyJvmUpdate {
	private static MyJvmUpdate instance; 
	private MyJvmUpdate() {
//加入if判断，就可以解决问题，因为反射是先获得构造器，然后在此基础上建一个对象，所以一开始访问构造器的时候一定是没有对象的		
		if (null==instance) {
			throw new RuntimeException();
		}
	}
	public static MyJvmUpdate getInstance() {
		if(null==instance) {
			synchronized (MyJvmUpdate.class) {
				if(null==instance) {
					instance =new MyJvmUpdate();
				}
			}
		}
		return instance;
	}
}