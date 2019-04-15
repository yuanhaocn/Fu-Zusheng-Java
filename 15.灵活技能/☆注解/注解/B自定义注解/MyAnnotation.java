package B自定义注解;

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
	String[]  school() default {"清华大学","北京大学"};
}	

class Demo{
	@MyAnnotation(age=19,studentName="fzs",id=1001,school= {"南京大学","武汉大学"})
	public void add() {
	}
}