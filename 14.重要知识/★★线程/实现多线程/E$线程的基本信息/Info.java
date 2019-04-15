package E$线程的基本信息;
/**
 * isAlive()判断线程是否还活着，即线程是否还未终止
 * getPrioroty()获得线程的优先级数值（这个优先级是概率的意思，不是绝对的优先级）
 * setPriority()设置线程的优先级数值
 * setName()给线程一个名字
 * getName()取得线程的名字
 * Thread.currentThread()取得当前正在运行的线程对象也就是取得自己本身
 *
 */
public class Info implements Runnable{
	private boolean flag=true;
	private int num=0;
	@Override
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName()+"-->"+num++);
		}
		
	}
	public void stop() {
		this.flag=!this.flag;
	}

	public static void main(String[] args) throws InterruptedException {
		Info info = new Info();
		Thread proxy = new Thread(info,"TI");//用构造器取个名字
		proxy.setName("IT");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());
		proxy.start();
		
		System.out.println("启动后的状态"+proxy.isAlive());
		
		//加一个终止条件
		Thread.sleep(20);
		info.stop();
		
		System.out.println("关闭后的状态"+proxy.isAlive());

	}
}
