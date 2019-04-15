package D�����ƽ�;
/**
 * �Ż����룬��ֹ�����ƻ�����
 */
public class MyJvmUpdate {
	private static MyJvmUpdate instance; 
	private MyJvmUpdate() {
//����if�жϣ��Ϳ��Խ�����⣬��Ϊ�������Ȼ�ù�������Ȼ���ڴ˻����Ͻ�һ����������һ��ʼ���ʹ�������ʱ��һ����û�ж����		
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