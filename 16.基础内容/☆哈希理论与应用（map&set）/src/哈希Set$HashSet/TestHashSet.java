package 哈希Set$HashSet;
/**
 * hashSet测试去重和有序性
 * 以及对基本数据类型以及String类型的默认排序
 */
import java.util.HashSet;

public class TestHashSet {

	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(4);
		hashSet.add(2);
		hashSet.add(1);
		hashSet.add(0);
		System.out.println(hashSet);
		
	}

}
