package 枚举;
/**
 * jdk1.7中switch 不支持字符串，不过现在已经完全不用了
 */
public abstract class Test {

	public static void main(String[] args) {
		switch (Color.RED) {
		case RED:
			System.out.println("red");
			break;
		case YELLO:
			System.out.println("yello");
			break;
		}
	}
	

}
