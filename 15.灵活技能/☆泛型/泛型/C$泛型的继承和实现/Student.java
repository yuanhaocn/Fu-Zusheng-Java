package C$���͵ļ̳к�ʵ��;
/**
 * 117��16���ӳ�һ�㶼û����
 * ���͵Ĳ���
 * 1���̳�������ָ������
 * 2��ʹ��ʱ��ָ������
 * ͳһObject�Դ�
 * a,�������ľ��棬��������ʹ��Object
 * b,����ȫ��ͬ��Object�����벻�����ͼ��
 * @author FZS
 *
 * @param <T>
 */
public class Student<T> {		//���ٸ���ĸû������	
	private T javaScore;
	private T oracleScore;
	
	public T getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(T javaScore) {
		this.javaScore = javaScore;
	}
	public T getOracleScore() {
		return oracleScore;
	}
	public void setOracleScore(T oracleScore) {
		this.oracleScore = oracleScore;
	}
	public static void main(String[]  args) {
		Student stu1 = new Student();
		Student<Object> stu = new Student<>();	//��������ʹ��Obejct
	//	stu.setJavaScore(javaScore);//��Object�Դ�
		test(stu1);	//stu1�൱��Object��������ȫ��ͬ��Object
		//�������������ͼ��
		//test(stu);

		/*	test1(stu1);
    	test1(stu);
    	*/
		
	}
	public static void test(Student<Integer> a) {
		
	}
	public void test1(Student<?> a) {
		
	}
}
