package D$���ܽ����������;

/**
 *���Լ򵥵ļ��ܽ��ܣ�ȡ��������  
 *
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		//����֮���class �ļ�����������������޷����أ���classFormatError
		/*FileSystemClassLoader loader = new FileSystemClassLoader("d:/myjava/temp");
		Class<?> c = loader.loadClass("com.bjsxt.gaoqi.HelloWorld");
		System.out.println(c);*/
		
		DecriptClassLoader loader = new DecriptClassLoader("d:/myjava/temp");
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
	}
}
