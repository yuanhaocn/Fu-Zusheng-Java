package 叫$打印流;
/**
 * 	Scanner：
		扫描器:扫描操作是线程阻塞，而等待用户的输入如果用户不输入，一致处于阻塞状态，结束阻塞的标志是回车或者是用户输入的空格
	
11.Scanner的构造方法
	Scanner(InputStream source)  构造一个新的 Scanner，它生成的值是从指定的输入流扫描的。
	代码：
		//用户的输入是输入流对象	Scanner sc = new Scanner(System.in);
		String input = sc.next();//next本质是迭代器的扫描功能
	结论：	
		next并不是用来做输入字符的，而是进行扫描用户的输入的
		next扫描字符串，nextInt扫描整型
		
Scanner的迭代器读取文档
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo2 {
	 public static void main(String[] args) throws FileNotFoundException {
			// 获取打印流
			PrintStream psConsole = System.out;
			// 是在控制台打印hello
			psConsole.println("hello");
			//获取打印流对象
			System.out.println(psConsole);

			// *************************************
			File file = new File("C://Users//FZS//Pictures//诛仙5.txt");
			PrintStream psFile = new PrintStream(file);
			//是在文档里面写入hello
			psFile.println("hello");
	 }
}
