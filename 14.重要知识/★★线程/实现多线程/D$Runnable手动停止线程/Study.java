package D$Runnable�ֶ�ֹͣ�߳�;
/**
 * �ֶ�ֹͣ�߳�
 	* 1����Ȼ��ֹ���߳�������ִ�����
 	* 2���ⲿ���棺
 		* 1���߳����� �����߳�ʹ��ʱ�ı�ʶ
 		* 2���߳���ʹ�øñ�־
 		* 3) �ṩ����ķ����ı�ñ�ʶ
 		* 4���ⲿ��������������÷�����������
 */
class Study implements Runnable{
// 1���߳����� �����߳�ʹ��ʱ�ı�ʶ
		private boolean flag=true;//һ����ʶ�����������߳�
//3) �ṩ����ķ����ı�ñ�ʶ
		public void stop() {
			this.flag=false;
		}		
		
		
		@Override
		public void run() {
//2���߳���ʹ�øñ�־
			while(flag) {
				System.out.println("Study Thread...");
			}
		}
		
public static void main(String[] args) {
		//����ģʽ
		Study s=new Study();
		new Thread().start();
		//�ⲿ����
		for (int i = 0; i < 100; i++) {
			if(50==i) {
//4���ⲿ��������������÷�����������
				s.stop();
			}
			System.out.println("main�߳�"+i);
		}
		
	}
	
		
}