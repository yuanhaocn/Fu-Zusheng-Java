package B�Զ���ע��;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String studentName() default "";
	int age() default 0;
	int id() default -1;
	String[]  school() default {"�廪��ѧ","������ѧ"};
}	

class Demo{
	@MyAnnotation(age=19,studentName="fzs",id=1001,school= {"�Ͼ���ѧ","�人��ѧ"})
	public void add() {
	}
}