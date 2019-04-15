package 哈希Map;
import java.util.Collection;
/**
 * 类名和方法名不能一样！！！不能，会错的
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Map遍历 {
	public static void main(String[] args) {
		HashMap<Integer,Student> map = new HashMap<>();
		map.put(1,new Student("fzs"));
		map.put(2,new Student("lzy"));
		map.put(3,new Student("son"));
		map.put(4,new Student("daughter"));
		Student stu = map.remove(4);
		System.out.println(stu+"被删除了");
		//map.remove(key, value)
System.out.println("\n*********************toString输出map**********************************\n");

		System.out.println(map);
System.out.println("\n*********************keySet遍历map**********************************\n");
	
		/*
		 * 使用keyset()方法把map的所有的key转为set集合
		 * 返回值是set集合，支持迭代器
		 * 相当于把key变成一个集合，但是呢，value还是挂在这个key上面,使用map.get(key)依旧可以的到value
		 * 既然是一个集合了，就是Collection的子类呀，然后就可以用迭代器
		 * 进行遍历key 的值，再然后就可以顺藤摸瓜找到value ,这样就实现了。
		 * map的遍历，这里面的结构层次还是要理一理，只是用了一下set集合，但是没有破坏map结构
		 */
		Set<Integer> set = map.keySet();//-----》转换成集合
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			Student value=map.get(key);
			System.out.println(key+"  "+value);
			
		}
/*		for (Iterator iterator  = set.iterator(); iterator .hasNext();) {
			Integer integer = (Integer) iterator .next();
			
		}*/
		
System.out.println("\n*********************entrySet遍历map**********************************\n");
		//获取entrySet
		/* 使用entrySet()方法把map的所有的entry转为set集合
		 * 返回值是set集合，支持迭代器
		 * 
		 */
		Set<Entry<Integer, Student>> entrySet = map.entrySet();//---》转换成set集合
		//上一步好像能给这个集合加点东西¬_¬!
		//调用迭代器 
		Iterator<Entry<Integer, Student>> iterator2 = entrySet.iterator();
		//循环遍历
		while (iterator2.hasNext()) {
			Entry<Integer,Student> en =iterator2.next();
			System.out.println(en);
			
		}
System.out.println("\n*********************Values遍历map**********************************\n");
		/*
		 * 把map转换成Collection 然后遍历
		 */
		Collection<Student> values = map.values();
		 //使用迭代器
		Iterator<Student> iterator3 = values.iterator();
		while (iterator3.hasNext()) {
			Student student = (Student) iterator3.next();
			System.out.println(student);
		}
	}
}






















class Student {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]\n";
	}
	
}

