package com.syc.common.pojo;

/**
 * Tree里的节点类
 * 
 * @类名称:TreeNode
 * @创建人:一一哥
 * @创建时间:2017年11月16日 下午5:39:49
 */
public class TreeNode {

	private long id;
	private String text;
	private String state;

	public TreeNode() {
	}

	public TreeNode(long id, String text, String state) {
		this.id = id;
		this.text = text;
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
