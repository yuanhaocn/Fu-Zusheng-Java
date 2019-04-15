package ��ϣSet$TreeSet;
/**
 * ��ݼ�Alt + s��дhashCode ��equals�������Զ����ɵ�����
 * 1. �̳�Cloneable�ӿڣ���дObject��clone()�������Ƚ���hashSet��д��clone()������ͬ
 * 2.�̳�Comparable�ӿڣ�������TreeSet�Ŷ����ʱ���Ҫ��������һ����˵Ҫ��̳в���д������
 * Ȼ�����ݹ�ϣֵ����
 * ���ǿ����û�����,����ĳ�����Խ�������
 */
public class Book implements Cloneable,Comparable<Book>{
	private String name;
	private Integer num;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//��Ϊ�˱�֤hashCode �����ܲ�ͬ����߹�ϣɢ�е����������͹���ײ�Ŀ��ܣ��������
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
		//���ͨ��ʹ�÷����õ�Class�಻�ȣ�Ҳ����ͬһ����
		if (getClass() != obj.getClass())
			return false;
		//���ʵ�ʱ�򷵻�false �������ų���
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
	
	
	// 1.��дclone()����,����������ܵ����������
	/*
	 * Object ��� clone ����ִ���ض��ĸ��Ʋ�����
	 * ���ȣ�����˶�����಻��ʵ�ֽӿ� Cloneable������׳� CloneNotSupportedException��
	 * ע�⣬���е����鶼����Ϊʵ�ֽӿ� Cloneable��
	 * ���򣬴˷����ᴴ���˶�������һ����ʵ��������ͨ������������
	 * �ϸ�ʹ�ô˶�����Ӧ�ֶε����ݳ�ʼ���ö���������ֶΣ���Щ�ֶε�����û�б����Ҹ��ơ�
	 * ���ԣ��˷���ִ�е��Ǹö���ġ�ǳ���ơ�����������㸴�ơ�������
	 * Object �౾��ʵ�ֽӿ� Cloneable��
	 * ��������Ϊ Object �Ķ����ϵ��� clone �������ᵼ��������ʱ�׳��쳣��
	 * ע��hashSet��д��clone��������������ǳ�㸴�Ʊ����൱�ڸ�ֵ��������ԭ����ϣ����ͬ
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// 2.�̳�Comparable�ӿڣ���дcompaeaTo�����������û��Զ�������
	//����֮���������̫���ˣ����Լ��γ���ϣ���һ���ӿ�Comparator�ӿ�
	//--->TestTreeSet.XiaoSan.java
	@Override
	public int compareTo(Book book) {
		if(num>book.getNum()) {
			return -1;	//���Ը��ģ���������ͷ�������
		}else if(num<book.getNum()){
			return 1;	//���Ը��ģ���������ͷ�������
		}
		return 0;
	}
	
	/*
	 * ��������������棬��������
	 * ��������һ���������Ƚ�
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
