package C$�ļ������Զ����������;
/**
 * �����Զ����������
 */
public class Demo {

	public static void main(String[] args) throws ClassNotFoundException {
		
		FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava");
		
		Class<?> c = loader.loadClass("com.bjsxt.gaoqi.HelloWorld");
		Class<?> c2 = loader.loadClass("com.bjsxt.gaoqi.HelloWorld");

		FileSystemClassLoader loader2 = new FileSystemClassLoader("d:/myjava");
		Class<?> c3 = loader2.loadClass("com.bjsxt.gaoqi.HelloWorld");
		Class<?> c4 = loader2.loadClass("java.lang.String");//��Ϊ˫��ί�л��ƣ���������ᱻ���������������
		Class<?> c5 = loader2.loadClass("A$�����ԭ��.Demo02");//���ر���Ŀ�µ�class�ļ�
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());//ͬһ�������������ֻ����һ�����󣬲����ظ�����
		System.out.println(c3.hashCode());//��ͬ����������ض��������ͬ�Ķ���
		System.out.println(c4.hashCode());
		
		//��ʾʹ�õ����������
		System.out.println(c3.getClassLoader());//�õ����Զ���ļ�����
		System.out.println(c4.getClassLoader());//Ϊ�գ��õ��������������
		System.out.println(c5.getClassLoader());//Ĭ�ϵ�AppClassLoader
	}

}
