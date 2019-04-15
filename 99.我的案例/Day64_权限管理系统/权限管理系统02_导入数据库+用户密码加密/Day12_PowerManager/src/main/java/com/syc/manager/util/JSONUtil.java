package com.syc.manager.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 负责将JavaBean转换为JSON字符串
 * 
 * @类名称:JSONUtil
 * @创建人:一一哥
 * @创建时间:2018年3月13日 上午11:46:32
 */
public class JSONUtil {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 将object对象转为json的方法
	 */
	public static String objectToJson(Object object) {
		try {
			return MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json转为object对象的方法
	 */
	public static <T> T jsonToObject(String json, Class<T> type) {
		try {
			return MAPPER.readValue(json, type);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 将json转为List集合的方法
	 */
	public static <T> List<T> jsonToList(String json, Class<T> type) {
		try {
			//构建出一个泛型类型
			JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, type);
			return MAPPER.readValue(json, javaType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
