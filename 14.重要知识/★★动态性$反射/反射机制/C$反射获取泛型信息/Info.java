package C$反射获取泛型信息;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import A$反射机制.User;

/**
 *反射机制性能问题
 *setAccessible 
 * 启用和禁用访问安全检查的开关，值为true则指示反射的对象在使用时应该取消java语言访问检查，
 * 						  值为false则指示反射对象应该实施java语言访问检查，
 * 并不是为true就能访问为false就不能访问
 * 禁用安全检查，可以提高反射的运行速度(提高4倍)，差不多比普通方法调用慢3倍
 * 
 * 反射操作泛型
 * 	java采用泛型擦除的值来引入泛型，Java中的泛型仅仅是给编译器javac使用的，确保数据的安全性和免去强制类型转换的麻烦，但是一旦编译完成
 * ，所有的和泛型有关的类型全部擦除
 * 
 * 为了通过反射操作这些类型，以迎合实际开发的需要，javac就新增了ParameterizedType,GenericArrayType,TypeVariable和
 * WildcardType几种类型来代表不能被归一到Class类中的类型但是又和原始类型齐名的类型
 * 
 * ParameterizedType：表示一种参数化得类型，比如Collection<String>
 * GenericArrayType:表示一种元素类型是参数化类型或者类型变量的数组类型
 * TypeVariable：是各种类型变量的公共父接口
 * WildcardType：代表一种通配符类型表达式，比如?,? extends Number,? super Integer(Wildcard就是通配符的意思)
 */
public class Info {

	public void test01(Map<String,User>map,List<User> list) {
		System.out.println("Info.test01");
	}
	public Map<Integer,User> test02(){
		System.out.println("Info.test02");
		return null;
	}
	
	
	public static void main(String[] args) {
		try {
			Method m = Info.class.getMethod("test01", Map.class,List.class);
			Type[] t = m.getGenericParameterTypes();//获得带泛型参数类型
			
			for (Type paramtype : t) {
				System.out.println("#"+paramtype);
				if(paramtype instanceof ParameterizedType) {
					Type[] genericTypes= ((ParameterizedType)paramtype).getActualTypeArguments();
					for (Type genericType : genericTypes) {
						System.out.println("泛型类型："+genericType);
					} 
				}
			}
			
			
		//获得指定方法返回值泛型信息
			Method m2 = Info.class.getMethod("test02", null);
			Type returnType = m2.getGenericReturnType();//获得带泛型的返回类型
			if(returnType instanceof ParameterizedType) {
				Type[] genericTypes= ((ParameterizedType)returnType).getActualTypeArguments();
				
				for (Type genericType : genericTypes) {
					System.out.println("返回值，泛型类型："+genericType);
				} 
			}
} catch (Exception e) {e.printStackTrace();}}}
