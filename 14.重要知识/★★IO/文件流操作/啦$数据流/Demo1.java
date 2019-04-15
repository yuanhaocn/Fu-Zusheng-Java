package 啦$数据流;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 *文件输出流 new DataOutputStream(new FileOutputStream(new File(c://fzs.txt)));
 *数据可以写出，但是程序员无法看懂
 */
public class Demo1 {
	public static void main(String[] args) {
		//构建文件输出流
		//根据文件输出流构建数据输出流
		try(FileOutputStream fos = new FileOutputStream("C:\\Users\\FZS\\Pictures\\诛仙5.txt");
				DataOutputStream dos = new DataOutputStream(fos);) {
			//写出int类型
			/*dos.writeInt(10);
			dos.writeDouble(13.14);*/
			dos.writeUTF("fzs傅祖升");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
