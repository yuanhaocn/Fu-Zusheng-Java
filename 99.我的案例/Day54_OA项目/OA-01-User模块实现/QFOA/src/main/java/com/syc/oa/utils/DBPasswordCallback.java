package com.syc.oa.utils;

import java.util.Properties;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

/**
 * 自定义的Druid密码回调类
 * @类名称:DBPasswordCallback
 * @创建人:SYC
 * @创建时间:2017年11月1日 下午4:51:02
 */
public class DBPasswordCallback extends DruidPasswordCallback {

	private static final long serialVersionUID = 1L;

	// 上述生成的公钥
	public static final String PUBLIC_KEY_STRING = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVGFF8Bd7eCUSxLIbwJBiFkmAkgWmPciJSBUkT6NWKr6D1yQXzjE8e37wz7X7q1NlA1jPxgJCdHQrtUh3zel+l7JJk6UudUDp3Sugc97RPlr02QymuweFZNa+ZwVLGEf8kaUShjGERO3UQewf+jdd/otFrV9ysl21nIe/ET3EZrwIDAQAB";
	
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		String pwd = properties.getProperty("password");
		if (pwd != null) {
			try {
				// 这里的password是将jdbc.properties配置得到的密码进行解密之后的值,
				// 所以这里的代码是将密码进行解密.
				String password = ConfigTools.decrypt(PUBLIC_KEY_STRING, pwd);
				setPassword(password.toCharArray());
				//System.out.println("pwd="+pwd);
			} catch (Exception e) {
				setPassword(pwd.toCharArray());
			}
		}
	}
	
}
