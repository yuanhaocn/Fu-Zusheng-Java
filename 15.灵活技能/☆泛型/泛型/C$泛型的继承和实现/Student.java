package C$泛型的继承和实现;
/**
 * 117节16分钟出一点都没听懂
 * 泛型的擦除
 * 1，继承声明不指定类型
 * 2，使用时不指定类型
 * 统一Object对待
 * a,编译器的警告，消除警告使用Object
 * b,不完全等同于Object，编译不会类型检查
 * @author FZS
 *
 * @param <T>
 */
public class Student<T> {		//多少个字母没有限制	
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
		Student<Object> stu = new Student<>();	//消除警告使用Obejct
	//	stu.setJavaScore(javaScore);//以Object对待
		test(stu1);	//stu1相当于Object但不是完全等同于Object
		//擦除，不会类型检查
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
