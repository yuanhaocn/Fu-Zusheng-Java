package com.qfedu.domain;

public class UserExt {
	private String username;
	private String nickname;
	private String email;
	private Integer sendnumber;
	private Integer replynumber;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSendnumber(Integer sendnumber) {
		this.sendnumber = sendnumber;
	}
	public void setReplynumber(Integer replynumber) {
		this.replynumber = replynumber;
	}
	@Override
	public String toString() {
		return "UserExt [username=" + username + ", nickname=" + nickname + ", email=" + email + ", sendnumber="
				+ sendnumber + ", replynumber=" + replynumber + "]";
	}
	public String getUsername() {
		return username;
	}
	public String getNickname() {
		return nickname;
	}
	public String getEmail() {
		return email;
	}
	public Integer getSendnumber() {
		return sendnumber;
	}
	public Integer getReplynumber() {
		return replynumber;
	}
	
}
