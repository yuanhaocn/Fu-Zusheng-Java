package �Զ����쳣;
//		1).����̳��쳣��ĸ���Throwable��Throwbale��һ����ͨ��
public class ByZeroException extends Throwable {
//		2).������Ҫʵ��һ������ΪString���͵��вι���,����һ�����������д�������
	public ByZeroException(String message) {
		super(message);
	}
	/*
	 * һ������������ܻ��׳��ܶ��쳣
	 * ������Ҫ�ڷ���ͷ��ʹ��throws�׳��쳣������������ 
	 * �쳣�ͷ���ֵһ��������׸����������ߣ��̳кͶ�̬��Ӧ��
	 */
public static double chufa(double a,double b) throws ByZeroException,NullPointerException {
//		3).����b���з����ж�
		if (b==0) {
			/*
			 * �����쳣��
			 * throw���׳��ĺ��壬ָ���ǰ�Throwable���������ӷ������׳�ȥ
			 * ����message�ᾭ������Ĺ��췽������Throwable��Throwable������message
			 * ���ر������
			 */
			throw new ByZeroException("��������Ϊ��!");
		}
		if(b==1) {
			throw new NullPointerException();
		}
		
		
		else {
			//����0��������
			return a/b;
		}
	}
	public static void main(String[] args) {
		/*
		 * ������õķ�����������쳣�׳���Ϊ����ô�������ûỮ����
		 * �����쳣������������
		 * 		1)ʹ��try...catch...�﷨�Զ�������쳣������һ����õ�һ��
		 * 		2)�������Ѹ��쳣���������׳�   throws Throwable
		 */
		try {
			double res = ByZeroException.chufa(12, 0);
			System.out.println(res);
		} catch (Throwable e) {
			System.out.println("hello world");
			e.printStackTrace();
		}
//************************************************************************
		try {
			ByZeroException.chufa(12, 0);
		} catch (Throwable e) {
			//ֱ�ӻ�ȡ���Ե���Ϣ
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}
