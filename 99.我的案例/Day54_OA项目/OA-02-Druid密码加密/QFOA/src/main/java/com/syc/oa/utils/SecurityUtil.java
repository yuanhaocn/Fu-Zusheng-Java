package com.syc.oa.utils;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * 利用公钥进行解密的工具类
 * @类名称:SecurityUtil
 * @创建人:SYC
 * @创建时间:2017年11月1日 下午4:53:06
 */
public class SecurityUtil {

	// 上述生成的私钥
	private static final String PRIVATE_KEY_STRING = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANUYUXwF3t4JRLEshvAkGIWSYCSBaY9yIlIFSRPo1YqvoPXJBfOMTx7fvDPtfurU2UDWM/GAkJ0dCu1SHfN6X6XskmTpS51QOndK6Bz3tE+WvTZDKa7B4Vk1r5nBUsYR/yRpRKGMYRE7dRB7B/6N13+i0WtX3KyXbWch78RPcRmvAgMBAAECgYALRropIfZlMYBdD8okMwTJLLHBvMdlO9jtFjKDxzJloF2YJAcYmDgnnhdLeCnbK2BDuhINmYwNhFfrrwi+tZ8SA+6w/W0/b8CRZW9HKLvzOI93JTKXXzpPSUdt9S1y6yKcVVuhCHutMC5JW2nzssuWGy7TpvJMvHrmjMl2q3hY4QJBAPWVMWdDpS2qke9xdqXLjDF/4lfwLjEkaX8Lf1Z2EUFKGLhkWnu5AWn3xb3vgowMWKez3V1Csx8xi1dvim+QQtUCQQDeIlZXWM9QVCqZIBdoamP8OFR137KgjvvZk+tsrXSyxZ68/CbfSzkqszaI4jhVtA35RmNUOENgo5H/DuHQmMRzAkBJbk7TXbqqKPJx8i9T68UDmAWJ3dsx/n0866crpyoJp6o0mG0lyW/Oy7No05DpZ1eq7XEnTaZZkWrkvglaynvxAkEAgCNUpSxg4ti6ffxqJFyC8uLXrett0nrIw1k1zEo+8EVZbXETR2nQP1aEFfBRSPcFvI8jC1ktXNjehkBieP83CwJAOufJsY+y7fQP2o9xAAzKo08HGUfjTYS3/b+UheO1pmw2QJQKPNaleZOMESM5XgvKcobySXOQnl6DmSsw6KpYBA==";
	
	/**
	 * 生成密码的加密方法;
	 * pwd:密码的明文.
	 * 注意:RSA算法中,正常情况下是用公钥进行加密,用私钥进行解密,但是因为阿里的ConfigTools类内部
	 * 利用的IBM提供的算法不支持这样加解密,需要将公钥与私钥对调才可以.
	 */
	public static String encryptDes(String pwd){
		try {
			return ConfigTools.encrypt(PRIVATE_KEY_STRING, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String pwd = encryptDes("syc");
		System.out.println(pwd);
	}
}
