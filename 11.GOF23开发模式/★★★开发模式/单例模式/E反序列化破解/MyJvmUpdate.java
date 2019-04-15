package E反序列化破解;
import java.io.ObjectStreamException;
/**
 * 增加方法，防止系列化破坏单例模式规则
 */
import java.io.Serializable;

public class MyJvmUpdate implements Serializable{
	private static MyJvmUpdate instance;
	private MyJvmUpdate() {}
	
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
	//在反序列化时，如果定义了readResolve方法则直接返回方法指定的对象，而不需要单独再创建新的对象
	//这样防止了反序列化漏洞（基于回调）
	private Object readResolve ()throws ObjectStreamException {
		return instance;
	}
	
}



