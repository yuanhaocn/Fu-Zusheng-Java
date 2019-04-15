package 啃$转换流;

import java.io.IOException;
import java.io.InputStreamReader;

public class Test02 {
	public static void main(String[] args) {
		System.out.println("请输入一个字符。。。");
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			/*
			 * read方法只接受一个字符 返回值是int类型
			 * 代表输入的字符的ascii码
			 * 因此下面可以使用强制类型转换
			 */
			int number = isr.read();
			System.out.println((char) (number));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
