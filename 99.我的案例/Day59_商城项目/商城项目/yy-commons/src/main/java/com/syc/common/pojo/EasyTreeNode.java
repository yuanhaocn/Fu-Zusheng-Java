package com.syc.common.pojo;

/**
 * 商品类目所使用的JavaBean
 * 
 * @类名称:EasyTreeNode
 * @创建人:一一哥
 * @创建时间:2017年11月10日 上午10:26:36
 */
public class EasyTreeNode {

	private long id;// 每个类目的编号
	private String text;// 每个类目的名称
	// 当一个节点下有子节点的时候,state=closed;否则就是open.
	private String state;// open,closed,表示树形结构的开关状态

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
