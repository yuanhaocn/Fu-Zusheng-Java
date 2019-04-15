package B$泛型接口类方法;
/**
泛型类：定义类时使用泛型（又叫菱形语法）
   class 类名<字母列表>{
   		修饰符 字母 属性；
   		修饰符 构造器（形参列表）{
   	}
   		修饰符 返回类型 方法（形参列表）{
   	}
   }
    
 * 泛型常见字母：
 	* -T Type 表示类型
 	* -K V分别表示键值对中的Key,Value
 	* -E 代表Element
 	* -? 表示不确定的类型
 *  --泛型声明时字母不能使用在静态属性，静态方法上
 *  使用时指定具体类型 
 		*   a:编译时会进行类型检查；
 		*   b:获取数据是不需要强制类型转换
 *  --泛型使用时不能指定基本类型，不能使用基本类型。
 */
public class Student<T1,T2> {		//多少个字母没有限制	
	private T1 javaScore;
	private T2 oracleScore;
	
	public T1 getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}
	public T2 getOracleScore() {
		return oracleScore;
	}
	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}
	
	@Override
	public String toString() {
		return "Student [javaScore=" + javaScore + ", oracleScore=" + oracleScore + "]";
	}
	public static void main(String[]  args) {
		//泛型在使用时指定类型
		Student<String,Integer> stu = new Student<String,Integer>();
		//1，安全：类型检查
		stu.setJavaScore("优秀");
		//2，省心：类型转换
	//	Integer it = stu.getOracleScore();
		int it = stu.getOracleScore(); //使用int 也行，自动拆箱
		
	}
}
