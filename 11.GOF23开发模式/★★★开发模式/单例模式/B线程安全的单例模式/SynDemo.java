package B�̰߳�ȫ�ĵ���ģʽ;

public class SynDemo {
	public static void main(String[] args) {
		JvmThread thread1 = new JvmThread(100);
		JvmThread thread2 = new JvmThread(500);
		thread1.start();
		thread2.start();
	}
}

class JvmThread extends Thread{
	private long time;
	
	public JvmThread() {}
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName()+"-->��������"+Jvm.getInstance(time));
	}
}
	/**
	 *�������ģʽ
	 *ȷ��һ����ֻ��һ������
	 *����ʽ 
	 *1.������˽�л��������ⲿֱ�Ӵ�������
	 *2.����һ��˽�еľ�̬����
	 *3.����һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
	 *
	 */
class Jvm{
	//2.����һ��˽�еľ�̬����
	private static Jvm instance = null;//����ʽ��������ط����ô�������ʹ�õ�ʱ���ٴ���
	//1.������˽�л��������ⲿֱ�Ӵ�������
	private Jvm() {
	}
	
	//3.����һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
	public static  Jvm getInstance1(long time) {
		if(null == instance) {
			try {
				/*Ϊ�����ӵ���ģʽ�ĳ��ִ���ĸ���
				 * ��˵�����ֵ���ģʽ��һ��ֻ�ܲ���һ�����󣬽��������̰߳�ȫ�ĵ���ģʽ 
				 * 
				 */
				Thread.sleep(time);//
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance =new Jvm();
			}
		return instance;
		}
	
	
	/*
	 * �򵥸Ľ���1��ֱ�Ӽ���synchronized�ڷ���ͷ��,����ʡ��Ч�ʵ�
	 */
	public static synchronized Jvm getInstance2(long time) {
		if(null == instance) {
			try {
				/*Ϊ�����ӵ���ģʽ�ĳ��ִ���ĸ���
				 * ��˵�����ֵ���ģʽ��һ��ֻ�ܲ���һ�����󣬽��������̰߳�ȫ�ĵ���ģʽ 
				 * 
				 */
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance =new Jvm();
			}
		return instance;
		}
	/*
	 * �ý�2�����ĵط�
	 */
	public static  Jvm getInstance3(long time) {
		/*
		 * a  b  c  d  e--����Ч�ʲ��ߣ���Ϊ��ʹ���ڶ���Ҳ��Ҫ�ȴ�
		 */
		
		
		/*
		 * ˫�ؼ������壬�Լ����������̬��Ϣ
		 */
		synchronized(Jvm.class){//��Ͳ�����this �ˣ���Ϊ��û�ж���Ҫ�������ֽ�����Ϣ
		if(null == instance) {
			try {
			 
				Thread.sleep(time);//
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance =new Jvm();
			}
		return instance;
		}
	
	}
	
	/*
	 * �ý�3�����ĵط�
	 * ************************
	 * ˫�ؼ�飨double checking��*
	 * ************************
	 * 
	 * jvm�ڲ����Ƕ���ֻ������Щ�����������������棨class load��
	 * synchronized(Jvm.class){}��һ���ģ�������ˣ�������ֻ��������ȣ��������
	 * (���⣺
	 * 	���ڱ������Ż�ԭ���JVM�ײ��ڲ�ģ��ԭ��ż��������⣬������ʹ��)
	 * 
	 */
	public static  Jvm getInstance4(long time) {
		//c  d  e---������һ����if�ж���Ϊ�����Ч�ʣ�����Ѿ����ڶ���ķ���Ч��
		if(null == instance) {
			synchronized(Jvm.class){ 
		if(null == instance) {
			try {
				Thread.sleep(time);
				
} catch (InterruptedException e) {e.printStackTrace();}
			instance =new Jvm();}}}
		return instance;
	}
}
/*
 * �Ľ�4
 * ˫�ؼ�飨double checking��
 */
 class SingletonDemo03 {
	 private static SingletonDemo03 instance = null;
	 public static SingletonDemo03 getInstance() {
		 if (instance == null) {
			 SingletonDemo03 sc;
			 synchronized (SingletonDemo03.class) {
				 sc = instance;
				 if (sc == null) {
					 synchronized (SingletonDemo03.class) {
						 if(sc == null) {
							 sc = new SingletonDemo03();
						 }
					 }
					 instance = sc;
				 }
			 }
		 }
		 return instance;
	 }
	 private SingletonDemo03() {
	 }
}
