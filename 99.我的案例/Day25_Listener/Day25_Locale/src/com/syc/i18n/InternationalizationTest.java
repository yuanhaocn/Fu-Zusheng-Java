package com.syc.i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

//Internationalization--->i18n:国际化
public class InternationalizationTest {

	//语言的国际化
	@Test
	public void localeTest() {
		//本地化对象
		//Locale locale = Locale.getDefault();
		
		Locale locale=Locale.US;
		
		//baseName:基名,com.syc.i18n.login
		//ResourceBundle:资源包
		//com.syc.i18n.login_zh_CN.properties
		//com.syc.i18n.login_en_US.properties
		ResourceBundle bundle = ResourceBundle.getBundle("com.syc.i18n.login", locale);
		//获取对应的key的值
		String name = bundle.getString("name");
		String pass = bundle.getString("pass");
		String submit = bundle.getString("submit");
		System.out.println("Name="+name);
		System.out.println("pass="+pass);
		System.out.println("submit="+submit);
	}
	
	//时间,货币,数字,百分比(%,)
	
	@Test
	public void otherI18NTest(){
		//货币的国际化
		//将数字转为货币的形式
		NumberFormat format = 
				NumberFormat.getCurrencyInstance(Locale.US);
		String str = format.format(123.8);
		System.out.println("货币:"+str);
		
		try {
			//将货币转为数字
			String money="$300";
			Number number = format.parse(money);
			System.out.println(number.doubleValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void numberI18NTest(){
		//数字的国际化.目前基本上所有国家采用的都是阿拉伯数字风格.
		NumberFormat instance = 
				NumberFormat.getNumberInstance(Locale.US);
		String num = instance.format(123.78964);
		System.out.println("数字:"+num);
	}

}
