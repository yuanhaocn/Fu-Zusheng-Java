package com.syc.jms.domain;

import java.io.Serializable;

public class MessageVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MessageVO [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

}
