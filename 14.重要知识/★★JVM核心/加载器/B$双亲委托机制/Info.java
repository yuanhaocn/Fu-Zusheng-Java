package B$双亲委托机制;
/**
 *代理模式：
 *		交给其他加载器来加载指定的类
 *双亲委托机制
 *	就是某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类的加载器，依次追溯，只到最高的爷爷辈的，如果父类加载器
 *可以完成类加载任务，就成功返回，只有父类加载器无法完成此加载任务时，才会自己去加载
 *	双亲委托机制是为了保证java核心库的类型安全
 *		·这种机制就保证不会出现用户自己定义java.lang.Object类的情况
 *	类加载器除了用于加载类，也是安全的最基本屏障
 *双亲委托机制时代理模式的一种
 *	并不是所有的类加载器都采用双亲委托机制
 *	tomcat服务器类加载器也使用代理模式，所不同的是它是首先尝试去加载某个类，如果找不到再代理给父类加载器，这与一般类加载器的顺序是相反的
 */
public class Info {
	public static void main(String[] args) {
		String a= "fzs";
		System.out.println(a.getClass().getClassLoader());//实际加载的是引导类加载器(bootstrap class loader)
		System.out.println(a);
	}
}
