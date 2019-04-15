package dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.IEmpDao;
import model.Dept;
import model.Emp;
import util.Util;
/**
 * 1.���Զ�SQL������Ԥ������Statement���Ӹ�Ч
 * 2.����ʹ��ռλ��������ַ���ƴ�ӵ��鷳���ñ�̸��Ӹ�Ч
   12.2 PrepareStatement�������������
		1. ʹ��ռλ������SQL��䡣
		2. ʹ��prepareStatement���� ��������PrepareStatement����
		3. ʹ��setAutoCommit������auto-commit����Ϊfalse ��
		4. ʹ��addBatch���������ڴ������������������ϲ����SQL��䵽�������С�
		5. �ڴ�������������ʹ��executeBatch��������ִ������SQL��䡣
		6. ���ʹ��commit���������ύ���и��ġ�
 */
public class EmpDao implements IEmpDao {

	@Override
	public void insert(Emp emp) {
		Connection conn = Util.findConnection();
		String sql="insert into emp(empno,ename,job,sal,comm,hiredate,mgr,deptno) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=null;
		
		try {
			conn.setAutoCommit(false);//JDBC���Զ��ύ����һ����Զ��ύ����ĳ��ֶ��ύ
			
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, emp.getEmpno());
			 ps.setString(2, emp.getEname());
			 ps.setString(3, emp.getJob());
			 ps.setDouble(4, emp.getSal());
			 ps.setDouble(5, emp.getComm());
			 ps.setDate(6,new java.sql.Date(emp.getHiredate().getTime()));
			 ps.setInt(7, emp.getMgr());
			 ps.setInt(8, emp.getDeptno());
			
			 
			 ps.executeUpdate(); //ִ��Sql
			 conn.commit();
			 conn.setAutoCommit(true);
			 
			 
//********************************************************************************************************************************************************			 
} catch (SQLException e) {e.printStackTrace();try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}}finally {Util.closeResource(null, ps, conn);}}
//********************************************************************************************************************************************************			 
	

	
	@Override
	public void delete(int empno) {
		Connection conn = Util.findConnection();
		String sql="delete from emp where empno=?";
		PreparedStatement ps =null;
		
		try {
			conn.setAutoCommit(false);
			ps= conn.prepareStatement(sql);
			ps.setInt(1, empno);
			//ps.execute();
			ps.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
	
			
//********************************************************************************************************************************************************			 
} catch (SQLException e) {e.printStackTrace();try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}}finally {Util.closeResource(null, ps, conn);}}
//********************************************************************************************************************************************************			 

	
	
	@Override
	public void update(Emp emp) {
		
		PreparedStatement ps=null;
		Connection conn = Util.findConnection();
		String sql="update emp set ename=?,job=?,comm=?,hiredate=?,mgr=?,daptno=? where empno=?";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setDouble(3, emp.getComm());
			//ps.setDouble(4, emp.getSal());
			ps.setDate(4, new java.sql.Date(emp.getHiredate().getTime()) );
			ps.setInt(5, emp.getMgr());
			ps.setInt(6, emp.getDeptno());
			ps.setInt(7, emp.getEmpno());
			ps.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
//********************************************************************************************************************************************************			 
} catch (SQLException e) {e.printStackTrace();try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}}finally {Util.closeResource(null, ps, conn);}}
//********************************************************************************************************************************************************			 
	
	
	
	@Override
	public Emp selectById(int empno) {
		//������Ӷ���
		Connection conn = Util.findConnection();
		String sql="select * from emp where empno=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			 ps = conn.prepareStatement(sql);//����Ԥ�����SQL���
			ps.setInt(1, empno);//�󶨲���(��empno��?ռλ����,Ĭ�ϴ�1��ʼ)
			 rs = ps.executeQuery();//ִ�б���õ�SQL(Ҫʹ�÷�����û��SQL�����ķ���)
			while(rs.next()) {
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Emp emp = new Emp();
				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setJob(job);
				return emp;
			}

		
//********************************************************************************************************************************************************			 
} catch (SQLException e) {e.printStackTrace();}finally {Util.closeResource(rs, ps, conn);}return null;}
//********************************************************************************************************************************************************			 

	
	@Override
	public List<Emp> selectAll() {
		Connection conn = Util.findConnection();
		String sql="select * from emp";
		PreparedStatement ps=null;
		ResultSet rs =null;
		List<Emp> list = new ArrayList<Emp>();
		
		
		try {
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Emp emp = new Emp();
				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setJob(job);
				list.add(emp);
			
			
			
//********************************************************************************************************************************************************			 
}} catch (SQLException e) {e.printStackTrace();}finally {Util.closeResource(rs, ps, conn);}return list;}
//********************************************************************************************************************************************************			 

	
	
/*
 *
 * ʹ��Statement����������������( ��һ�λỰ���Դ���������sql���������ݿ�Ŀ���)
	������ʹ���������������ĵ��Ͳ�������
	- ʹ��createStatement������������Statement����
	- ʹ��setAutoCommit������auto-commit����Ϊfalse ��
	- ʹ��addBatch���������ڴ������������������ϲ����SQL��䵽�������С�
	- �ڴ�������������ʹ��executeBatch��������ִ������SQL��䡣
	- ���ʹ��commit���������ύ���и��ġ�
 */
	@Override
	public void insertBatchByStatement() {
		
	Connection conn = Util.findConnection();
	Statement st=null;
try {	
		 conn.setAutoCommit(false);
		 st = conn.createStatement();
		 String sql="insert int emp(empno,ename,job) values(1111,'����,'clerk')";
		 String sql2="insert int emp(empno,ename,job) values(1112,'����,'clerk')";
	
		 //���������
		 st.addBatch(sql);
		 st.addBatch(sql2);
		 st.executeBatch();//ִ��������
		 conn.commit();
		 conn.setAutoCommit(true);
		 


//********************************************************************************************************************************************************			 
} catch (SQLException e) {e.printStackTrace();try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}}finally {Util.closeResource(null, st, conn);}}
//********************************************************************************************************************************************************			 

	
	
	/*
	 * 12.2 PrepareStatement�������������
		1. ʹ��ռλ������SQL��䡣
		2. ʹ��prepareStatement���� ��������PrepareStatement����
		3. ʹ��setAutoCommit������auto-commit����Ϊfalse ��
		4. ʹ��addBatch���������ڴ������������������ϲ����SQL��䵽�������С�
		5. �ڴ�������������ʹ��executeBatch��������ִ������SQL��䡣
		6. ���ʹ��commit���������ύ���и��ġ�
	 */
	@Override
	public void insertByPreparedStatement() {

		
		Connection conn = Util.findConnection();
			 PreparedStatement ps=null;
			
			 try {
				 conn.setAutoCommit(false);
				 String sql="insert into emp(empno,ename,job) values(?,?,?)"; 
				//  String sql2="insert int emp(empno,ename,job) values(?,?,?)";
				 ps = conn.prepareStatement(sql);
				 
				 
				 ps.setInt(1, 1113);
				 ps.setString(2, "����");
				 ps.setString(3, "clerk");
				 //����������ʱ���Statement��һ��������Ҫ����
				 ps.addBatch();
				 
				
			
				 ps.setInt(1, 1114);
				 ps.setString(2, "666");
				 ps.setString(3, "clerk");
				 ps.addBatch();
				 
				 
				 ps.executeBatch();
				 conn.commit();
				 conn.setAutoCommit(true);
				 
			 
//********************************************************************************************************************************************************			 
} catch (SQLException e) {e.printStackTrace();try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}}finally {Util.closeResource(null, ps, conn);}}
//********************************************************************************************************************************************************			 

	
	
	/*
	 * һ�����Ӷ�λỰ,������������һ�㲻��ôʹ�ã�
	 * 
	 */
	public void insertByPreparedStatement2() {

		
		Connection conn = Util.findConnection();
			 PreparedStatement ps=null;
			 PreparedStatement ps2=null;
			
			 try {
				 conn.setAutoCommit(false);
				 String sql="insert into emp(empno,ename,job) values(?,?,?)"; 
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, 1113);
				 ps.setString(2, "����");
				 ps.setString(3, "clerk");
				 //����������ʱ���Statement��һ��������Ҫ����
				 ps.addBatch();
				 
				
				String sql2="insert into emp(empno,ename,job) values(?,?,?)";
				 ps2 = conn.prepareStatement(sql2);
				 ps2.setInt(1, 1114);
				 ps2.setString(2, "666");
				 ps2.setString(3, "clerk");
				 ps2.addBatch();
				 ps2.executeBatch();
				 conn.commit();
				 conn.setAutoCommit(true);
				 
			 
			 
//********************************************************************************************************************************************************			 
} catch (SQLException e) {e.printStackTrace();try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}}finally {Util.closeResource(null, ps, conn);}}
//********************************************************************************************************************************************************			 

	
	
	
	
	@Override
	public void insertBlob()  {
		Connection conn = Util.findConnection();
		PreparedStatement ps=null;
		String sql="insert into emp(empno,img) values(?,?)";
		try {
			conn.setAutoCommit(false);
			 ps = conn.prepareStatement(sql);
			 //����Blob����:ͼƬ
			 ps.setInt(1, 1009);
			
			 
			 //���������
			InputStream is = new FileInputStream("C:\\Users\\FZS\\Pictures\\����.jpg");
			// ps.setBinaryStream(2, is);
			 ps.setBlob(2, is);
			 ps.execute();
			 
			 conn.commit();
			 conn.setAutoCommit(true);
			 
			 
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			Util.closeResource(null, ps, conn);
		}
	}
	/*
	 * ��ʮ���� JDBC����������

		PreparedStatement�������ʹ���������������ṩ�������ݡ���ʹ�����Խ������ļ�������Ա����ֵ�����ݿ��У�����CLOB��BLOB�������͡�

		�����·�����������ʽ�������� -

		- setAsciiStream�������˷��������ṩ���ASCIIֵ��
		- setCharacterStream�������˷��������ṩ����UNICODEֵ��
		- setBinaryStream�������˷��������ṩ�ϴ�Ķ�����ֵ��

		setXXXStream�����������˲���ռλ��֮�⻹��Ҫ����Ĳ������ļ���С��

		��������Ҫ��XML�ļ�XML_Data.xml�ϴ������ݿ���С�����XML�ļ�����
	 */
	@Override
	public Emp selectBlob(int empno) {
			Connection conn = Util.findConnection();
			String sql="select *from emp where empno=?";
			PreparedStatement ps=null;
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, empno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//rs.getByte(columnIndex)�����ֽ�����
				//Blob blob = rs.getBlob("img");
				InputStream is = rs.getBinaryStream("img");
				//д�����"C:\\Users\\FZS\\Pictures"
				OutputStream os = new FileOutputStream("C:\\Users\\FZS\\Pictures\\2.jpg");
				int bt=0;
				while(-1!=(bt=is.read())) {
					os.write(bt);
				}
				os.flush();
				os.close();
			}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}finally {
				Util.closeResource(null, ps, conn);
			}
			
	
		
		
		return null;
	}
	/*
	 *���Իع� 
	 *14.4.2 ʹ�� Savepoints
		�µ�JDBC 3.0 Savepoint�ӿ�Ϊ���ṩ�˶����������ơ�
		���ñ����ʱ�������������ж����߼��ع��㡣���ͨ������㷢�����������ʹ�ûع��������������и��Ļ�������ڱ����֮�������ĸ��ġ�
		Connection�����������µķ������������������ -
		- setSavepoint��String savepointName���������µı���㡣��������һ��Savepoint����
		- releaseSavepoint��Savepoint savepointName����ɾ������㡣��ע�⣬����Ҫһ��Savepoint������Ϊ������
		�˶���ͨ������setSavepoint�����������ɵı���㡣
	 */
	@Override
	public void insertByTransaction() {
		Connection conn = Util.findConnection();
		String sql="insert into emp(empno,ename) values(?,?)";
		String sql2="insert into emp(empno,ename) values(?,?)";
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		try {
			conn.setAutoCommit(false);
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, 1002);
			 ps.setString(2, "fzs");
			 ps.execute();
			System.out.println(1/0);
			 ps2 = conn.prepareStatement(sql2);
			 ps2.setInt(1, 1003);
			 ps2.setString(2, "lzy");
			 ps2.execute();
			 conn.commit();
			 conn.setAutoCommit(true);
			 
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			Util.closeResource(null, ps, conn);
		}
	}
	@Override
	public void insertBySavePoint() {
		Connection conn = Util.findConnection();
		String sql="insert into emp(empno,ename) values(?,?)";
		String sql2="insert into emp(empno,ename) values(?,?)";
		String sql3="insert into emp(empno,ename) values(?,?)";
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		PreparedStatement ps3=null;
		 Savepoint point1=null;
		try {
			conn.setAutoCommit(false);
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, 1002);
			 ps.setString(2, "999");
			 ps.execute();
			 //���û�ԭ��
			 point1 = conn.setSavepoint("point1");
			 
			 ps2 = conn.prepareStatement(sql2);
			 ps2.setInt(1, 1003);
			 ps2.setString(2, "lzy");
			 ps2.execute();
			 //�ܳ��쳣���ع���point��,�Ѻ�����ֱ�ӻع���
			 System.out.println(1/0);
			 
			 ps3 = conn.prepareStatement(sql2);
			 ps3.setInt(1, 1004);
			 ps3.setString(2, "son");
			 ps3.execute();
			 conn.commit();
			 conn.setAutoCommit(true);
			 
		} catch (Exception e) {//�������һ��Ҫ�ܲ����쳣
			e.printStackTrace();
			try {
				conn.rollback(point1);
				conn.commit();//�ύ����
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			Util.closeResource(null, ps, conn);
		}
	
	}
	/*
	 * ����ѯ
	 *  
	 * 
	 */
	@Override
	public Emp selectByJoin(int empno) {
		
		Connection conn = Util.findConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM emp LEFT JOIN dept ON emp.deptno = dept.deptno WHERE emp.empno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			//�õ������
			rs = ps.executeQuery();
			while(rs.next()){
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				//��װemp����
				Emp emp = new Emp();
				emp.setEmpno(empno);
				emp.setJob(job);
				emp.setEname(ename);
				
				//��װdept����
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				Dept dept = new Dept();
				dept.setDeptno(deptno);
				dept.setDname(dname);
				dept.setLoc(loc);
				
				//��dept��װ��emp��
				emp.setDept(dept);
				
				return emp;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Util.closeResource(rs, ps, conn);
		}
		return null;
	}

}
