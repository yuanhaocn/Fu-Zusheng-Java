package A$类加载原理;
/**为什么研究类加载的全过程
 * --有助于了解JVM运行过程
 * --更深入了解java动态性，（解热部署，动态加载），提高程序的灵活性
 *
 *类加载全过程
 *类加载机制
 *---JVM把class 文件加载到内存，并对数据进行校验，解析和初始化，最终形成JVM可以直接使用的java类型的过程
 
 	   ____ 连接过程 _____
 加载-->|验证--》装备--》解析|--》初始化--》使用--》卸载
  	   
  ++加载
  	将class文件的字节码（来源丰富，字节码的表现形式就是一个字节数组）内容加载到内存中，并将这些静态数据装换成方法去中的运行时数据结构，再堆中生成一个代表这个类的
  java.lang.Class对象作为方法区数据的访问入口，这个过程需要类加载器参与
  						  ______________
  						 |Class对象------|--》外界可以通过Class对象作为操作类的入口
  class字节码--》类加载器--》 |方法区中运行时数据 | 
  					     |______________|
  ++连接 ：将java类的二进制代码合并到JVM的运行状态中的过程
  		验证：确保加载的类信息符合JVM规范，没有安全方面的问题
  		准备：正式为类变量(static变量)分配内存并设置类变量初始值的阶段（这个时候只是会赋初始值，并不是把class中定义的值赋给他），这些内存都将在方法区中进行分配
  		解析：虚拟机常量池内的符号引用替换为直接引用的过程（类名也是一个常量）
  ++初始化：
  		+初始化阶段是执行类构造器<clinit>()方法的过程，
  			(类加载器：把静态变量（静态域）的静态赋值动作和静态代码块（此时多条静态语句是从上而下执行的） 合并到一起，形成类构造器的执行过程)
  			类构造器<clinit>()方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块（static块）中的语句合并产生的.
  		+当初始化一个类的时候，如果发现其父类还没与进行过初始化，则需要先触发其父类的初始化.
  		+虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确加锁合同步.
  		+当访问一个java类的静态域时，只有真正声明这个域的类才会被初始化.
  		
  类的主动引用（一定会发生类的初始化）
  	new一个类的对象
  	调用类的静态成员(除了fianl常量)和静态方法
  	使用java.lang.reflect包的方法对类进行反射调用
  	当虚拟机启动java Hello，则一定会初始化Hell类，说白了就是先启动main方法所在的类
  	当初始化一个类，如果其父类没有被初始化，则先初始化它的父类
  	
  类的被动引用（不会发生类的初始化）
  	当访问一个静态域是，只有真正声明这个域的类才会被初始化
  		--》通过子类引用父类的静态变量，不会导致子类初始化
  	通过数组定义类引用，不会触发此类的初始化
  	引用变量不会触发此类的初始化(常量在编译阶段就存入调用类的常量池中了)
  
  
  
  深入类加载器
  类缓存：标准的java SE类加载器可以按照要求查找类，但是一旦某个类被加载到类加载器中，它将维持加载（缓存）一段时间，不过JVM垃圾收集器可以回收这些Class对象
  
  实际的工作中使用类加载器的分类(只有引导类加载器不是用java写的)
  	类加载器的层次结构(树状结构)
  	+引导类加载器(bootstrap class loader)
  		它用来加载java的核心库(JAVA_HOME/jre/lib/rt.jar ,或者sun.boot.class.path路径下的内容),是用原生代码(C++)来实现的，并不继承来自
  		java.lang.ClassLoader.
  		加载扩展类和应用程序类加载器，并指定它们的父类加载器
  		
  	+扩展类加载器(extension class loader)
  		用来加载java的扩展库(JAVA_HOME/jre/ext/*.jar, 或java.ext.dirs路径下的内容)
  		java虚拟机的实现会提供一个扩展库目录。该类加载器在此目录里面查找并加载java 类。
  		由sun.misc.launcher$ExtClassLoader实现
  		
  	+应用程序类加载器(application class loader)
  		它根据java应用的类路径(classpath,java.class.path路径)一般来说，java 应用程序的类都是有它来加载，
  		由sun.mis.Launcher$AppClassLoader实现
  		
  	+自定义类加载器
  		开发人员可以通过继承java.lang.ClassLoader类的方法实现自己的类加载器，以满足一些特殊的需求
  		
  树状结构：（组合的关系，不是继承）
  					启动类加载器
						|
  						|
  					扩展类加载器
  						|
  						|
  					应用程序类加载器
  					 |			|
  				自定义类加载器	 自定义类加载器
  		
  		
  		
  除了启动类加载器其他的类加载器都要“继承”java.lang.ClassLoader类
  
  java.lang.ClassLoader类介绍
  	作用：
  		java.lang.ClassLoader类的基本职责就是根据一个指定类的名称，找到或者生成对象的字节代码，然后从这些字节代码
  		中定义出一个java类，即java.lang.Class类的一个实例。
  		除此之外，ClassLoader还负责加载java应用所需要的资源，如图像文件和配置文件等
  	相关方法：
  		·getParent()	返回该类加载器的父加载器
  		·loadClass(String name) 加载名称为name的类，返回的结果是java.lang.Class类的实例
  			··此方法负责加载指定名字的类，首先会从已加载的类中去寻找，如果没有找到；从parent ClassLoader[ExtClassLoader]中加载；如果没有加载
  			··到，则会从bootstrap ClassLoader中尝试加载(findBootStrapClassOrNull方法)如果还是加载失败，则会自己加载，如果还是不能加载，
  			··则会抛出异常ClassNotFoundException。
  			··如果要改变类加载的顺序可以覆盖此方法。
  		·findClass(String name)查找名称为name的类，返回结果是java.lang.Class类的实例
  		·findLoadedClass(Stirng name) 查找名称为name的已经被加载过的类，返回的结果是java.lang.Class类的实例
  		·defineClass(String name,byte[] b,int off,int len)把字节数组b中的内容转换成java类，返回的结果是
  		·java.lang.Class类的实例，这个方法被声明为final的
  		·resolveClass(Class<?> c)连接指定的java类
  	对于以上给出的方法，表示类名称的name参数的值是类的二进制名称，所以注意的是内部类的表示，如con.example.Sample@1和com.example.Sample$Inner等表示方式 
 */
public class info {}






