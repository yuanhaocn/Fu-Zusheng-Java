package listʵ��;

import java.util.HashSet;
import java.util.Set;

/**
 * ����set�ĳ��÷���
 * @author FZS
 *ֻҪ������HashSet
 */
public class TestSet {
	public static void main(String[] args) {
		Set s = new HashSet();
		s.add("hello");
		s.add(1);
		s.add(3.14);
		s.add(new Integer(4));
		s.add(new Double(1.2));
		s.add("hello");
		System.out.println(s.size() + "��Ԫ�ء�");
		System.out.println(s);
	}
}
