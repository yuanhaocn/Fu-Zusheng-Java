package com.syc.jdbc.login.client;

import java.util.Scanner;

import com.syc.jdbc.login.bean.User;
import com.syc.jdbc.login.server.LoginServer;

public class LoginClient {

	public static void main(String[] args) {

		System.out.println("请输入用户名:");
		// 接收用户输入
		Scanner sr = new Scanner(System.in);
		String name = sr.nextLine();
		System.out.println("请输入密码:");
		String pwd = sr.nextLine();

		//调用服务端代码
		LoginServer server = new LoginServer();
		User user = server.login(name, pwd);
		if(user==null){
			System.out.println("用户名或密码错误!");
		}else{
			System.out.println("登陆成功!");
		}
		
		//释放资源
		sr.close();
	}
}
