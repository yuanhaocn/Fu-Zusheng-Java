package 哒$缓冲流;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 字符缓冲流 +新增方法(不能发生多态)
 */
public class BufferedCharDemo {
	public static void main(String[] args) {
		//创建源 仅限于 字符的纯文本
		File src =new File("E:/xp/test/Demo03.java");
		File dest =new File("e:/xp/test/char.txt");
		//选择流
		try (BufferedReader	reader =new BufferedReader(new FileReader(src));
				BufferedWriter	wr =new BufferedWriter(new FileWriter(dest));){
			/*//读取操作
			char[] flush =new char[1024];
			int len =0;
			while(-1!=(len=reader.read(flush))){
				wr.write(flush, 0, len);
			}*/
			String line =null;
			while(null!=(line=reader.readLine())){	//新增方法的操作一次读取一行
				wr.write(line);
				//wr.append("\r\n");
				wr.newLine(); //换行符号
			}
			wr.flush();//强制刷出
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
