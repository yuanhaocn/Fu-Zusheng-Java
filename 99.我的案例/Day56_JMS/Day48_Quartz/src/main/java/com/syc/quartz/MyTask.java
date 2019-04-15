package com.syc.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 每隔5秒钟,打印一次时间.
 * @类名称:MyTask
 * @创建人:一一哥
 * @创建时间:2018年1月17日 下午3:46:59
 */
public class MyTask {

	public void printTime() {
		System.out.println("当前时间=" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
	}
}
