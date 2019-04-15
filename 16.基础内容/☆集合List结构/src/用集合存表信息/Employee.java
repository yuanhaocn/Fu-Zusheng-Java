package 用集合存表信息;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一张表对应一个类,一个字段对应一个属性 属性一般都私有 增加set/get方法
 * __________________________________________________________________
 * |	id	|	name	|	salary	|	department	|	hireDate	|
 * |--------|-----------|-----------|---------------|---------------|
 * |--------|-----------|-----------|---------------|---------------|
 * |================================================================|
 */
public class Employee {		//Javabean ,或者成为实体类，这个类很简单，只有属性和相应的set/get方法，

	
//*****************************************************************************************************//	
	private int id;
	private String name;
	private int salary;
	private String department;
	private Date hireDate;
//*****************************************************************************************************//	
	
	
//非常有意思的部分
	public Employee(int id, String name, int salary, String department, String hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		//this.hireDate = hireDate;
//字符转时间格式，还没弄懂！
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
