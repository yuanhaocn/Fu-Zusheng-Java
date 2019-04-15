package E$线程上下文类加载器;
/**
 *双亲委托机制以及类加载器的问题
 *	·一般情况下，保证同一个类中所关联的其他类都是由当前类的类加载器所加载的 
 *		比如，ClassA本身在Ext下找到，那么它里面new 出来的一些类也就只能用Ext去查找了（不会低一个级别），所以有些明明APP可以找到
 *		的，却找不到了
 *	·JDBC API，他有实现driven部分（mysql/sql server） 我们的JDBC API都是由Boot或者Ext来加载的，但是JDBC driver却是由
 *	Ext或者App来加载的，那么就有可能找不到Driver了，在java领域中，其实只要分成这种API+SPI（Service Provide Interface）的，都会遇到此问题
 *	
 *	·常见的SPI有JDBC，JCE,JNDI,JAXP和JBI等这些SPI的接口由java核心库来加载，如javaxp的SPI接口定义包含在javax.xml.parsers包
 *	中，SPI的接口是java核心库的一部分，是由引导类加载器来加载的，SPI实现的java类一般是由系统类加载器来加载的，引导类类加载器是无法找到
 *SPI的实现类的，因为它只加载java的核心库。
 *
 *通常当你需要动态家在资源的时候，你至少有三个ClassLoader可以选择
 *	·1.系统类加载器或叫做引用类加载器
 *	·2.当前类加载器
 *	·3.当前线程类加载器
 *
 *线程类加载器是为了抛弃双亲委派加载链模式
 *	·1.每个线程都有一个关联的上下文类加载器，如果你使用new Thread()方式生成新的线程，新线程将继承其父线程上的上下文类加载器。如果程序对程序上下文
 *类加载器没有任何改动的话，程序中所有的线程将都使用系统类加载器作为上下文加载器
 *Thread.currentThread().getContextClassLoader()
 *Thread.currentThread().setContextClassLoader()
 *
 *TOMCAT服务器的类加载机制
 *	·一切都是为了安全
 *		··TOMCAT不能使用系统默认的类加载器
 *			·如果TOMCAT跑你的WEB项目使用系统的类加载器那时相当危险的，你可以直接是肆无忌惮的操作系统的各个目录了。
 *			·对于运行在JavaEE容器里面种的Web应用来说，类加载器的实现方式与一般的java应用所不同
 *			·每个Web一应用都有一个对应的类加载器实例，该类加载器也使用代理模式（不同于前面说的双亲委托机制），所不同的是它是首先尝试去加载某个
 *			类，如果找不到再代理给父类加载器，这与一般类加载器的顺序是相反的。但也还是为了保证安全，这样核心库就不在查询范围之内
 *	·为了安全TOMCAT需要实现自己的类加载器
 *		··我可以限制你只能把类写在指定的地方，否则我不给你加载！
 *				Bootstrap
 *					|
 *				 System
 *					|
 *				Common
 *				 |	 | 		
 *		  Catalina	Shared
 *					 |  |	
 *				Webapp1 Webapp1....
 *
 *OSGI 原理介绍
 *	OSGI是java上的动态模块系统，它为开发人员提供了面向服务和基于组件的运行环境，并提供标准的方式用来管理软件的生命周期
 *	OSGI已经被实现和部署在很多产品上，在开源社区也得到了广泛的支持，Eclipse就是基于OSGI技术来构建的。
 *原理：
 *	·OSGI中的每个模块(bundle)都包含java包和类。模块可以声明它所依赖的需要导入(import)的其它模块的java包和类(通过Import-Packsge),也可以
 *	声明导入(export)自己的包和类，供其他模块使用(通过Export-Package)。也就是说需要能够隐藏和共享一个模块中的某些java包和类，这就是通过OSGI
 *  特有的类加载器机制来实现的，OSGI中的每个模板都有对应的一个类加载器。他负责加载模块自己包含的java包和类。当它需要加载java核心库的类时(以java 开头的包和类)
 *  ，他会代理给父类加载器(通常是启动类加载器)来完成。当它需要加载所导入的java类时，他会代理给导出此java类的模块来完成加载。模块也可以显示的声明
 *  某些java包和类，必须由父类加载器来加载，只需要设置系统属性org.osgi.framework.bootdelegation的值即可。
 *
 */				
public class Info {

}
