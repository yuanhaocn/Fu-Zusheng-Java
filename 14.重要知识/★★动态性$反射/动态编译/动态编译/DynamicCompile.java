package ��̬����;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * java6.0�����˶�̬�������
 * ��̬�����Ӧ�ó�����
 * 	������һ��������˱�дJava���룬�ϴ���������������е���������ϵͳ
 * 	��������̬����ĳЩ���ļ����б���
 * ��̬���������������
 * 	ͨ��Runtime����javac�������µĽ���ȥ����
 * 		Runtime run Runtime.getRuntime();
 * 		process process =run.exec("javac -cp d:/myjava/ HelloWorld.java");
 *
 * ͨ��javaCompiler��̬����
   		public static int compileFile(String sourceFile) {
		//��̬����
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, sourceFile);
		System.out.println(result==0?"����ɹ�":"����ʧ��");
		return result;
	}
compiler.run(in, out, err, arguments)
	��һ��������ΪJava�༭���ṩ����
	�ڶ����������õ�Java�༭���������Ϣ
	���������������ձ������Ĵ�����Ϣ
	���ĸ��������ɱ��������һ��String���飩�ܴ���һ�����߶��JavaԴ�ļ�
	����ֵ��0��ʾ 
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
		//���һ����̬����
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, sourceFile);
		System.out.println(result==0?"����ɹ�":"����ʧ��");
		return result;
	}
	
	public static void main(String[] args) throws Exception {
	//	compileFile("d:/myjava/HelloWorld.java");
		//������ַ�������compileFileʵ�ֶ�̬����
		//����ͨ��IO�����������ַ����洢��һ����ʱ�ļ���Ȼ����ö�̬���뷽��
String str = "public class Hi{public static void main(String[] args) {System.out.println(\"Hello world\")}}";
		
		
		//�����ͨ��Runtime.getRuntime();��������һ���µĽ���
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
