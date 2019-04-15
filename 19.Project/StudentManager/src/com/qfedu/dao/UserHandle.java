package com.qfedu.dao;

import com.qfedu.domain.User;

public interface UserHandle {
	public boolean selectUserByUsername(User user);
}
