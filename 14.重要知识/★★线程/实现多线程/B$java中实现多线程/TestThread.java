package B$java��ʵ�ֶ��߳�;
/**
 *  java��ʵ���̣߳�һ��
 * 
 * ģ���������
 * 1���������̣߳��̳�Thread+��дrun(��Ϊ�߳��壬һ�д�run��ʼ	)
 * 2.ʹ���̣߳������������ +���ö���.start()����
 *
 */

public class TestThread{
		/*
		 * �߳��������ԣ� main + rab + tor+gc()+�쳣
		 * һ����˵�Ǵ����������߼�˳��ִ��
		 * �������ȴ����ִ��һ�㣬��ִ��һ��
		 */
		public static void main(String[] args) {//  ��---Ҳ��һ���߳�
			//2.ʹ���̣߳������������ ,ֻ�Ǵ������󣬲������߳���Ķ���
			Rabbit rab = new Rabbit();
			Tortoise tor = new Tortoise();
		
			
			//���ö���.start()����
//ֻ�Ǽ��ص��߳�������ȴ�CPU���ã��ⲽ���������̣߳��������߳����У�����Ҫ����run()���������ڲ�����run����
			rab.start();
			tor.start();
			/*
			 * rab.run();
			 * tor.run();	
//�����ᵼ�´������µ������߼�˳�������һ��·���ˣ�����Ҫ����·������Ҫ����start���������ص��̳߳أ���CPU�ѿ�
			*/
			for (int i = 0; i <100; i++) {
				System.out.println("main===>"+i);
			}
		}
}



 class Rabbit extends Thread{
	@Override
	public void run() {
		//�߳���
		for (int i = 0; i < 100; i++) {
			System.out.println("��������"+i+"��");
		}
	}

}


class Tortoise extends Thread{
	@Override
	public void run() {//�߳���
		for (int i = 0; i < 100; i++) {
			System.out.println("�ڹ�����"+i+"��");
		}
	}
	
}