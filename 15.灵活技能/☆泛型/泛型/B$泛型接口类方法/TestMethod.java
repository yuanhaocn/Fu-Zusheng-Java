package B$泛型接口类方法;

import java.io.Closeable;
import java.io.IOException;

/**
 * 泛型方法   <>返回类型前面
 * 只能访问对象的信息，不能修改信息
 
定义使用：<字母>

   	修饰符<字母>返回类型 方法名（形参列表）{
   	}
   	
   要定义泛型方法，只需要将泛型参数列表置于返回值前。
  * 注意：泛型还可以定义在方法中，是否拥有泛型方法，与其所在的类是否泛型没有关系
 */
public class TestMethod {

	public static <T extends Closeable> void test(T... a) {		//这就是泛型方法
		for(T temp:a) {
			try {
				if(null != temp) {
				temp.close();	
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}   
		System.out.println(a);
	  }
	public static void main(String[] args) {
	//	test("a");		//T-->String 
	}
}
