package 单元测试junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

//import static org.junit.Assert.*;//断言注释了，不说

import org.junit.Test;

public class Junit01 {
	@Before	//在每个@Test之前执行一次
	public void testBefor() {
		System.out.println("开始记录日志");
	}
	@After//在每个@Test之后执行一次
	public void testAfter() {
		System.out.println("清理缓存数据");
		//System.err.println("清理缓存数据");,err是错误，会优先显示
	}
	@Test	//JUnit运行的标记，只有方法被打上这个标记的时候才可以运行
	public void test() {
		//fail("Not yet implemented");
		System.out.println("hello");
	}
	@Test
	public void test01() {
		System.out.println(3);
	}
	@Ignore //忽略的意思，被此修饰不会执行，或者什么也不写二者等效
	public void test02() {
		System.out.println(3/0);
	}
	
}
