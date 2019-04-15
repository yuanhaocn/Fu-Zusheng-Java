package 叫$打印流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * System.out.prinlln()-->PrintStream.println()
 * 为其他输出流
 *printStream针对控制台
 *FileOutputStream针对文件
 *
 *结论 ：该流具有绕过文件操作流直接操作文件的可能，底层的流可以直接操作
 *
 */
public class Demo {
	 public static void main(String[] args) throws Exception {
		//获取PrintStream对象
	 PrintStream ps = new PrintStream(new File("C:\\Users\\FZS\\Pictures\\诛仙5.txt"));
		 //调用write方法
		ps.write("helloworld".getBytes());
		 ps.flush();
	}
}
