package 啊$文件文件夹操作;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import 吧$字节读取写出.Transport;

/**
 * 文件夹的拷贝
 * 1、文件 赋值  copyFile
 * 2、文件 创建 mkdirs()
 * 3、递归查找子孙级
 */
public class CopyDir {
	public static void main(String[] args) throws IOException {
		//源目录
		String srcPath="E:/xp/test/a"; 	
		//目标目录
		String destPath="E:/xp/test/a/b";
			Transport.copyFile(srcPath,destPath);
		
	}
	/**
	 * 拷贝文件夹
	 * @param src 源路径
	 * @param dest 目标路径
	 * @throws IOException 
	 */
	public static void copyDir(String  srcPath,String destPath) throws IOException{
		File src=new File(srcPath);
		File dest =new File(destPath);
		copyDir(src,dest);		
	}
	/**
	 * 拷贝文件夹
	 * @param src 源File对象
	 * @param dest 目标File对象
	 * @throws IOException 
	 */
	public static void copyDir(File src,File dest) throws IOException{
		if(src.isDirectory()){ //文件夹
			dest =new File(dest,src.getName());			
		}		
		copyDirDetail(src,dest);
	}
	
	/**
	 * 拷贝文件夹细节
	 * @param src
	 * @param dest
	 * @throws IOException 
	 */
	public static void copyDirDetail(File src,File dest) throws IOException{
		if(src.isFile()){ //文件
				Transport.copyFile(src, dest);
		}else if(src.isDirectory()){ //文件夹
			//确保目标文件夹存在
			dest.mkdirs();
			//获取下一级目录|文件
			for(File sub:src.listFiles()){
				copyDirDetail(sub,new File(dest,sub.getName()));
			}
		}
	}
}
