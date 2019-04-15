package A$无泛型存变类型数据;
/**
 * 泛型
 * @author FZS
 *
 */
public class Student {
	private Object javase;
	private Object oracle;
	 
	public Student() {
		super();
	}
	public Student(Object javase, Object oracle) {
		super();
		this.javase = javase;
		this.oracle = oracle;
	}
	public Object getJavase() {
		return javase;
	}
	public void setJavase(Object javase) {
		this.javase = javase;
	}
	public Object getOracle() {
		return oracle;
	}
	public void setOracle(Object oracle) {
		this.oracle = oracle;
	}
	
}
