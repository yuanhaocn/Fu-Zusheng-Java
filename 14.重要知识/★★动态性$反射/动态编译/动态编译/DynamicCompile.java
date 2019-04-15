package 动态编译;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * java6.0引入了动态编译机制
 * 动态编译的应用场景：
 * 	可以做一个浏览器端编写Java代码，上传服务器编译和运行的在线评测系统
 * 	服务器动态加载某些类文件进行编译
 * 动态编译的两种做法：
 * 	通过Runtime调用javac，启动新的进程去操作
 * 		Runtime run Runtime.getRuntime();
 * 		process process =run.exec("javac -cp d:/myjava/ HelloWorld.java");
 *
 * 通过javaCompiler动态编译
   		public static int compileFile(String sourceFile) {
		//动态编译
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, sourceFile);
		System.out.println(result==0?"编译成功":"编译失败");
		return result;
	}
compiler.run(in, out, err, arguments)
	第一个参数：为Java编辑器提供参数
	第二个参数：得到Java编辑器的输出信息
	第三个参数：接收编译器的错误信息
	第四个参数：可变参数（是一个String数组）能传入一个或者多个Java源文件
	返回值：0表示 
 *
 */
public class DynamicCompile {

/*run(InputStream in, OutputStream out, OutputStream err, String... arguments)
 * Parameters:
 * in "standard" input; use System.in if null
 * out "standard" output; use System.out if null
 * err "standard" error; use System.err if null
 * arguments arguments to pass to the tool
 */
	public static int compileFile(String sourceFile) {
		//获得一个动态编译
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, sourceFile);
		System.out.println(result==0?"编译成功":"编译失败");
		return result;
	}
	
	public static void main(String[] args) throws Exception {
	//	compileFile("d:/myjava/HelloWorld.java");
		//用这个字符串调用compileFile实现动态编译
		//可以通过IO流操作，将字符串存储成一个临时文件，然后调用动态编译方法
String str = "public class Hi{public static void main(String[] args) {System.out.println(\"Hello world\")}}";
		
		
		//这个是通过Runtime.getRuntime();方法启动一个新的进程
		Runtime run = Runtime.getRuntime();
		Process process =run.exec("javac -cp D://myjava//HelloWorld.java");
		
		
		
		InputStream is = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String info="";
		while((info=reader.readLine())!=null) {
			System.out.println(info);
		}
	}
}
