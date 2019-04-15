package com.digesterdemo;
/**
 *  1.addObjectCreate(String rule,Class class)
		设置节点与Java对象的映射规则，rule指定节点的筛选规则，class设置映射对象。
		SAX解析时，遇到rule指定的节节点，会创建一个class实例放入堆栈中。
		比如：digester.addObectCreate("database/user","com.model.UserBean").解析遇到user节点时，会创建一个UserBean实例并放入堆栈中。
		
	2.addSetProperties(String rule)
		设置节点的属性设置规则。当解析遇到符合rule的节点时，根据属性列表中的属性值对，使用Java反射机制使用标准的JavaBean方法设置栈顶对象实例；
		比如：digester.addSetProperties("database/user"),解析遇到user节点时，会获取键值对 userName=guest,password=guest，
		获得栈顶的UserBean对象，设置实例的userName、password属性；解析元素上的属性 
		
	3.addBeanPropertySetter(String rule)
		该方法的作用及使用方法类似于addSetProperties，只不过它是用rule所指定的标签来调用对象的setter。该方法在tomcat6中貌似没有。 
		tomcat6中Digester类路径为：import org.apache.tomcat.util.digester.Digester;
		不为：import org.apache.commons.digester.Digester;
		
	4.addSetNext(String rule,String methodName)
		设置当前rule节点与父节点的调用规则，当遇到rule节点时，调用堆栈中的次栈顶元素调用methodName方法。将栈顶元素作为次顶元素指定方法的输入参数。
		比如:digester.addSetNext("database/user","addUser"),调用database实例的addUser，user为参数
		
	5.addCallMethod(String rule,String methodName,int paraNumber)
		该方法同样设置对象的属性，但更加灵活，不需要对象具有setter根据rule规则指定的属性，调用对象的methodName方法，
		paraNumber参数是表示方法需要的参数个数，当paraNumber=0时，可以单独使用，不然需要配合addCallParam方法
		比如:digester.addCallMethod("database/user/uerName","setUserName",0);
		
	6.addCallParam(String rule,int paraIndex,String attributeName)
		该方法与addCallMethod配合使用，根据rule指定的标签属性来调用方法paraIndex表明需要填充的方法形参序号，从0开始，方法由addCallMethdo指定，
		attributeName指定标签属性名；
		使用注意事项:

   1.Digester类调用的顺序,必须与XML数据文件绝对一致;
   2.Digester类依赖于JavaBean规范,类必须符合规范;
   3.XML文件中标签/属性的名称必须与Bean中的一致(包括大小写);
 ==================================================================
		<?xml version="1.0" encoding="UTF-8" ?>
			<Server port="9996" debug="0">
			  <Listener className="org.apache.catalina.mbeans.ServerLifecycleListener" debug="0"/>
			  <Listener className="org.apache.catalina.mbeans.GlobalResourcesLifecycleListener" debug="1"/>
			  
			 	<Service name="Catalina">
			    	<Engine engineType="12">I am a Engine</Engine>
			  	</Service>
			</Server>
 关键方法说明
(1)serverDigester.addObjectCreate("Server","com.test.server.digester.Server")
	当解析xml文件时，遇到“Server”就初始化一个“com.test.server.digester.Server”对象，并且把该对象压入栈顶
	
(2)serverDigester.addSetProperties("Server", "port", "port")
	给Server对象注册port属性，当解析到Server节点的port属性时调用Server的setPort方法
	
(3)serverDigester.addSetNext("Server/Listener", "addListener","com.test.server.digester.Listener")
	当解析Server节点下的Listener节点的时候，调用Server对象的addListener方法，把当前Listener对象写入到Server对象中。
	无论Server节点下有多少个Listener节点，都会调用addListener方法
	
(4)serverDigester.addCallMethod("Server/Service/Engine", "setEngine", 0)
	Service中添加Engine,调用当前top object的setEngine函数，参数个数为0
	addCallMethod与addBeanPropertySetter方法等价
 */
import java.io.File;

import org.apache.commons.digester3.Digester;

public class DigesterDemo01 {

	public static void main(String[] args) throws Exception { 
	//1构建digester对象
		Digester digester = new Digester();
		
	//2.指定java和xml标签的对应规则
		digester.addObjectCreate("Users", Users.class);
		digester.addObjectCreate("Users/User", User.class);
	//3.考虑各个标签之间的关系
		digester.addSetProperties("Users/User");
	//4.为当前规则指定满足该规则的方法
		digester.addSetNext("Users/User", "addUser");
		
		
	//5.使用xml文件路径构建文件对象
		File file = new File("C://Users//FZS//eclipse-workspace//Day10pm//src//com//digsterdemo//User.xml");
	//6.根据xml文件进行解析。。。重点！！！
		Users users = (Users)digester.parse(file);
	//7.打印对象
		System.out.println(users);
	}
}