package 哈希Map;
/**
 * TreeMap一般是更具key进行排序，所以key一般是数值类型
 */
import java.util.TreeMap;

public class TestTreeMap {

	public static void main(String[] args) {
	TreeMap<Integer,Integer> treeMap = new TreeMap<>();
	treeMap.put(1, 17);
	treeMap.put(2, 13);
	treeMap.put(3, 67);
	treeMap.put(4, 176);
	treeMap.put(-1, 78);
	treeMap.put(-7, 454);
	System.out.println(treeMap);
		
	}

}
