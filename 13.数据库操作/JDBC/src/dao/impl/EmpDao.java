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
 * 1.可以对SQL语句进行预处理，比Statement更加高效
 * 2.可以使用占位符，解决字符串拼接的麻烦，让编程更加高效
   12.2 PrepareStatement对象进行批处理
		1. 使用占位符创建SQL语句。
		2. 使用prepareStatement（） 方法创建PrepareStatement对象。
		3. 使用setAutoCommit（）将auto-commit设置为false 。
		4. 使用addBatch（）方法在创建的语句对象上添加您喜欢的SQL语句到批处理中。
		5. 在创建的语句对象上使用executeBatch（）方法执行所有SQL语句。
		6. 最后，使用commit（）方法提交所有更改。
 */
public class EmpDao implements IEmpDao {

	@Override
	public void insert(Emp emp) {
		Connection conn = Util.findConnection();
		String sql="insert into emp(empno,ename,job,sal,comm,hiredate,mgr,deptno) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=null;
		
		try {
			conn.setAutoCommit(false);//JDBC会自动提交事务，一般把自动提交事务改成手动提交
			
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, emp.getEmpno());
			 ps.setString(2, emp.getEname());
			 ps.setString(3, emp.getJob());
			 ps.setDouble(4, emp.getSal());
			 ps.setDouble(5, emp.getComm());
			 ps.setDate(6,new java.sql.Date(emp.getHiredate().getTime()));
			 ps.setInt(7, emp.getMgr());
			 ps.setInt(8, emp.getDeptno());
			
			 
			 ps.executeUpdate(); //执行Sql
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
		//获得连接对象
		Connection conn = Util.findConnection();
		String sql="select * from emp where empno=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			 ps = conn.prepareStatement(sql);//可以预编译的SQL语句
			ps.setInt(1, empno);//绑定参数(把empno和?占位符绑定,默认从1开始)
			 rs = ps.executeQuery();//执行编译好的SQL(要使用方法中没有SQL参数的方法)
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
 * 使用Statement对象进行批处理操作( 打开一次会话可以处理批量的sql，减轻数据库的开销)
	以下是使用语句对象的批处理的典型步骤序列
	- 使用createStatement（）方法创建Statement对象。
	- 使用setAutoCommit（）将auto-commit设置为false 。
	- 使用addBatch（）方法在创建的语句对象上添加您喜欢的SQL语句到批处理中。
	- 在创建的语句对象上使用executeBatch（）方法执行所有SQL语句。
	- 最后，使用commit（）方法提交所有更改。
 */
	@Override
	public void insertBatchByStatement() {
		
	Connection conn = Util.findConnection();
	Statement st=null;
try {	
		 conn.setAutoCommit(false);
		 st = conn.createStatement();
		 String sql="insert int emp(empno,ename,job) values(1111,'张三,'clerk')";
		 String sql2="insert int emp(empno,ename,job) values(1112,'李四,'clerk')";
	
		 //添加批处理
		 st.addBatch(sql);
		 st.addBatch(sql2);
		 st.executeBatch();//执行批处理
		 conn.commit();
		 conn.setAutoCommit(true);
		 


//********************************************************************************************************************************************************			 
} catch (SQLException e) {e.printStackTrace();try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}}finally {Util.closeResource(null, st, conn);}}
//********************************************************************************************************************************************************			 

	
	
	/*
	 * 12.2 PrepareStatement对象进行批处理
		1. 使用占位符创建SQL语句。
		2. 使用prepareStatement（） 方法创建PrepareStatement对象。
		3. 使用setAutoCommit（）将auto-commit设置为false 。
		4. 使用addBatch（）方法在创建的语句对象上添加您喜欢的SQL语句到批处理中。
		5. 在创建的语句对象上使用executeBatch（）方法执行所有SQL语句。
		6. 最后，使用commit（）方法提交所有更改。
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
				 ps.setString(2, "王五");
				 ps.setString(3, "clerk");
				 //添加批处理的时候和Statement不一样，不需要参数
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
	 * 一次连接多次会话,进行批处理，（一般不这么使用）
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
				 ps.setString(2, "王五");
				 ps.setString(3, "clerk");
				 //添加批处理的时候和Statement不一样，不需要参数
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
			 //插入Blob数据:图片
			 ps.setInt(1, 1009);
			
			 
			 //获得输入流
			InputStream is = new FileInputStream("C:\\Users\\FZS\\Pictures\\老婆.jpg");
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
	 * 第十三章 JDBC操作二进制

		PreparedStatement对象可以使用输入和输出流来提供参数数据。这使您可以将整个文件放入可以保存大值的数据库列，例如CLOB和BLOB数据类型。

		有以下方法可用于流式传输数据 -

		- setAsciiStream（）：此方法用于提供大的ASCII值。
		- setCharacterStream（）：此方法用于提供大型UNICODE值。
		- setBinaryStream（）：此方法用于提供较大的二进制值。

		setXXXStream（）方法除了参数占位符之外还需要额外的参数，文件大小。

		考虑我们要将XML文件XML_Data.xml上传到数据库表中。这是XML文件的内
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
				//rs.getByte(columnIndex)读入字节数组
				//Blob blob = rs.getBlob("img");
				InputStream is = rs.getBinaryStream("img");
				//写入磁盘"C:\\Users\\FZS\\Pictures"
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
	 *测试回滚 
	 *14.4.2 使用 Savepoints
		新的JDBC 3.0 Savepoint接口为您提供了额外的事务控制。
		设置保存点时，可以在事务中定义逻辑回滚点。如果通过保存点发生错误，则可以使用回滚方法来撤消所有更改或仅保存在保存点之后所做的更改。
		Connection对象有两种新的方法来帮助您管理保存点 -
		- setSavepoint（String savepointName）：定义新的保存点。它还返回一个Savepoint对象。
		- releaseSavepoint（Savepoint savepointName）：删除保存点。请注意，它需要一个Savepoint对象作为参数。
		此对象通常是由setSavepoint（）方法生成的保存点。
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
			 //设置还原点
			 point1 = conn.setSavepoint("point1");
			 
			 ps2 = conn.prepareStatement(sql2);
			 ps2.setInt(1, 1003);
			 ps2.setString(2, "lzy");
			 ps2.execute();
			 //跑出异常，回滚到point点,把后两条直接回滚掉
			 System.out.println(1/0);
			 
			 ps3 = conn.prepareStatement(sql2);
			 ps3.setInt(1, 1004);
			 ps3.setString(2, "son");
			 ps3.execute();
			 conn.commit();
			 conn.setAutoCommit(true);
			 
		} catch (Exception e) {//这个部分一定要能捕获到异常
			e.printStackTrace();
			try {
				conn.rollback(point1);
				conn.commit();//提交数据
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			Util.closeResource(null, ps, conn);
		}
	
	}
	/*
	 * 多表查询
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
			//得到结果集
			rs = ps.executeQuery();
			while(rs.next()){
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				//封装emp对像
				Emp emp = new Emp();
				emp.setEmpno(empno);
				emp.setJob(job);
				emp.setEname(ename);
				
				//封装dept对像
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				Dept dept = new Dept();
				dept.setDeptno(deptno);
				dept.setDname(dname);
				dept.setLoc(loc);
				
				//把dept封装到emp中
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
