package com.syc.manager.vo;

import java.io.Serializable;

/**
 * 自定义的VO
 * 
 * @类名称:Perms
 * @创建人:一一哥
 * @创建时间:2018年3月14日 下午2:32:23
 */
public class Perms implements Serializable {

	private static final long serialVersionUID = 1L;

	private String url;
	private String perms;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

}
