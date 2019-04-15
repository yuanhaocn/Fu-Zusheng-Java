package daoImp;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.UserHandle;
import domain.User;
import util.DButil;

public class UserHandleImp implements UserHandle {
	private Connection connection = DButil.getConnection("root", "123456", "test");

	@Override
	public boolean selectUserByUsername(User user) {
		String sql = "select password  from user where number = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, user.getNumber());
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String password = resultSet.getString("password");
				if(password.equals(user.getPassword())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
