package ThreadLocal���߳�;

class Demo{
	public static void main(String[] args) {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {//����ķ��ͱ�ҪҪд�����򱨴�
			@Override
			protected Integer initialValue() {
				return 10;
			}
			
		};
		Thread[] ts = new Thread[5];
		for (int i = 0; i < ts.length; i++) {
			ts[i]=new Thread(new Runnable() {

				@Override
				public void run() {
					//��ȡ�̱߳��ػ�������ֵ
					Integer number = threadLocal.get();
					System.out.println(this+" "+number);
				//����ǰ�̵߳ı��ػ�������ֵ
					threadLocal.set((int)(Math.random()*10));
					System.out.println(this+" "+threadLocal.get());
				}
				
			});
		}
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
		}
		//�̶߳�ThreadLocal���޸�ʱ��Ч�ģ�����ÿ���߳̿��Ի��ThreadLocal��ֵ
		System.out.println(threadLocal.get());
	}
}