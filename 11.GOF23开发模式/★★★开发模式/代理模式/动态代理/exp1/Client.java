package ��̬����.exp1;

public class Client {

	public static void main(String[] args) {
		//����Ŀ�����
		IUserDao target = new UserDao();
		System.out.println("Ŀ�����"+target.getClass());
		//�������
		IUserDao proxy=(IUserDao)new ProxyFactory(target).getProxyInstance();
		System.out.println("�������"+proxy.getClass());
		proxy.save();
	}
}
