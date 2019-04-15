package 啃$转换流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字节字符转换流
 *
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println("小哥，来点文字呗");
		//构建转换流对象，需求是输入，这里使用System.in
		InputStreamReader isr = new InputStreamReader(System.in);
		//构架char 类型的数组
		char[] chars =new char[1024];
		//读取用户输入
		try {
			int capacity = isr.read(chars,0,chars.length);
			//打印用户输入的字符串,使用capacity截取有效长度
			System.out.println(new String(chars,0,capacity));
		} catch (IOException e) {e.printStackTrace();}}}
