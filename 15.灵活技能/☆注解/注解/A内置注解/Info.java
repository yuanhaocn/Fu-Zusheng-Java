package A内置注解;
/**
 * 什么是注解：
 * Annotation是从JDK5.0开始引入的新技术
 *  Annotation的作用：
 *  	不是程序本身，可以对程序做出解释。（这一点跟注释没什么区别）
 *  	可以被其他程序（比如：编辑器等）读取，（注解信息处理流程，是注解和注释的重大区别，如果没有注解信息处理流程，则注解毫无意义）
 *Annotation的格式
 *		注解是以“@注解名” 在代码中存在的，还可以添加一些参数值，例如@SuppressWarning(value="unchecked");
 *Annotation在哪里使用：
 *		可以附加在package,class,method,field等上面，相当于给他添加了额外的辅助信息，我们通过反射机制编辑实现对这些数据的访问。
 *内置注解
 *	@Override
 *	定义在java.lang.Override中，此注释只适用于修饰方法，表示一个方法打算重写超类中的另一个方法声明
 *	@deprecated
 *	定义在java.lang.Deprecated中，此注释可用于修饰方法，属性，类，表示不鼓励程序员使用这样的元素，通常是因为它很危险或者存在更好的选择
 *	@SuppressWarnings
 *	定义在java.lang.SuppressWarnings中，用来抑制编译时的警告信息
 *	与之前的两个注释有所不同，你需要添加一个参数才能正确使用，这些参数数值都已经定义好了，我们选择使用就好，参数如下
 *   参数				说明
 *  deprecation	使用了过时的类或者方法的警告
 *  unchecked	执行了未检查的转换时的警告，如使用集合时未指定泛型
 *  fallthrough	当在switch语句使用时发生case穿透
 *  path		在类路径，源文件路径等中有不存在路径的警告
 *  serial		当在可序列化的类上缺少serialVersionUID定义时的警告
 *  finally		任何finally子句不能完成时的警告
 *  all			关于以上所有情况的警告
 *  压制多个时
 *  @SuppressWarnings(value={"unchecked","deprecation"})
 */
public class Info {}
