package C�����ȡע��;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/**
 * ��ʾ��ͱ�֮���ת��
 * ע���ʹ�ã�
 * 	1.����ע�Ȿ��
 * 	2.��������ʹ��ע��
 * 	3.ͨ���������򣬰�ע�������������������ݴ���
 */
@SxtTable("tb_student")
public class SxtStudent {
	
	 /*
	  * ������ͨ��ע������Խ�����˵��
	  * ������������ת�ɱ��������Ϣ�Ϳ��Ը���ע����б�ʶ
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
	 *ʹ�÷����ȡע����Ϣ��ģ�⴦��ע����Ϣ������ 
	 *
	 */
	public static void main(String[] args) {
		try {
			//cls�а�����������ȫ����Ϣ��Ҳ����ע����Ϣ
			Class<?> cls = Class.forName("����.SxtStudent");
			
			
			/*
			 * ������ע��
			 */
			Annotation[] annotations = cls.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			//ֱ�ӻ����ָ��ע���ֵ
			SxtTable st = cls.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			
			/*
			 * ������Ե�ע��
			 */
			Field df = cls.getDeclaredField("studentName");
			SxtField sxtField = df.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());
//���ݻ�õı������ֶ���Ϣ��ƴ��DDL��䣬Ȼ��ʹ��JDBCִ�����SQL�������ݿ���������صı�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
