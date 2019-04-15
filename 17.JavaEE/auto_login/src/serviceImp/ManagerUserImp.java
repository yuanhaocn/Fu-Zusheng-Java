package serviceImp;



import dao.UserHandle;
import domain.User;
import service.ManagerUser;

public class ManagerUserImp implements ManagerUser{
	private UserHandle uh;
	
	@Override
	public boolean login(String number, String password) {
		User user = new User();
		user.setNumber(number);
		user.setPassword(password);
		boolean b = uh.selectUserByUsername(user);
		return b;
	}

	public UserHandle getUh() {
		return uh;
	}

	public void setUh(UserHandle uh) {
		this.uh = uh;
	}

}
