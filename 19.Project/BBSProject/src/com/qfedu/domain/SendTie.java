package com.qfedu.domain;

import java.util.Date;

public class SendTie {
	private Integer tieId;
	private String theme;
	private String sendContent;
	private String sendUser;
	private Date sendTime;
	private Date updateTime;
	public Integer getTieId() {
		return tieId;
	}
	public void setTieId(Integer tieId) {
		this.tieId = tieId;
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
	public String getSendUser() {
		return sendUser;
	}
	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "SendTie [tieId=" + tieId + ", theme=" + theme + ", sendContent=" + sendContent + ", sendUser="
				+ sendUser + ", sendTime=" + sendTime + ", updateTime=" + updateTime + "]";
	}

}
