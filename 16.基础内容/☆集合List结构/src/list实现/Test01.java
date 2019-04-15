package list实现;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
/**容器分为Set集、List列表、Map映射 
 *Set集合：由于内部存储结构的特点，Set集合中不区分元素的顺序，不允许出现重复的元素，TreeSet容器特殊，元素放进去的时候自然
 *而然就有顺序了，Set容器可以与数学中的集合相对应：相同的元素不会被加入 List列表：由于内部存储结构的特点，List集合中区分元
 *素的顺序，且允许包含重复的元素。List集合中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素—有序，
 *可以重复 Map映射：由于内部存储结构的特点，映射中不能包含重复的键值，每个键最多只能映射一个值，否则会出现覆盖的情况(后面
 *的value值会将前面的value值覆盖掉)，Map是一种把键对象和值对象进行映射的集合，即Map容器中既要存放数据本身，也要存放关键字:
 *相同的元素会被覆盖 
 *注意：对于Set和Map来说,元素放进去之后是没有顺序的，如果希望元素放进去之后是有顺序的，可以用treeSet和treeMap存储数据。 
 * 测试List中的基本方法
 * @author FZS
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
	//	ArrayList底层实现是数组，所以查询快 修改插入删除慢，线程不安全，效率高
	//LinkedList 底层实现是链表，所以查询慢，修改删除插入快，线程不安全，效率高
	//Vector：线程安全的效率低
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);	//包装类的自动装箱
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	//	list.remove("aaa");
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		System.out.println(list.size());
		String ste=(String) list.get(0);
		list.add(1, "ababab");
		list.remove(1);
	}
	
}

class Dog{}