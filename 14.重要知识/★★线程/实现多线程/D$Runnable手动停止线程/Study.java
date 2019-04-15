package D$Runnable手动停止线程;
/**
 * 手动停止线程
 	* 1，自然终止：线程体正常执行完毕
 	* 2，外部干涉：
 		* 1）线程类中 定义线程使用时的标识
 		* 2）线程体使用该标志
 		* 3) 提供对外的方法改变该标识
 		* 4）外部干涉根据条件调用方法结束即可
 */
class Study implements Runnable{
// 1）线程类中 定义线程使用时的标识
		private boolean flag=true;//一个标识，用来结束线程
//3) 提供对外的方法改变该标识
		public void stop() {
			this.flag=false;
		}		
		
		
		@Override
		public void run() {
//2）线程体使用该标志
			while(flag) {
				System.out.println("Study Thread...");
			}
		}
		
public static void main(String[] args) {
		//代理模式
		Study s=new Study();
		new Thread().start();
		//外部干涉
		for (int i = 0; i < 100; i++) {
			if(50==i) {
//4）外部干涉根据条件调用方法结束即可
				s.stop();
			}
			System.out.println("main线程"+i);
		}
		
	}
	
		
}