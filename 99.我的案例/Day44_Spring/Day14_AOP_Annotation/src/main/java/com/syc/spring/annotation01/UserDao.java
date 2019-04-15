package com.syc.spring.annotation01;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class UserDao {

	public void insert(){
		System.out.println("dao....添加...");
	}
}
