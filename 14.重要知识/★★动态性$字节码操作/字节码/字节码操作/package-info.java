/**
 * Java字节码操作（动态代理，可以用字节码做，也可以用反射做）
 * Java动态性的两种常见实现方法
 * --字节码操作
 * --反射
 * 
 * 运行时操作字节码可以让我们实现如下功能
 * --生成新的类，就是说我们在一个程序的一个方法里面直接写一个类的代码字符串，然后直接生成一个.class文件；
 * --动态改变某个类的结构（添加/删除/修稿 新的属性/方法）
 * 
 * 优点
 * --比发射开销小，性能高
 * --JAVAassist性能高于反射，低于ASM
 * 
 * 
 *.java-->.class-->jvm加载class文件(os)。所谓的字节码操作就是操作jvm里面加载好的类文件
 *
 *
 *常见的字节码操作类库(BCEL，ASM最快)
 *	BCEL
 *	--Byte Code Engineering Library(BCEL),这是Apache Software Foundation的Jakarta项目的一部分，BCEL
 *是Java classworking广泛使用的一种框架，它可以让你深入JVM汇编语言进行类操作的细节，BCEL与Javaassist有不同的处理字节码
 *的方法，BCEL在实际的JVM指令层次上进行操作，BCEL拥有丰富的JVM指令集支持而Javaassist所强调的就是源代码级别的工作
  
 *ASM
 *--是一种轻量级Java字节码操作框架，直接涉及到JVM底层的操作和指令
  
 *CGLIB(Code Generation Library)
 *--是一个强大的，高性能，高质量的Code生成类库，基于ASM实现
  
 *Javassist
 *--是一个开源的分析，编辑和创建java字节码的类库，性能较ASM差，跟cglib差不多，但是使用简单，很多开源框架都是用它
 
 *
 *Aspect Oriented Programming ：面向切面编程
 *
 *							javassist的最外层的API		用于执行和JDK反射API中
 *  			  			  它主要由CtClass------->>>java.lang.Class
 *               			 CtMethod------------>>>java.lang.reflect.Method
 *              			 CtField几个类组成	----->>>java.lang.reflect.Method.Field
 *相同的操作
 *
 *局限性：
 *--JDK5.0新语法不支持（包括泛型，枚举） 不支持注解修改，但可以通过底层的javassist类来解决，具体参考javassist.bytecode.annotation
 *--不支持数组的初始化，如：String[]{"1","2"},除非只有数组的容量为1
 *--不支持内部类和匿名类
 *--不支持continue和break表达式
 *--对于继承关系，有些不支持，例如
 *----class A{}
 *----class B extends A{}
 *----class C extends B{}
 */
package 字节码操作;