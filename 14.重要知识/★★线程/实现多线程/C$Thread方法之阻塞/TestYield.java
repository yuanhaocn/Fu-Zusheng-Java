package C$Thread����֮����;

/**
 * ��̬yield����,�����á��Լ����߳�
 */
public class TestYield extends Thread {
	public static void main(String[] args) {
		TestYield Demo = new TestYield();
		Thread t = new Thread(Demo);//����
		t.start();//����
		//CPU����
		
		for (int i = 0; i < 100; i++) {
			if(i%20==0) {
//��ͣ���߳�main,д��˭���߳����������ͣ˭���ǲ��������ͣ�ˣ���Ҫ��CPU�����ˣ���������û�취
//�ܵ�CPU���ȵģ�û���ϸ��������ͣ��Thread.yield(ʱ��);
				Thread.yield();
			}
			System.out.println("main..."+i);
		} 
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("yield..."+i);
		}
	}

}
