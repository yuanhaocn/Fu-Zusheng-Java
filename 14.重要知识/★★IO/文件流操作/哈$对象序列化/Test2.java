package 哈$对象序列化;
/**对象序列化输入
 *读取文档中的对象 
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test2 {
	public static void main(String[] args) {
		File file = new File("C://Users//FZS//Pictures//fzs.txt");
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			Object ro = ois.readObject();
			if(ro instanceof book) {
				book book=(book) ro;
				System.out.println(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
