package D$���Ͷ�̬��������;
/**
* ��̬�ĸ�ϰ
 		* ��Fruit����Ӧ��
 		* ��̬��������̬ 
 */
public class TestGen {
	//�β�ʹ�ö�̬
	public static void test(Fruit f) {}
	//��������ʹ�ö�̬
	public static Fruit test2() {return new Apple();}
	
	public static void main(String[] args) {
		Fruit f = new Apple();		//������̬ ��������ָ���������
		test(new Apple());		//��һ�������ȥ����ʵ�־����������д����
	}
}

class Fruit {}//����
class Apple extends Fruit{}//����