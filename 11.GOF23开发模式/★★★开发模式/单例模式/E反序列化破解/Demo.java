/**
 * 用反序列化的方式破解单例模式
 */
package E反序列化破解;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class  Demo{
	public static void main(String[] args) throws Exception {
		 MyJvm s1 = MyJvm.getInstance();
		 MyJvm s2 = MyJvm.getInstance();
		 System.out.println(s1);
		 System.out.println(s2);
		 
		 //通过对象序列化  和反序列化构架多个对象
		 
		//序列化
		 FileOutputStream fos = new FileOutputStream("d://a.txt");
		 ObjectOutputStream oos = new ObjectOutputStream(fos);
		 oos.writeObject(s1);
		 oos.close();
		 fos.close();
		 
		 //反序列化
		 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d://a.txt"));
		 MyJvm s3 = (MyJvm) ois.readObject();
		 System.out.println(s3);
		 
	}
}



