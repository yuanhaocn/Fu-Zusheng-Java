package A�򵥹���ģʽ;
/**
 * û����ȫ������OCPԭ��--�����������˳��󹤳�ģʽ
 * @author FZS
 *
 */
public class Factory {
	public static void main(String[] args) {

	}

	static Animal getObject(String input) {		//��������Ϊ��ת��
		switch (input) {
		case "cat":
			Cat cat = new Cat();
			return cat;
		case "dog":
			Dog dog = new Dog();
		return dog;
		case "bird":
			Bird bird = new Bird();
			return bird;
		default:
			return null;
		}
	}
}
