package list实现;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试set的常用方法
 * @author FZS
 *只要理解会用HashSet
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
		System.out.println(s.size() + "个元素。");
		System.out.println(s);
	}
}
