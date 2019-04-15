package 吧$字节读取写出;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件的读取
 *  1、建立联系   File对象
	2、选择流     文件输入流  InputStream FileInputStream
	3、操作  : byte[] car =new byte[1024];  +read+读取大小
              输出
	4、释放资源 :关闭
 * @author FZS
 *
 */
public class TestRead {

	public static void main(String[] args) {
		//1、建立联系   File对象
		File src = new File("C:\\Users\\FZS\\Pictures\\123.txt");
//		2、选择流     文件输入流  InputStream FileInputStream
		InputStream is = null;//提升作用域
		try {
			 is = new FileInputStream(src);//只要与外界存在联系就会有异常
//			3操作不断读取，构建一个缓冲数组
			 byte[] car = new byte[10];
			 int len = 0;//实际读取大小
			 //循环读取
			 
//***************************************************************************//
			 try {
				 
				while(-1!=(len=is.read(car))) {
					 //输出，字节数组转成字符串
					String info = new String(car,0,len);
					System.out.println(info);
				 }
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("文件不存在");
			}
			 
//***************************************************************************//			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
		}finally {
			//4、释放资源
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭文件输入流失败");
				}
			}
			
		}
		
	}

}
