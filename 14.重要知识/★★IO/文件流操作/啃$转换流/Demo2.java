package 啃$转换流;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo2 {
	public static void main(String[] args) {
	 try (	// 构建文件输入流对象
			 FileInputStream fis = new FileInputStream("C:\\Users\\FZS\\Pictures\\诛仙1.txt");
			// 使用文件输入流对象构建转换流	
			 InputStreamReader isr = new InputStreamReader(fis);){
		 //构建转换流需要的字符数组
		 char[] chars=new char[1024];
		 //定义变量接受有效读取字符个数
		 int capacity=0;
			//构建循环,条件和之前一样
		while((capacity=isr.read(chars))!=-1) {
				//使用数组构建字符串
			System.out.print(new String(chars,0,capacity));
		}
		 
	} catch (Exception e) {
	}
	}
}
