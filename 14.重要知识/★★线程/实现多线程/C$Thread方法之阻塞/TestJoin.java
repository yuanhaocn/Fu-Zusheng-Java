package C$Thread����֮����;
/**
 * �߳�����
 * join:�ϲ��߳���Thread�еķ������÷�������.join() �Ѷ�����̼߳ӽ�����
 * ����λ�õ��߳��⵽����������Ҫ�ȴ������߳����н���
 * ��׻���������һ���߳�����join��һ���̣߳������÷����Ǿ�̬��
 */
public class TestJoin extends Thread {
	public static void main(String[] args) throws InterruptedException {
		TestJoin Demo = new TestJoin();
		Thread t = new Thread(Demo);//����
		t.start();//����
//###############################################################			
//##################һ����λ#######################################	
		new Thread(new TestJoin()).start();		           	//###
//###############################################################			
//###############################################################			
		
		//CPU����
		for (int i = 0; i < 100; i++) {
			if(50==i) {
				//main����
	//���������Ҫ�ȴ�run()ȫ����������У����û����һ���־���˫�̣߳�������һ���֣���Ҳ����һ����
			t.join();
			}
			System.out.println("main..."+i);
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("join..."+i);
		}
	}
}
