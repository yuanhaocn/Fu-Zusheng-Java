package 哈希Set$TreeSet;
import java.util.Comparator;
//基本数据类型包装类可以排序,根据的是二叉排序树
import java.util.TreeSet;
/**构建第三方比较器
 *TODO 比较器
 *比较器：实现Comparator +重写Compare方法，没了，绝对没了，就这些了
 */
 class XiaoSan implements Comparator<Book> {
//对book1和book2进行比较排序
	@Override
	public int compare(Book book1, Book book2) {
		if (book1.getNum()>book2.getNum()) {
			return -1;
		} else if(book1.getNum()<book2.getNum()){
			return 1;
		}
		return 0;
	}

}
 
public class TestTreeSet {
		public static void main(String[] args) {
//#################################################################################################################################################
		//独立的建造一个比较器，根据对象的某些属性排序和去重，
		//“自定义”！！！
		TreeSet<Book> ts2 = new TreeSet<>(new XiaoSan());
		ts2.add(new Book("fzs",12));
		ts2.add(new Book("fzs",87));
		ts2.add(new Book("fzs",32));
		ts2.add(new Book("lzy",32));//重复 根据compareTo定义的排序法则去重
		System.out.println(ts2);
//#################################################################################################################################################
		//	TestDouble();
		//	TestAll();
			
	}

	public static void TestDouble() {
				TreeSet<Double> ts = new TreeSet<>();
		ts.add(99.0);
		ts.add(9.0);
		ts.add(-9.5);
		ts.add(19.1);
		ts.add(49.6);
		ts.add(29.0);
		ts.add(99.8);
		ts.add(69.0);
		ts.add(-9.5);//重复
		System.out.println(ts);
	}
	
	public static  void TestAll() {
			TreeSet<String> ts1 = new TreeSet<>();
		ts1.add("  ");
		ts1.add("99.0");
		ts1.add("99.0");
		ts1.add("Ain");
		ts1.add("Din");
		ts1.add("Fin");
		ts1.add("a");
		ts1.add("b");
		ts1.add("zin");
		ts1.add("fzs");
		System.out.println(ts1);	
	}


}




