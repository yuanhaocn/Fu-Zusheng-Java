package �ü��ϴ����Ϣ;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * һ�ű��Ӧһ����,һ���ֶζ�Ӧһ������ ����һ�㶼˽�� ����set/get����
 * __________________________________________________________________
 * |	id	|	name	|	salary	|	department	|	hireDate	|
 * |--------|-----------|-----------|---------------|---------------|
 * |--------|-----------|-----------|---------------|---------------|
 * |================================================================|
 */
public class Employee {		//Javabean ,���߳�Ϊʵ���࣬�����ܼ򵥣�ֻ�����Ժ���Ӧ��set/get������

	
//*****************************************************************************************************//	
	private int id;
	private String name;
	private int salary;
	private String department;
	private Date hireDate;
//*****************************************************************************************************//	
	
	
//�ǳ�����˼�Ĳ���
	public Employee(int id, String name, int salary, String department, String hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		//this.hireDate = hireDate;
//�ַ�תʱ���ʽ����ûŪ����
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		try {
			this.hireDate = format.parse(hireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	} 
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getSalary() {return salary;}
	public void setSalary(int salary) {this.salary = salary;}
	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department = department;}
	public Date getHireDate() {return hireDate;}
	public void setHireDate(Date hireDate) {this.hireDate = hireDate;}
	
}
