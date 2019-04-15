package com.syc.common.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 商城项目中自定义的响应结构
 */
public class ShopResult {

	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	// 响应业务状态
	private Integer status;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;

	public ShopResult() {
	}

	public ShopResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public ShopResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public static ShopResult ok(Object data) {
		return new ShopResult(data);
	}

	public static ShopResult ok() {
		return new ShopResult(null);
	}

	// 构建ShopResult对象
	public static ShopResult build(Integer status, String msg, Object data) {
		return new ShopResult(status, msg, data);
	}

	public static ShopResult build(Integer status, String msg) {
		return new ShopResult(status, msg, null);
	}

	/**
	 * 将JSON结果集转换为ShopResult对象
	 * 
	 * @方法名称:formatToPojo
	 * @创建时间:2017年10月20日 下午1:22:05
	 * @返回类型:ShopResult
	 */
	public static ShopResult formatToPojo(String jsonData, Class<?> clazz) {
		try {

			if (clazz == null) {
				// 将json数据转为ShopResult对象
				return MAPPER.readValue(jsonData, ShopResult.class);
			}

			// 读取出json数据的节点结构
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			// 得到data节点
			JsonNode dataNode = jsonNode.get("data");

			Object obj = null;
			if (clazz != null) {
				if (dataNode.isObject()) {// 如果是对象类型
					obj = MAPPER.readValue(dataNode.traverse(), clazz);
				} else if (dataNode.isTextual()) {// 文本类型
					obj = MAPPER.readValue(dataNode.asText(), clazz);
				}
			}

			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (IOException e) {
			return null;
		}

	}

	/**
	 * 没有Object对象时的转化
	 * 
	 * @方法名称:format
	 * @创建时间:2017年10月20日 下午1:30:11
	 * @返回类型:ShopResult
	 */
	public static ShopResult format(String json) {
		try {
			return MAPPER.readValue(json, ShopResult.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 转换为集合对象的方法. json:要转换的数据 clazz:集合中的类型
	 * 
	 * @方法名称:formatToList
	 * @创建时间:2017年10月20日 下午1:32:18
	 * @返回类型:ShopResult
	 */
	public static ShopResult formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode dataNode = jsonNode.get("data");
			Object obj = null;
			// 如果data节点是JSONArray
			if (dataNode.isArray() && dataNode.size() > 0) {
				obj=MAPPER.readValue(dataNode.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (IOException e) {
			return null;
		}
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ObjectMapper getMapper() {
		return MAPPER;
	}

}
