package 哈希Set$HashSet;
/**
 * HashSet对对象的去重研究
 */
import java.util.HashSet;

public class TestHashSet03 {
	public static void main(String[] args) {
//		initialSort();//在HashSet中默认对对象的去重排序
		//重写了Student的equals 和hashCode方法，达到根据对象某些属性去重的效果，（自定义去重），依哈希码排序
		HashSet<Student> hashSet= new HashSet<>();
		hashSet.add(new Student("fzs"));
		hashSet.add(new Student("lzy"));
		hashSet.add(new Student("son"));
		hashSet.add(new Student("daughter"));
		hashSet.add(new Student("son"));
		hashSet.add(new Student("daughter"));
		System.out.println(hashSet);
		
	}
	
	 //加入set集合的对象会根据对象的hashCode()进行从大到小排序并且根据hashCode的值去重
	public static void initialSort() {

		HashSet<Student> hashSet= new HashSet<>();
		Student e = new Student("fzs");
		hashSet.add(e);
		System.out.println("fzs"+e.hashCode());
		Student e2 = new Student("lzy");
		hashSet.add(e2);
		System.out.println("lzy"+e2.hashCode());
		Student e3 = new Student("son");
		hashSet.add(e3);
		System.out.println("son"+e3.hashCode());
		Student e4 = new Student("daughter");
		hashSet.add(e4);
		System.out.println("daughter"+e4.hashCode());

		System.out.println(hashSet);
		
	
	}

}

//用来构建对象的，没什么特别的,重写hashCode和equals方法为的是hashSet根据对象属性去重
class Student {	
	private String name;//构造器访问器都在最下面
	@Override
	public int hashCode() {
		System.out.println("hashCode调用了一次");
		/*你想那个属性相等时发生碰撞就构造和他们相关的值作为哈希值
		 */
		return  name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals调用了一次");
		if(obj instanceof Student) {
			Student stu=(Student)obj;
			return this.getName().equals(((Student) obj).getName());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]\n";
	}
	
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		public String getName() {
		return name;
	}
	public Student(String name) {
		this.name = name;
	}

}







