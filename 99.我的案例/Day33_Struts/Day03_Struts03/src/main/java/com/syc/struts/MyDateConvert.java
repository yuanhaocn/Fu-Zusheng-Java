package com.syc.struts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateConvert extends StrutsTypeConverter {

	// 我们可以转换:
	// 20170909
	// 2017-09-09
	// 2017年09月09日
	// 2017/09/09
	// 2017.09.09
	private DateFormat[] formats = { new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("yyyy年MM月dd"),
			new SimpleDateFormat("yyyy/MM/dd"), new SimpleDateFormat("yyyy.MM.dd"), new SimpleDateFormat("yyyyMMdd") };

	// 将字符串转换为对象!
	// 将用户在表单中输入的字符串转换成util.Date对象!
	// values:待转换的字符串;
	// clazz:要被转换的目标类的字节码,也就是util.Date
	@SuppressWarnings({ "rawtypes" })
	@Override
	public Object convertFromString(Map context, String[] values, Class clazz) {

		if (values == null) {
			return null;
		}

		if (clazz != Date.class) {
			return null;
		}

		for (int i = 0; i < formats.length; i++) {
			try {
				return formats[i].parse(values[0]);
			} catch (ParseException e) {
				// 当一个格式转换失败的时候,尝试用下一个格式进行转换.
				continue;
			}
		}

		return null;
	}

	// 将对象转换为字符串!
	@Override
	public String convertToString(@SuppressWarnings("rawtypes") Map context, Object o) {

		return null;
	}

}
