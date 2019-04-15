package dao;

import java.util.List;

import model.Emp;

public interface IEmpDao {
	public abstract void insert(Emp emp);//增加
	void delete(int empno);//删除
	void update(Emp emp);//更新
	Emp selectById(int empno);//按主键查询
	List<Emp> selectAll();//查询所有
	public void insertBatchByStatement();//Statement批处理
	public void insertByPreparedStatement();//PreparedStatement批处理
	public void insertBlob();//插入Blob字段
	public Emp selectBlob(int empno);//读取blob字段
	public void insertByTransaction();//回滚
	public void insertBySavePoint();//事务回滚到还原点
	public Emp selectByJoin(int empno);//多表查询
}
