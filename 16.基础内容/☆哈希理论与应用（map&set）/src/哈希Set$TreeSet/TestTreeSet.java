package ��ϣSet$TreeSet;
import java.util.Comparator;
//�����������Ͱ�װ���������,���ݵ��Ƕ���������
import java.util.TreeSet;
/**�����������Ƚ���
 *TODO �Ƚ���
 *�Ƚ�����ʵ��Comparator +��дCompare������û�ˣ�����û�ˣ�����Щ��
 */
 class XiaoSan implements Comparator<Book> {
//��book1��book2���бȽ�����
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
		//�����Ľ���һ���Ƚ��������ݶ����ĳЩ���������ȥ�أ�
		//���Զ��塱������
		TreeSet<Book> ts2 = new TreeSet<>(new XiaoSan());
		ts2.add(new Book("fzs",12));
		ts2.add(new Book("fzs",87));
		ts2.add(new Book("fzs",32));
		ts2.add(new Book("lzy",32));//�ظ� ����compareTo�����������ȥ��
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
		ts.add(-9.5);//�ظ�
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




