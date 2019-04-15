package 动态代理.exp1;
/**
 * 动态代理模式:动态代理类的源码是在程序运行期间通过JVM反射等机制动态生成，代理类和委托类的关系是运行时才确定的。
 *  
 *接口
 */
public interface IUserDao {
 void save();
 void find();
}