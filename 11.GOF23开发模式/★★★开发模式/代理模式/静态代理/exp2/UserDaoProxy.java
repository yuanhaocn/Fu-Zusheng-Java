package ��̬����.exp2;
	/**
	  ��̬����
	      �ص㣺
		1. Ŀ��������Ҫʵ�ֽӿ�
		2. �������Ҫʵ����Ŀ�����һ���Ľӿ�
	*/
public class UserDaoProxy implements IUserDao{
	// ���������Ҫά��һ��Ŀ�����
	private IUserDao target = new UserDao();
	@Override
	public void save() {
		System.out.println("��������� ��������...");
		target.save();   // ִ��Ŀ�����ķ���
		System.out.println("����������ύ����...");
}
	@Override
	public void find() {
		target.find();
	}
}