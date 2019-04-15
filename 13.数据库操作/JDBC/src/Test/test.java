package Test;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.IEmpDao;
import dao.impl.EmpDao;
import model.Emp;

public class test {
	IEmpDao dao;
	@Before
	public void init() {
		dao=new EmpDao();
	}
	
	@Test
	public void selectById() {
		int id=7844;
		Emp emp = dao.selectById(id);
		System.out.println(emp.getJob());
	}
	@Test
	public void selectAll() {
		List<Emp> list = dao.selectAll();
		System.out.println(list);
	}
	@Test
	public void insert() {
		Emp emp = new Emp();
		emp.setEmpno(1000);
		emp.setComm(null);
	}
	@Test
	public void delete() {
		dao.delete(7934);
	}
	@Test
	public void update() {
		Emp emp = dao.selectById(1001);
		emp.setComm(300.00);
		dao.update(emp);
		
	}
	@Test
	public void insertBatchByStatement() {
		dao.insertBatchByStatement();
	}
	@Test
	public void insertByPreparedStatement() {
		dao.insertByPreparedStatement();
	}
	@Test
	public void insertBlob() {
		dao.insertBlob();
	}
	@Test
	public void selectBlob() {

		dao.selectBlob(1001);
	} 
	
	@Test
	public void insertByTransaction() {
		dao.insertByTransaction();
	}
	@Test
	public void insertBySavePoint() {
		dao.insertBySavePoint();
	} 
	
}
