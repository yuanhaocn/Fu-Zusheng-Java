package ThreadLocal多线程;

class Demo{
	public static void main(String[] args) {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {//后面的泛型必要要写，否则报错
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
					//获取线程本地化变量的值
					Integer number = threadLocal.get();
					System.out.println(this+" "+number);
				//给当前线程的本地化变量赋值
					threadLocal.set((int)(Math.random()*10));
					System.out.println(this+" "+threadLocal.get());
				}
				
			});
		}
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
		}
		//线程对ThreadLocal的修改时无效的，但是每个线程可以获得ThreadLocal的值
		System.out.println(threadLocal.get());
	}
}