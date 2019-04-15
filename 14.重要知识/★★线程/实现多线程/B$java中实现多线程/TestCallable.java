package B$java��ʵ�ֶ��߳�;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java��ʵ�ֶ��̣߳�����
 * 
 * 
 * ͨ��Callable���ص��������ӿ�ʵ�ֶ��߳�
 *
 * �ŵ㣺���Ի�÷���ֵ
 * 
 * Callable��Future�ӿ�
 * Callable��������Runnable�Ľӿڣ�ʵ��Callable�ӿڵ����ʵ��Runnable���඼�ǿ��Ա������߳�ִ�е�����
 * Callable��Runable�Ĳ�ͬ�㣺
 	* 	 (1)Callable�涨�ķ�����call() ��Runnable�涨�ķ�����run();
 	* 	 (2) call()���������׳��쳣����run()�����ǲ����쳣��
 	* 	 (3)Callable������ִ�к�ɷ���ֵ������Callable������õ�һ��Future�����Եȴ��������ɣ����������Ľṹ
 * Future��ʾ�첽����Ľ�������ṩ�˼������Ƿ���ɵķ������Եȴ��������ɣ�����������Ľ��
 * ͨ��Future������˽�����ִ�е��������ȡ�������ִ�У����ɻ������ִ�еĽ��
 * 
 * ȱ�㣺����
 * 
 * ˼·��
 	* 		1)����Callableʵ����+��дcall����
 	* 		2)����ִ�е��ȷ���ExceptorService�����Future����
 	* 			ExecutorService ser = Executors.newFixedThreadPool(2);
 	* 			Future result = ser.submit(ʵ�������);
 	*		3)���ֵresult.get()
 	*		4)ֹͣ����ser.shutdownNow();
 */
public class TestCallable implements Callable<Integer>{
	//��һ���ӳ�
	private String name;		//����
	private int time;		//��ʱ��ʱ�䣨�������Ϲ����Ҫ�ȼ��룩�������ʾ�ڹ�����ӵ��˶����
	private boolean flag =true;
	private int step=0;	//������������ĵڼ���
	@Override
	public Integer call() throws Exception {//����--�߳���
		while(flag) {
			Thread.sleep(time);//��ʱ--���ߵĶ������
			step++;
		}
		return  step;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//�����߳�
		ExecutorService ser = Executors.newFixedThreadPool(2);
		TestCallable tortoise= new TestCallable("ǧ������",1000);
		TestCallable rabbit= new TestCallable("С����",500);
		//���ֵ
		Future<Integer> result1 = ser.submit(tortoise);
		Future<Integer> result2 = ser.submit(rabbit);
		
		Thread.sleep(5000); //����֮���ͣ����,ֹͣ�߳����ѭ��
		tortoise.setFlag(false);
		rabbit.setFlag(false);
		
		int num1 =result1.get();
		int num2 =result2.get();
		System.out.println("�ڹ�����--��"+num1+"��");
		System.out.println("��������--��"+num2+"��");
		//ֹͣ����ser.shutdownNow();
		ser.shutdownNow();
		
	}
	
//#################################################################################################################################################	
//####################����û�ˣ����ÿ�##################################################################################################################################################
//#################################################################################################################################################	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public TestCallable() {
		super();
	}

	public TestCallable(String name, int time) {
		super();
		this.name = name;
		this.time = time;
	}
	public TestCallable(String name, int time, boolean flag, int step) {
		super();
		this.name = name;
		this.time = time;
		this.flag = flag;
		this.step = step;
	}



	

}
