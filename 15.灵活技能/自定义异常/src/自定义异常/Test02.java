package �Զ����쳣;
/**
 * finally
 * 		1��finally����Ĵ��벻���Ƿ����쳣һ����ִ��ͨ��������β��������IO��������ر�������
		2��finally��retrun���������������retrun��finally������Ȼ����ִ��
		3��finally������Զ����ִ�У����ǹر�jvm
 * 
 *
 */
public class Test02 {
	public static void main(String[] args) {
		double myFun = myFun();
		System.out.println(myFun);
	}

	public static double myFun() {
		try {
			double result = ByZeroException.chufa(12, 0);
			return result ;
		} catch (Throwable e) {
			return 0;
		} finally {
			System.out.println("this  is  finally code...");
		}
	}
}
