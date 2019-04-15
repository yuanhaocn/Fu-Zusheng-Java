package ¾²Ì¬´úÀí.exp2;

public class Client {

	public static void main(String[] args) {
		IUserDao proxy = new UserDaoProxy();
		proxy.save();
	}

}
