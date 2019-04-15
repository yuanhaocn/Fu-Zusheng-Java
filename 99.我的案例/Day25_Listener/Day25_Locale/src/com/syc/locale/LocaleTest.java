package com.syc.locale;

import java.util.Locale;

import org.junit.Test;

//学习关于本地化的ＡＰＩ
public class LocaleTest {

	@Test
	public void localeTest(){
		//获取默认的本地化设置
		Locale locale = Locale.getDefault();
		
		//Locale locale=Locale.FRANCE;
		
		//获取的是当前默认的国家简称
		String country = locale.getCountry();
		//获取默认的国家名称
		String displayCountry = locale.getDisplayCountry();
		//当前所使用的语言
		String language = locale.getLanguage();
		//获取语言+国家
		String displayName = locale.getDisplayName();
		System.out.println("国家简称:"+country);
		System.out.println("国家名称:"+displayCountry);
		System.out.println("语言:"+language);
		System.out.println("语言国家:"+displayName);
	}
}
