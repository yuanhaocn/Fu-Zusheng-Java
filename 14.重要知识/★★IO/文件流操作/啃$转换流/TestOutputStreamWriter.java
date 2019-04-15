package 啃$转换流;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * 转换流OutputStreamWriter
 * 这个流是字符流通向字节流的桥梁
 * 最大的用处是接收系统输出，接收Scanner的输入转为字节
 * 
 */
public class TestOutputStreamWriter {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		//构建字符转换流+构建打印字节流作为参数
		try(OutputStreamWriter osw = new OutputStreamWriter(ps);) {
			osw.write("hello world");
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
