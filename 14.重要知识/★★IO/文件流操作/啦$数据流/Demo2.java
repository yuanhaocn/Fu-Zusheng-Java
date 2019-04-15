package 啦$数据流;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件输出合用
 *文件输入流 new DataInputStream(new FileInputStream(new File(c://fzs.txt)));
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		//包装一个DataInputStreaam对象
	
		try(	FileOutputStream fos = new FileOutputStream("C:\\Users\\FZS\\Pictures\\诛仙5.txt");
				DataOutputStream dos = new DataOutputStream(fos);
				FileInputStream fis  = new FileInputStream("C:\\Users\\FZS\\Pictures\\诛仙5.txt");
				DataInputStream dis  = new DataInputStream(fis);) {
			//第一步把基本数据类型写进文档
			dos.writeInt(12);
			dos.writeDouble(13.14);
			dos.writeBoolean(true);
			dos.writeUTF("fzs爱lzy");
			//第二步，把文档中的基本数据类型读进来
			int readInt = dis.readInt();
			double readDouble = dis.readDouble();
			boolean readBoolean = dis.readBoolean();
			String readUTF = dis.readUTF();
			//第三部 输出读入的数据
			System.out.println(readInt+"  "+readDouble+" "+readBoolean+" " +readUTF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
