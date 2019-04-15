package C反射读取注解;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/**
 * 表示类和表之间的转换
 * 注解的使用：
 * 	1.定义注解本身
 * 	2.在类里面使用注解
 * 	3.通过解析程序，把注解读出来，进行相关数据处理
 */
@SxtTable("tb_student")
public class SxtStudent {
	
	 /*
	  * 这样就通过注解对属性进行了说明
	  * 接下来将属性转成表里面的信息就可以根据注解进行标识
	  */
	@SxtField(columnName="id",type="int",length=10)
	private int id;
	@SxtField(columnName="sname",type="varchar",length=10)
	private String studentName;
	@SxtField(columnName="age",type="int",length=3)
	private int age;
	
		
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getStudentName() {return studentName;}
	public void setStudentName(String studentName) {this.studentName = studentName;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	/*
	 *使用反射读取注解信息，模拟处理注解信息的流程 
	 *
	 */
	public static void main(String[] args) {
		try {
			//cls中包含了这个类的全部信息，也包含注解信息
			Class<?> cls = Class.forName("反射.SxtStudent");
			
			
			/*
			 * 获得类的注解
			 */
			Annotation[] annotations = cls.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			//直接获得类指定注解的值
			SxtTable st = cls.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			
			/*
			 * 获得属性的注解
			 */
			Field df = cls.getDeclaredField("studentName");
			SxtField sxtField = df.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());
//根据获得的表名，字段信息，拼出DDL语句，然后使用JDBC执行这个SQL，在数据库中生成相关的表
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
