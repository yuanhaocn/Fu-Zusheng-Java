package 哒$缓冲流;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 字节流文件拷贝+缓冲流 ，提高性能  缓冲流(节点流)
 * 
 */
public class BufferedByteDemo {
		public static void copyFile(String srcPath,String destPath) throws FileNotFoundException,IOException {
			//1、建立联系 源(存在且为文件) +目的地(文件可以不存在)  
			File src =new File(srcPath);
			File dest =new File(destPath);
			if(! src.isFile()){ //不是文件或者为null
				System.out.println("只能拷贝文件");
				throw new IOException("只能拷贝文件");
			}
			//2、选择流
			InputStream is =new BufferedInputStream(new FileInputStream(src));
			OutputStream os =new BufferedOutputStream( new FileOutputStream(dest));
			//3、文件拷贝   循环+读取+写出
			byte[] bytes =new byte[1024];
			int len =0;
			//读取
			while(-1!=(len=is.read(bytes))){
				os.write(bytes, 0, len);//写出
			}
			os.flush(); //强制刷出
			os.close();		//关闭流
			is.close();
		}

}
