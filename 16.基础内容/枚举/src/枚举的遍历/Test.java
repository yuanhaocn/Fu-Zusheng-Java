package ö�ٵı���;

class Test {

	public static void main(String[] args) {
		System.out.println(Animal.LION);
		Animal[] values = Animal.values();//ö������
		Animal valueOf =Animal.valueOf(Animal.class, "DOG");//.class��ûѧ���ڷ�������
		System.out.println(valueOf);
	}

}
