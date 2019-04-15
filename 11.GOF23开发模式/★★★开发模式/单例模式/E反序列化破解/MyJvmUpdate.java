package E�����л��ƽ�;
import java.io.ObjectStreamException;
/**
 * ���ӷ�������ֹϵ�л��ƻ�����ģʽ����
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
	//�ڷ����л�ʱ�����������readResolve������ֱ�ӷ��ط���ָ���Ķ��󣬶�����Ҫ�����ٴ����µĶ���
	//������ֹ�˷����л�©�������ڻص���
	private Object readResolve ()throws ObjectStreamException {
		return instance;
	}
	
}



