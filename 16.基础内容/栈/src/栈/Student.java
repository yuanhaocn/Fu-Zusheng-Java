package ջ;
/**
 * stackջ�ṹ
 */
import java.util.Stack;

public class Student {
	private String name;

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Student(String name) {super();this.name = name;}
	public Student() {super();}
	
	public static void main(String[] args) {
		Stack<Student> stack = new Stack<Student>();
		stack.add(new Student("fzs"));//
		stack.add(new Student("son"));//������ʹ�ã��ƻ�ջ�ṹ
		stack.add(new Student("lzy"));//
		Student s1 = new Student();
		s1.setName("zhangping");
		//stack.add(s1);
		stack.push(s1);//ѹջ
		Student result = stack.pop();
		System.out.println(stack);
	}
}
