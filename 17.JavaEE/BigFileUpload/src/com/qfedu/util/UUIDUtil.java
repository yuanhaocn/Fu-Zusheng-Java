package com.qfedu.util;
/**
 * UUID���߰�����������Ψһ��ʶ
 */
import java.util.UUID;

public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
