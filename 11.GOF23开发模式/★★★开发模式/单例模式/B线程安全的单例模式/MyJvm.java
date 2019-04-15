package B�̰߳�ȫ�ĵ���ģʽ;
/**
 * ���������ļ���ģʽ
 * 1.����ʽ(�ӳټ��أ�������)	---������һ��������ۺܸ�ʱ��֮
	 *a.������˽�л��������ⲿֱ�Ӵ�������
	 *b.����һ��˽�еľ�̬����
	 *c.����һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
 *
 */
public class MyJvm {
	private static MyJvm instance;//���ʼ��ʱ������ʼ�����������ʱ���أ������õ�ʱ���ٴ�����
	private MyJvm() {}
	
	public static MyJvm getInstance() {
		if(null==instance) {
			synchronized (MyJvm.class) {
				/* ��ȫ������Ƕ��̵߳��ѵ����ڣ�
				 * �����㲻֪����ʲô�ط�����ȫ�������Ч��
				 */
				if(null==instance) {
					instance =new MyJvm();
				}
			}
		}
		return instance;
	}
}

/**
 * 2.����ʽ---����ĵ���Ƶ�ʺܶ࣬��֮
 * 
 * 	 *a.������˽�л��������ⲿֱ�Ӵ�������
	 *b.����һ��˽�еľ�̬������ͬʱ�����ö���
	 *c.����һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
	 *
 *����ǰ�ȫ�ģ���Ϊ�����ʱ��������
 */

 class MyJvm2 {
	 /*
	  * ���ʼ�������������������û����ʱ���ص����ƣ���������ʱ����Ȼ�����̰߳�ȫ��
	  
	      �Ż���
	   		��ʹ��public static MyJvm2 getInstance() {}�������������Ҳ�ᱻ��ʼ��
	  */
	private static MyJvm2 instance=new MyJvm2();//���˾�Ҫ�Զ��������ֱ�Ӿʹ���һ������
	private MyJvm2() {}
	
	//����û��ͬ���� ������Ч�ʸ�
	public static MyJvm2 getInstance() {
		return instance;
	}
}
 

 /*
  * *****************************************
  * *Ϊ�˽������ʽ��Ч�����⣬���ǸĽ��������Ž��ڲ�����*
  * *****************************************
  * �ŵ㣺
  *		�̰߳�ȫ+����Ч�ʸ�+Ҫ��������
  *
  *����ʹ�õ�ʱ����أ������˷����ӻ��˼���ʱ��
  *���磬�Ҽ�����MyJvm3���ǲ�һ������JVMholder����ڲ���
  *�õ���ʱ����ȥ���أ���ֻҪ�Ҳ��õ�public static MyJvm3 getInstance����{}
  *�������������ڲ������Զ�������
  *
  *����һ���ᱻ��ʼ�����������ڵ��õ�ʱ��Ż�ʹ�ã�
  *�ͱ���˵����ʹ��MyJvm3����࣬��ô�������Ծ�һ���ᱻ��ʼ��
  *�������ķ���ֻ���ڵ��õ�ʱ��Ż�ʹ��
  */
 class MyJvm3 {
	 private static class JVMholder{
		 private static  MyJvm3 instance=new MyJvm3(); //final�Ӳ��Ӷ�����
	 }
	 private MyJvm3() {}
	 
	 public static MyJvm3 getInstance() {
		 return JVMholder.instance;
	 }
}