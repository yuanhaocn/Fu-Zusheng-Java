package Aµ¥ÀýÄ£Ê½;

public class Test {

	public static void main(String[] args) {
		CEO ceo=CEO.getInstance();
		CEO ceo2=CEO.getInstance();
		CEO ceo3=CEO.getInstance();
		CEO ceo4=CEO.getInstance();
		System.out.println(ceo);
		System.out.println(ceo2);
		System.out.println(ceo3);
		System.out.println(ceo4);
		
	}

}
