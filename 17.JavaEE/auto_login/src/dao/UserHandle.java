package dao;



import domain.User;

public interface UserHandle {
	public boolean selectUserByUsername(User user);
}
