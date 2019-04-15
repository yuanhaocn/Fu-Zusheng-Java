package 脚本引擎;

import javax.script.*;

/**
 * java脚本引擎执行JavaScript代码
 * 脚本引擎介绍：
 * 	使得Java应用程序可以通过一套固定的接口与各种脚本引擎交互，从而达到在Java平台上调用各种脚本语言的目的
 * 	Java脚本API是联通Java平台和脚本语言的桥梁
 * 	可以把一些复杂异变的业务逻辑交给脚本语言处理，这又大大提高了开发效率
 * 
 * 脚本引擎是介于Java平台和脚本引擎之间的平台
 * Java脚本API为开发者提供了如下功能
 * 	获取脚本程序输入，通过脚本引擎运行脚本并返回运行结果，这是最核心的接口
 * 		注意是：接口。Java可以使用各种不同的实现，从而通用的调用js，groovy，python等脚本
 * 			js使用了Rhino
 * 					Rhino是一种使用Java语言编写的JavaScript的开源实现，原先由Mozilla开发，现在被集成进入JDK6.0
 * 		通过脚本引擎的运行上下文在脚本和Java平台间交换数据
 * 		通过Java应用程序调用脚本函数			
 */
public class Info {
	public static void main(String[] args) throws Exception {
		//获得脚本对象
		ScriptEngineManager sem = new ScriptEngineManager();//脚本引擎管理器
		ScriptEngine engine = sem.getEngineByName("javascript");//脚本引擎的名字
		/*
		 * js脚本代码
		 */
		//定义一个名字，就是一个键值对,会存贮到引擎的上下文
		engine.put("msg", "fzs is good man!");
		String str = "var user = {name:'fzs',age:18,schools:['安徽工程大学','programmer']};";
		str +="println(user.name);";
		/*
		 * 执行脚本
		 */
		engine.eval(str);
		engine.eval("msg='lzy is a good girl';");
		System.out.println(engine.get("msg"));
	}
}
