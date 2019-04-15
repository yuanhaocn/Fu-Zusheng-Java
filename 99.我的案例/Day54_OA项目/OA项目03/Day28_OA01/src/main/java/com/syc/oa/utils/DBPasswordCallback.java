package com.syc.oa.utils;

import java.util.Properties;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

/**
 * 利用公钥进行解密的工具类
 */
public class DBPasswordCallback extends DruidPasswordCallback {

	private static final long serialVersionUID = 1L;

	// 利用公钥进行解密
	private static final String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCs7SwJJzfJwEm2LzBw/QmJvqjwvQdC1YE1z7HokG2yR7AHt04QQv/ztc/C4hpgS4dWovVLDwh1OjVonBsW37abGV0wCxjJzeR+AuMVL3zCPZF73aSbuXn42/xpEAz3enF/Q7sawzhBlsPs9EmRBwqge927FNDhAz60FPc2fdyaxQIDAQAB";

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		String pwd = properties.getProperty("password");
		if (pwd != null) {
			try {
				//得到明文
				String decrypt = ConfigTools.decrypt(PUBLICKEY, pwd);
				//重新设置密码
				setPassword(decrypt.toCharArray());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
