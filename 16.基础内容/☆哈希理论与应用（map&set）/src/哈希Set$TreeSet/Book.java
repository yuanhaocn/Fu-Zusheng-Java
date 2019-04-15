package 哈希Set$TreeSet;
/**
 * 快捷键Alt + s重写hashCode 和equals，分析自动生成的内容
 * 1. 继承Cloneable接口，重写Object的clone()方法，比较与hashSet重写的clone()方法不同
 * 2.继承Comparable接口，对于向TreeSet放对象的时候会要求有排序，一般来说要求继承并重写操作，
 * 然后会根据哈希值排序
 * 但是可以用户定义,根据某个属性进行排序
 */
public class Book implements Cloneable,Comparable<Book>{
	private String name;
	private Integer num;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//是为了保证hashCode 尽可能不同，提高哈希散列的能力，降低哈碰撞的可能，提高性能
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//如果通过使用反射获得的Class类不等，也不是同一个类
		if (getClass() != obj.getClass())
			return false;
		//合适的时候返回false 采用了排除法
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", num=" + num + "]";
	}
	
	
	// 1.重写clone()方法,这样对象才能调用这个方法
	/*
	 * Object 类的 clone 方法执行特定的复制操作。
	 * 首先，如果此对象的类不能实现接口 Cloneable，则会抛出 CloneNotSupportedException。
	 * 注意，所有的数组都被视为实现接口 Cloneable。
	 * 否则，此方法会创建此对象的类的一个新实例，并像通过分配那样，
	 * 严格使用此对象相应字段的内容初始化该对象的所有字段；这些字段的内容没有被自我复制。
	 * 所以，此方法执行的是该对象的“浅表复制”，而不“深层复制”操作。
	 * Object 类本身不实现接口 Cloneable，
	 * 所以在类为 Object 的对象上调用 clone 方法将会导致在运行时抛出异常。
	 * 注意hashSet重写了clone方法，但是他是浅层复制本质相当于赋值，副本和原本哈希码相同
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// 2.继承Comparable接口，重写compaeaTo方法，用来用户自定义排序
	//不足之处是耦合型太高了，和自己形成耦合，换一个接口Comparator接口
	//--->TestTreeSet.XiaoSan.java
	@Override
	public int compareTo(Book book) {
		if(num>book.getNum()) {
			return -1;	//可以更改，用来正序和反序排列
		}else if(num<book.getNum()){
			return 1;	//可以更改，用来正序和反序排列
		}
		return 0;
	}
	
	/*
	 * 不许再这个类里面，用来解耦
	 * 单独创建一个类用来比较
	 */
/*	@Override
	public int compare(Object o1, Object o2) {
	return 0;
	}
*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Book() {
		super();
	}
	public Book(String name, Integer num) {
		super();
		this.name = name;
		this.num = num;
	}
	
	
	
}
