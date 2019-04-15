package F����Ч��;
import java.util.concurrent.CountDownLatch;

import A����ģʽ.*;
import B�̰߳�ȫ�ĵ���ģʽ.*;
import Cö�ٵ���ģʽ.*;

/**
 * ����5�д�������ģʽ��Ч�ʣ����̴߳󲢷���
 * ���̲߳��Ի���CountDownLatch��ʹ��---�����̲߳��Ծ����õ�
 * 	ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�����߶���߳�һֱ�ȴ�
 * 	countDown()��ǰ�̵߳�������������������һ
 * await()���ô˷�����һֱ������ǰ�̣߳�֪����ʱ����ֵΪ0
 * 
 * ����ʽ��A����ģʽ.CEO
 * ����ʽ��A����ģʽ.CEO2
 * ��̬�ڲ���ʽ��B�̰߳�ȫ�ĵ���ģʽ.MyJvm3
 * ö��ʽ��Cö�ٵ���ģʽ.SingletonDemo
 * ˫�ؼ����ʽ��B�̰߳�ȫ�ĵ���ģʽ.SingletonDemo03
 */

public class Test{
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		int threadNum=10;//�߳���--����ʹ����ѭ����������߳���
	 final	CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		
		for (int j = 0; j < 10; j++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						CEO o = CEO.getInstance();//---->>>������Ը��ģ��Ϳ��Լ��������
					}
					//��ʱ���߳��Ѿ������ˣ���������һ
					countDownLatch.countDown();
				}
			}).start();
		}
		
		/*���ʱ��ʱ���ǲ�׼ȷ�ģ���Ϊmain�̺߳��Լ��������Щ�����ڲ�����߳�����ͷ�����ģ�
		 * �����п��������̻߳�û������main�߳̾��Ѿ�ִ�е���һ���ˣ����Լ����ʱ�����Ҫ�ȴ�
		 *�ȴ������10���̶߳�ִ�����ˣ����ǲſ�ʼ�����ʱ��ִ�У�����Ҫ���������߳�
		 *CountDownLatch���൱����������ж��ٸ��߳̾��Ǹ�ֵΪ�����߳̽����ĵط�����.countDown()�������������ͼ�һ��
		 */		
		countDownLatch.await();//main�߳�������ֻ����������Ϊ0���Ż��������ִ��
		long end = System.currentTimeMillis();
		System.out.println("�ܺ�ʱ"+(end-start));
	}
}





