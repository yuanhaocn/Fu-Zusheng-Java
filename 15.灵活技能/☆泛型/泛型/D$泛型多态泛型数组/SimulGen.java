
package D$���Ͷ�̬��������;
/**
 * ����û�ж�̬!!һ������
 */
public class SimulGen {
	public static void main(String[] args) {
	//	A<Fruit> f1 = new A<Apple>();	//Type mismatch: cannot convert from A<Apple> to A<Fruit> 
										// ���Ƕ�̬�ľ���д�������Ƿ���û�ж�̬
		A<Fruit> f = new A<Fruit>();
	}
	//�β�ʹ�ö�̬
	public static void test(A<Fruit> f) {
		
	}
	//��������ʹ�ö�̬
	public static A<Fruit> test2() {
		return null ;
	}
}
/**
 * ������
 * ����֮����ʹ�ö�̬�� ���ǲ��Եģ�����û�ж�̬
 * @param <T>
 */
 class A<T> {}
