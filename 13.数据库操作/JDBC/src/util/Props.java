package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {
	
	static Properties props;

	static {
		// 1.����Properties����
		props = new Properties();
		// 2.��������������ȡdb.properties�ļ�
		InputStream is = Props.class.getResourceAsStream("db.properties");
		// 3.���ص�Properties������
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
