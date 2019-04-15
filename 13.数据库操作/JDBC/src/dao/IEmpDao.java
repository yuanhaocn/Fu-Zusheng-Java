package dao;

import java.util.List;

import model.Emp;

public interface IEmpDao {
	public abstract void insert(Emp emp);//����
	void delete(int empno);//ɾ��
	void update(Emp emp);//����
	Emp selectById(int empno);//��������ѯ
	List<Emp> selectAll();//��ѯ����
	public void insertBatchByStatement();//Statement������
	public void insertByPreparedStatement();//PreparedStatement������
	public void insertBlob();//����Blob�ֶ�
	public Emp selectBlob(int empno);//��ȡblob�ֶ�
	public void insertByTransaction();//�ع�
	public void insertBySavePoint();//����ع�����ԭ��
	public Emp selectByJoin(int empno);//����ѯ
}
