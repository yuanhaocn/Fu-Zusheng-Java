package A$�����ԭ��;

public class Demo02 {

	public static void main(String[] args) {
		//��Щ��û��Ҫ����
		System.out.println(ClassLoader.getSystemClassLoader());//���Ӧ���������
		System.out.println(ClassLoader.getSystemClassLoader().getParent());//��չ�������
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//���������������ȡ����
	
		System.out.println(System.getProperty("java.class.path"));//Ŀǰ������������class.path--->���˵�������Ŀ��binĿ¼����������class.path
		
	}

}
