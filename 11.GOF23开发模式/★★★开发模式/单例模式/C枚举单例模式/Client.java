package Cö�ٵ���ģʽ;

public class Client {

	public static void main(String[] args) {
		SingletonDemo si = SingletonDemo.INSTANCE;
		SingletonDemo  sl=SingletonDemo.INSTANCE;
		System.out.println(si);
		System.out.println(sl);
		si.singletonOperation();//����ö�ٵ�����һ������
		
	}

}
