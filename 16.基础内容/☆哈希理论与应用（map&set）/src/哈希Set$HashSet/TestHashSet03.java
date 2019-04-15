package ��ϣSet$HashSet;
/**
 * HashSet�Զ����ȥ���о�
 */
import java.util.HashSet;

public class TestHashSet03 {
	public static void main(String[] args) {
//		initialSort();//��HashSet��Ĭ�϶Զ����ȥ������
		//��д��Student��equals ��hashCode�������ﵽ���ݶ���ĳЩ����ȥ�ص�Ч�������Զ���ȥ�أ�������ϣ������
		HashSet<Student> hashSet= new HashSet<>();
		hashSet.add(new Student("fzs"));
		hashSet.add(new Student("lzy"));
		hashSet.add(new Student("son"));
		hashSet.add(new Student("daughter"));
		hashSet.add(new Student("son"));
		hashSet.add(new Student("daughter"));
		System.out.println(hashSet);
		
	}
	
	 //����set���ϵĶ������ݶ����hashCode()���дӴ�С�����Ҹ���hashCode��ֵȥ��
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

//������������ģ�ûʲô�ر��,��дhashCode��equals����Ϊ����hashSet���ݶ�������ȥ��
class Student {	
	private String name;//����������������������
	@Override
	public int hashCode() {
		System.out.println("hashCode������һ��");
		/*�����Ǹ��������ʱ������ײ�͹����������ص�ֵ��Ϊ��ϣֵ
		 */
		return  name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals������һ��");
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







