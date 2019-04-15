package 吧$字节读取写出;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 文件的操作
 * @author FZS
 */
public class Transport {
	public static void main(String[] args)  {
		//1、建立联系   File对象 的源头和 目的地-----》建立两个联系
		//源头,文件必须存在，且必须是文件不能时文件夹
		String src =  "E:/xp/test/1.jpg";
		//目的地，文件可以不存在
		String dest = "E:/xp/test/100.jpg";
		try {
			copyFile(src,dest);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("拷贝文件失败|关闭流失败");
		}
	}
	/**
	 * 文件的拷贝方法
	 * @param 源文件路径
	 * @param 目标文件的路径
	 * @throws
	 * @return
	 */
	public static   void copyFile(String srcPath,String destPath) throws IOException  {
		copyFile(new File(srcPath),new File(destPath));
	}
	/**
	 * 文件的拷贝方法
	 * @param 源文件File对象
	 * @param 目标文件的File对象
	 * @throws
	 * @return
	 */
	public static   void copyFile(File src ,File dest)  throws IOException  {
		if(! src.isFile()) {	//不是文件或者为null
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		//2、选择流两个流     
		// 文件输入流  InputStream FileInputStream
	    //文件输出流  OutputStream FileOutputStream
		 InputStream is = new FileInputStream(src);
		 OutputStream os = new FileOutputStream(dest);
		 //3.文件的拷贝，循环+读取+写出
		 byte[] flush = new byte[1024];	//1024个字节数
		 //定义接收长度
		 int len = 0;
		 //循环读取
		 while (-1!=(len=is.read(flush))) {
			//写出 ，用os流
			 os.write(flush, 0, len);//推荐使用这个，因为最后一个可能读不满，有空的
		}
		 os.flush();		//加上一个flush强制刷出，防止驻留
		 //关闭流，一般规则是，先打开的后关闭
		 os.close();
		 is.close();
	}
}
