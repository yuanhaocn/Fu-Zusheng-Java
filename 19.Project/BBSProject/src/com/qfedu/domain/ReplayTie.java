package com.qfedu.domain;

import java.util.Date;

public class ReplayTie {
	private String theme;
	private String commentId;
	private Integer tieId;
	private String replyUser;
	private String replyContent;
	private Date replyTime;
	private Date updatetime;
	
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public Integer getTieId() {
		return tieId;
	}
	public void setTieId(Integer tieId) {
		this.tieId = tieId;
	}
	public String getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(String replyUser) {
		this.replyUser = replyUser;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "ReplayTie [theme=" + theme + ", commentId=" + commentId + ", tieId=" + tieId + ", replyUser="
				+ replyUser + ", replyContent=" + replyContent + ", replyTime=" + replyTime + ", updatetime="
				+ updatetime + "]";
	}
	
}
