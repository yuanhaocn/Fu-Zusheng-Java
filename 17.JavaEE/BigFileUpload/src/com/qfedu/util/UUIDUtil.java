package com.qfedu.util;
/**
 * UUID工具包，用来生成唯一标识
 */
import java.util.UUID;

public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
