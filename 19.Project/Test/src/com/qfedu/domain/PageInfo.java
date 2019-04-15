package com.qfedu.domain;

public class PageInfo {
	private String sendUser;
	private String theme;
	private String sendContent;
	private String photo;
	public String getSendUser() {
		return sendUser;
	}
	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "pageInfo [sendUser=" + sendUser + ", theme=" + theme + ", sendContent=" + sendContent + ", photo="
				+ photo + "]";
	}
	
}
