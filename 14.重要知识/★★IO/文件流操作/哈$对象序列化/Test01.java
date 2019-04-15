package 哈$对象序列化;
/**
 * 对象序列化输出
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test01 {
	public static void main(String[] args) {
	File file = new File("C://Users//FZS//Pictures//fzs.txt");	
	//构建一个对象
	book book = new book(1,"傅祖升de传奇",13.14,"fzs·lzy");
	
	try (//构建文件输出流
		FileOutputStream fos = new FileOutputStream(file);
		//根据文件输出流构建对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(fos);){
		oos.writeObject(book);
		oos.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
