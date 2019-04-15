package C反射读取注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtTable {
	/*
	 *只有一个参数
	 */
	String value();
}
