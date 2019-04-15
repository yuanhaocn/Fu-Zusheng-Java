package 枚举的遍历;

class Test {

	public static void main(String[] args) {
		System.out.println(Animal.LION);
		Animal[] values = Animal.values();//枚举数组
		Animal valueOf =Animal.valueOf(Animal.class, "DOG");//.class还没学，在反射里面
		System.out.println(valueOf);
	}

}
