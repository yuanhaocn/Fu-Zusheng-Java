package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {
	
	static Properties props;

	static {
		// 1.创建Properties对像
		props = new Properties();
		// 2.创建输入流，读取db.properties文件
		InputStream is = Props.class.getResourceAsStream("db.properties");
		// 3.加载到Properties对像中
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String findValByKey(String key) {

		return props.getProperty(key);
	}

	
}
