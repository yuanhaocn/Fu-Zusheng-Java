package 对象的clone方法复制;

import java.util.Date;

/**
 * 测试原型模式(浅克隆)
 * @author 尚学堂高淇 www.sxt.cn
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Date date = new Date(12312321331L);
		Sheep s1 = new Sheep("少利",date);
		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		//浅层复制的意思是，复制s1的全部值和引用，所以s1和s2的Birthday指向了同一个date，如果date变了，都会变变化
		date.setTime(23432432423L);
		//深层复制的意思是，复制s1的全部值和并且把s1的Birthday所指向的对象new Date(12312321331L);也复制一份给自己用，
		//所以s1和s2的Birthday指向了不同一个date，互不干扰
		System.out.println(s1.getBirthday());
		
		Sheep s2 = (Sheep) s1.clone();
		s2.setSname("多利");
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());
		
		
	}
}
