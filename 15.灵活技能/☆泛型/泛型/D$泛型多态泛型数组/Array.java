package D$���Ͷ�̬��������;

import E$����ͨ���.Student;

/**		���������顱��ʵ��----����ʵ����ArrayList<E>�����ۻ���
 * û�з������飬���ܴ�����������
 * ����ֻ������������ʹ����
 * A<String>[] a1 = null;
 * A<?>[] a2 = new A<?>[10];
 */
public class Array {

	public static void main(String[] args) {
		Integer[] arr = new Integer[4];
		Student<String>[] arr2;			//���������� ����ûɶ����	��������ʵ�����������ArrayList�е�remove(T[] a)����Ӧ��
//	arr2 = new Student<String>[10];  //�������ܹ�����ʹ�� Cannot create a generic array of Student<String>

	
//***********************************************************************************//
	MyArrayList<String> strList  = new MyArrayList<String>();	//ʹ��һ��MyArrayList<E>
	strList.add(0,"Fu Zusheng is the best programmer");		//�����ʹ��Object������н��ܣ�ʹ�õ�ʱ����Ū����
	String elem = strList.getElem(0);
	System.out.println(elem);
	}

}
/**
 * ����ArrayList�ľ����
 */
class MyArrayList<E>{
	//E[] cap = new E[10];	//����ʹ��ʱ����� ǰһ������û�����⣬��һ��ʹ�þ���������
	//E[] cap = new Object[10]; //Ҳ�ǲ����Ե�
	Object[] cap = new Object[10];	//ʹ��Object������Խ����κζ�����������ǿ������ת��
	public void add(int idx,E e) {
		cap[idx] = e;
	}
	@SuppressWarnings("unchecked")		//ѹ�ƾ���
	public E[] getAll() {
		return (E[]) cap;		//ǿ������ת��
	}
	@SuppressWarnings("unchecked")	//ѹ�ƾ���
	public E getElem(int idx) {
		return(E) cap[idx];		//ǿ������ת��
	}
	
	
}
