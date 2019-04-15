package 哈希Set$LinkedHashSet;
/**
 * LinkedList只去重不排序
 */
import java.util.LinkedHashSet;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		set.add(-2);
		set.add(3);
		set.add(5);
		set.add(0);
		set.add(9);
		set.add(4);
		set.add(4);
		System.out.println(set);
		
	}

}
