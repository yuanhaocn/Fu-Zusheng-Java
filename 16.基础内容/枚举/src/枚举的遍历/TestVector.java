package ö�ٵı���;
/**
 * Vectorʹ��ö�ٱ����͵���������
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
		//ö�ٱ��������ܱ߱�����ɾ����ӦΪö�������ֵֻ�о�����,������ΪVector������
		Enumeration<String> elements = vector.elements();
		while(elements.hasMoreElements()) {
			String nextElement = elements.nextElement();
			System.out.println(nextElement);
		}
		
		//����������
		Iterator<String> iterator = vector.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
