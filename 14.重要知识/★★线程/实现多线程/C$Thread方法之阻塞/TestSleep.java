package C$Thread����֮����;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 3)sleep���ߣ����ߵ�ʱ�򲻻��ͷ����������ڡ�ģ�⵹��ʱ������ģ�������ӳ١�����ʱ���йص�
 * ����ʱ
 * 1������10������һ���ӡһ��
 *
 */
public class TestSleep {
	public static void main(String[] args) throws InterruptedException  {
		Date date = new Date(System.currentTimeMillis()+10*1000);
		long end = date.getTime();
		while(true) {
			//���
			System.out.println(new SimpleDateFormat("mm:ss").format(date));
			//������һ���ʱ��
			date=new Date(date.getTime()-1000);
			//�ȴ�һ��
			Thread.sleep(1000);
			if(end-10000>date.getTime()) {
				break;
			}
		}
		
	}
	//����ʱ
	public static void test() throws InterruptedException {
		int num =10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);	//����ͣ
			if(num<=0) {
				break;
			}
		}
	}
}
