package com.syc.oa.util;

import java.util.Properties;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

/**
 * 给密码password解密后重新赋值
 * @类名称:MyPasswordCallback
 * @创建人:一一哥
 * @创建时间:2018年3月2日 上午11:34:30
 */
public class MyPasswordCallback extends DruidPasswordCallback{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 本案例中利用公钥进行解密
	 */
	private static final String PUBLICKEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCAXWL0qGd7VWfBedzanLy5PeGdKaZHC8lcQBeXy4aks27miOoFjXmp+Wbwg2TVvML4PSzlS+L2NQrfD04BSyJQ0655P7DKIVvfSm62nnuu10v9419508Ok6YxfmwdhHS/7WPdeF4RrqtAOy7bZ2oKBZIm7QBV6r3sbhmBd6y2/5wIDAQAB";
	
	/**
	 * 重新给Properties属性赋值的方法
	 */
	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		String pwd = properties.getProperty("password");
		if(pwd!=null){
			try {
				//得到解密后的明文
				String decrypt = ConfigTools.decrypt(PUBLICKEY, pwd);
				//System.out.println("明文密码="+decrypt);
				//用明文的密码,重新给密码属性赋值
				setPassword(decrypt.toCharArray());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
