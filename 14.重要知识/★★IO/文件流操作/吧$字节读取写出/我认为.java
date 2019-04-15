package 吧$字节读取写出;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class 我认为 {
	public static void main(String[] args) {
	
		byte[] bytes=new byte[1024];//一个瓢
		int capacity=0;				//记录瓢里面的水
		/*
		 * 源头桶+目标桶+自动关闭
		 * 	
		 * 在1.8上我们对流关闭进行了扩充
		 * 在try小括号里面定义的流会在使用完之后，自动关闭
		 * 使用的是和jvm的对其唤醒机制
		 */
		 
		try(FileInputStream is = new FileInputStream("d://fzs.txt");
			FileOutputStream os = new FileOutputStream("d://fzs.txt");
			) {
			
			is.read(bytes);		//舀水进瓢,返回值是瓢里面的容量
			os.write(bytes);	//把瓢中的水倒入目标桶
			os.flush();		//倒干净
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
