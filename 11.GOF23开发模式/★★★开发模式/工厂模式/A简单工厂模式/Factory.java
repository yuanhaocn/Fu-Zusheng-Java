package A简单工厂模式;
/**
 * 没有完全的满足OCP原则--》进而引出了抽象工厂模式
 * @author FZS
 *
 */
public class Factory {
	public static void main(String[] args) {

	}

	static Animal getObject(String input) {		//返回类型为上转型
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
