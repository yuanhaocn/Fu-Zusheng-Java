package A����ģʽ;
/**
 * ������static�Ķ���ֻ��һ�ݵ�˼�롣
 * �κε��޸ĸĶ�������һ�������ϵĲ���
 * ����ģʽ
 * ������final��������ȥ�ģ�С��
 * ����ʽ��
 */
public final class CEO {
	//����private��static �ı������
	private  static final CEO ceo = new CEO();
	//���췽��˽�л�
	private CEO() {
	}
	//����public ��static�ķ���ֵCEO���͵ķ���
	public  static final CEO getInstance() {
		return ceo;
	}
}

/**
 * ����ʽ
 */
class CEO2 {
	//����private��static �ı������
	private  static  CEO2 ceo2 ;
	//���췽��˽�л�
	private CEO2() {
	}
	//����public ��static�ķ���ֵCEO���͵ķ���
	public  static  CEO2 getInstance() {
		if (null==ceo2) {
			ceo2= new CEO2();
		}
		return ceo2;
	}
}