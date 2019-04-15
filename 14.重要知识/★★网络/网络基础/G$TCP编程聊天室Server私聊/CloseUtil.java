package G$TCP编程聊天室Server私聊;

import java.io.Closeable;

/**
 * 关闭流的方法
 * @author Administrator
 *
 */
public class CloseUtil {
	public static void closeAll(Closeable... io){
		for(Closeable temp:io){
			try {
				if (null != temp) {
					temp.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
