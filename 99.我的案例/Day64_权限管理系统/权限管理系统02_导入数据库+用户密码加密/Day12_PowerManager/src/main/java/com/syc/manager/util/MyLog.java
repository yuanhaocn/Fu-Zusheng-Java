package com.syc.manager.util;

public class MyLog {

	private static final boolean open = true;//log开关

	public static void log(Object... msg) {
		if (!open) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (Object s : msg) {
			sb.append(" ----->" + s);
		}
		System.out.println(sb.toString());
	}
}
