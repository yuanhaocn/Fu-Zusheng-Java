package com.syc.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 商品分类的节点POJO
 * 
 * @类名称:CatNode
 * @创建人:一一哥
 * @创建时间:2017年11月13日 下午1:35:24
 */
public class CatNode {

	//@JsonProperty:此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把trueName属性序列化为name
	@JsonProperty("u")
	private String url;//自身关联的url

	@JsonProperty("n")
	private String name;//自身关联的分类名称

	@JsonProperty("i")
	private List<?> item;//自身关联的子分类集合

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<?> getItem() {
		return item;
	}

	public void setItem(List<?> item) {
		this.item = item;
	}

}
