package cn.fzs.io.util;

import java.io.Closeable;

public class FileUtil {

	/**
	 * ������ر���
	 * �ɱ����: ...  ֻ���β����һ��λ��,����ʽ������һ��
	 */
	public static void close(Closeable ... io){
		for(Closeable temp:io){
			try {
				if (null != temp) {
					temp.close();
				}
			} catch (Exception e) {
			}
		}
		
	}
	
	/**
	 * ʹ�÷��ͷ���
	 */
	public static <T extends Closeable> void closeAll(T ... io){
		for(Closeable temp:io){
			try {
				if (null != temp) {
					temp.close();
				}
			} catch (Exception e) {
			}
		}
	}

}
