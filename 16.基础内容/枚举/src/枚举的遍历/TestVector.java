package 枚举的遍历;
/**
 * Vector使用枚举遍历和迭代器遍历
 */
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class TestVector {

	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.add("hello");
		vector.add("spring");
		vector.add("struts");
		vector.add("mybatis");
		vector.add("siri");
		//枚举遍历，不能边遍历边删除，应为枚举里面的值只有静常量,常用因为Vector是向量
		Enumeration<String> elements = vector.elements();
		while(elements.hasMoreElements()) {
			String nextElement = elements.nextElement();
			System.out.println(nextElement);
		}
		
		//迭代器遍历
		Iterator<String> iterator = vector.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
