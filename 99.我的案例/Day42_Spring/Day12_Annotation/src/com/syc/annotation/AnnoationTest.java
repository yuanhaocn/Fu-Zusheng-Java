package com.syc.annotation;

public class AnnoationTest {

	public static void main(String[] args) {
		Person p = new Person();
		p.setId(1);
		p.setName("Tom");
		p.setGender("男");

		Class<? extends Person> clazz = p.getClass();
		Table tableAnnoation = clazz.getAnnotation(Table.class);
		String value = tableAnnoation.value();
		System.out.println("value=" + value);

		// SQL=insert into person (id,name,gender)
		// values(getId,getName,getGener)

	}
}
