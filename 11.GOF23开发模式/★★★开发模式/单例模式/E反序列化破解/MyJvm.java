package E�����л��ƽ�;

import java.io.Serializable;

public class MyJvm implements Serializable{
	private static MyJvm instance;//���ʼ��ʱ������ʼ�����������ʱ���أ������õ�ʱ���ٴ�����
	private MyJvm() {}
	
	public static MyJvm getInstance() {
		if(null==instance) {
			synchronized (MyJvm.class) {
				/* ��ȫ������Ƕ��̵߳��ѵ����ڣ�
				 * �����㲻֪����ʲô�ط�����ȫ�������Ч��
				 */
				if(null==instance) {
					instance =new MyJvm();
				}
			}
		}
		return instance;
	}
}