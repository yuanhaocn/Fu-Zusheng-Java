package B$���ͽӿ��෽��;

import java.io.Closeable;
import java.io.IOException;

/**
 * ���ͷ���   <>��������ǰ��
 * ֻ�ܷ��ʶ������Ϣ�������޸���Ϣ
 
����ʹ�ã�<��ĸ>

   	���η�<��ĸ>�������� ���������β��б�{
   	}
   	
   Ҫ���巺�ͷ�����ֻ��Ҫ�����Ͳ����б����ڷ���ֵǰ��
  * ע�⣺���ͻ����Զ����ڷ����У��Ƿ�ӵ�з��ͷ������������ڵ����Ƿ���û�й�ϵ
 */
public class TestMethod {

	public static <T extends Closeable> void test(T... a) {		//����Ƿ��ͷ���
		for(T temp:a) {
			try {
				if(null != temp) {
				temp.close();	
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}   
		System.out.println(a);
	  }
	public static void main(String[] args) {
	//	test("a");		//T-->String 
	}
}
