package E$����ͨ���;
class Fruit {}	//����
class Apple extends Fruit{}	//���� 
/**
 * ͨ���?��ʹ��
 	* 1).?��ʾ���Ͳ�����ʹ��ʱȷ�����ͣ����仰˵������main()�����ж����ͣ�
 	* 2).�������������ͼ��������������ϣ����������������Ϻ�ʹ��ʱ
 	* 3).?���Խ��ܷ��͵��������ͣ�ֻ�ܽ��ܺ�����������޸ģ���������ʱ�����޷���ȷ֪����������ͣ���˲����޸ģ�
 	* 4).? extends �������� ����ʾָ������Ҫ<= �̳е��� �����������������������
 	* 5).? super�������� ��>=���� ָ��������������߸���
 */
public class Student<T> {
	T score;
	
	public static void test(Student<?> stu) {}	//�������������� ,�ββ������ͣ������ʹ�üӽ�ȥ����
	//? extends �������� ��ʾָ���������34�е�Apple�����Ҫ<= �̳е������19�е�Fruit��
	public static void test02(Student<? extends Fruit> stu) {}
	public static void test03(Student< Fruit> stu) {}
	//? super�������� ��>=���� ָ��������������߸���
	public static void test04(Student<? super Fruit> stu) {}
	
	
	
//****************************************************************************************************//
	public static void main(String[] args) {
	//	Student<?> stu2= new Student<?>();	//?�������������ͼ���������������ʹ�ã����������������Ϻ�ʹ��ʱʹ��
		Student<?> stu = new Student<String>();	//ǰ�벿Student<?> stu������ ����һ������new Student<String>()��ʹ�� 
		test(new Student<Integer>());
		test02(new Student<Apple>());	//���ʵ�����������̬�����
	// 	test03(new Student<Apple>());  //������Ϊ����û�ж�̬
	//	test04(new Student<Apple>());	//����ӦΪtest4ʹ�õ���super,�������;Ͳ�����Apple Ҫ��FruitҪ�󣬴����˼��������߸���
		test04(new Student<Object>());
		test04(new Student<Fruit>());	//Object��Fruit�ĸ��࣬���Դ���ȥû����
	//	test04(stu); //ʹ��ʱȷ������  
	}
//******************************************************************************************************//
}
