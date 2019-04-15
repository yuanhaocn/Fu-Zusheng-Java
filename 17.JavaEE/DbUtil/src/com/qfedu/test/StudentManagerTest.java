package com.qfedu.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.qfedu.daoImp.StudentManagerImp;

public class StudentManagerTest {

	private StudentManagerImp smi = null;

	@Before
	public void ini() {
		smi = new StudentManagerImp();
	}

	@Test
	public void handleAgeTest() {
		smi.handleAge();
	}
	@Test
	public void mohuTest(){
		List<Map<String, Object>> list = smi.mohuSelectStudent("¸µ");
		System.out.println(list);
	}
}
