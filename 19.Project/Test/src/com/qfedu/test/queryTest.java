package com.qfedu.test;

import java.util.List;

import org.junit.Test;

import com.qfedu.daoImp.TieManagerDaoImp;
import com.qfedu.domain.SendTie;

public class queryTest {

	@Test
	public void fun01() {
		TieManagerDaoImp tieManagerDaoImp = new TieManagerDaoImp();
		List<SendTie> list = tieManagerDaoImp.selectAllTie();
		System.out.println(list);
	}
}
