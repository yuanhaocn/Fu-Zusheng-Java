package B$队列流;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.SequenceInputStream;

public class SequenceInputStream1 {
	public static void main(String[] args) {
		//根据文件对象构建输入流
		File file1 = new File("C://Users//FZS//Pictures//诛仙1.txt");
		File file2 = new File("C://Users//FZS//Pictures//诛仙2.txt");
		//根据文件对象 构建文件输入流
		try(FileInputStream fis01 = new FileInputStream(file1);
			 FileInputStream fis02 = new FileInputStream(file2);
			//使用缓冲流包装两个文档输入流
			BufferedInputStream bis01 = new BufferedInputStream(fis01);
			BufferedInputStream bis02 = new BufferedInputStream(fis02);
			SequenceInputStream sis = new SequenceInputStream(bis01,bis02);	) {
			//构建一个接收数据的byte数组
			byte[] bytes = new byte[1024];
			int capacity=0;
			
			while((capacity=sis.read(bytes))!=-1) {
				System.out.println(new String(bytes,0,capacity));
			}} catch (Exception e) {}}}
