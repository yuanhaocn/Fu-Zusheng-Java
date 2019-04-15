package com.qfedu.domain;
/**
 * π‹¿Ì‘±’À∫≈
 *
 */
public class User {
	private String number;
	private String password;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [number=" + number + ", password=" + password + "]";
	}
	
}
