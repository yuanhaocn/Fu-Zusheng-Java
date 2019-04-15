package B$队列流;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;
/**
 * 代码实现三个文件的合并输出以及文件合并
 *
 */
public class SequenceInputStream2 {
	public static void main (String[] args) throws Exception {
		//获取枚举的引用，构建Vector
		Vector<InputStream> vector = new Vector<InputStream>();
		//构建三个文件缓冲输入流，存进集合
		File file1 = new File("C://Users//FZS//Pictures//诛仙1.txt");
		File file2 = new File("C://Users//FZS//Pictures//诛仙2.txt");
		File file3 = new File("C://Users//FZS//Pictures//诛仙3.txt");
		//根据文件对象 构建文件输入流
		FileInputStream fis01 = new FileInputStream(file1);
		FileInputStream fis02 = new FileInputStream(file2);
		FileInputStream fis03 = new FileInputStream(file3);
		//使用缓冲流包装两个文档输入流
		BufferedInputStream bis01 = new BufferedInputStream(fis01);
		BufferedInputStream bis02 = new BufferedInputStream(fis02);
		BufferedInputStream bis03 = new BufferedInputStream(fis03);
		//把三個缓冲流写入集合
		vector.add(bis01);
		vector.add(bis02);
		vector.add(bis03);
		//调用集合的elements方法，获取枚举的引用
		Enumeration<InputStream> elements = vector.elements();
		//根据枚举的引用构建队列流对象
		SequenceInputStream sis = new SequenceInputStream(elements);
		
		byte[] bytes = new byte[1024];
		int capacity=0;
		//定义文件输出流对象，并使用缓冲流包装
		File fileTarget=new File("C://Users//FZS//Pictures//合集.txt");
		FileOutputStream fos = new FileOutputStream(fileTarget);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
	
		while((capacity=sis.read(bytes))!=-1) {
			System.out.println(new String(bytes,0,capacity));
			bos.write(bytes,0,capacity);
		}
		bos.flush();
		
	
	}
}
