package com.digesterdemo;
/**
 *  1.addObjectCreate(String rule,Class class)
		���ýڵ���Java�����ӳ�����ruleָ���ڵ��ɸѡ����class����ӳ�����
		SAX����ʱ������ruleָ���Ľڽڵ㣬�ᴴ��һ��classʵ�������ջ�С�
		���磺digester.addObectCreate("database/user","com.model.UserBean").��������user�ڵ�ʱ���ᴴ��һ��UserBeanʵ���������ջ�С�
		
	2.addSetProperties(String rule)
		���ýڵ���������ù��򡣵�������������rule�Ľڵ�ʱ�����������б��е�����ֵ�ԣ�ʹ��Java�������ʹ�ñ�׼��JavaBean��������ջ������ʵ����
		���磺digester.addSetProperties("database/user"),��������user�ڵ�ʱ�����ȡ��ֵ�� userName=guest,password=guest��
		���ջ����UserBean��������ʵ����userName��password���ԣ�����Ԫ���ϵ����� 
		
	3.addBeanPropertySetter(String rule)
		�÷��������ü�ʹ�÷���������addSetProperties��ֻ����������rule��ָ���ı�ǩ�����ö����setter���÷�����tomcat6��ò��û�С� 
		tomcat6��Digester��·��Ϊ��import org.apache.tomcat.util.digester.Digester;
		��Ϊ��import org.apache.commons.digester.Digester;
		
	4.addSetNext(String rule,String methodName)
		���õ�ǰrule�ڵ��븸�ڵ�ĵ��ù��򣬵�����rule�ڵ�ʱ�����ö�ջ�еĴ�ջ��Ԫ�ص���methodName��������ջ��Ԫ����Ϊ�ζ�Ԫ��ָ�����������������
		����:digester.addSetNext("database/user","addUser"),����databaseʵ����addUser��userΪ����
		
	5.addCallMethod(String rule,String methodName,int paraNumber)
		�÷���ͬ�����ö�������ԣ�������������Ҫ�������setter����rule����ָ�������ԣ����ö����methodName������
		paraNumber�����Ǳ�ʾ������Ҫ�Ĳ�����������paraNumber=0ʱ�����Ե���ʹ�ã���Ȼ��Ҫ���addCallParam����
		����:digester.addCallMethod("database/user/uerName","setUserName",0);
		
	6.addCallParam(String rule,int paraIndex,String attributeName)
		�÷�����addCallMethod���ʹ�ã�����ruleָ���ı�ǩ���������÷���paraIndex������Ҫ���ķ����β���ţ���0��ʼ��������addCallMethdoָ����
		attributeNameָ����ǩ��������
		ʹ��ע������:

   1.Digester����õ�˳��,������XML�����ļ�����һ��;
   2.Digester��������JavaBean�淶,�������Ϲ淶;
   3.XML�ļ��б�ǩ/���Ե����Ʊ�����Bean�е�һ��(������Сд);
 ==================================================================
		<?xml version="1.0" encoding="UTF-8" ?>
			<Server port="9996" debug="0">
			  <Listener className="org.apache.catalina.mbeans.ServerLifecycleListener" debug="0"/>
			  <Listener className="org.apache.catalina.mbeans.GlobalResourcesLifecycleListener" debug="1"/>
			  
			 	<Service name="Catalina">
			    	<Engine engineType="12">I am a Engine</Engine>
			  	</Service>
			</Server>
 �ؼ�����˵��
(1)serverDigester.addObjectCreate("Server","com.test.server.digester.Server")
	������xml�ļ�ʱ��������Server���ͳ�ʼ��һ����com.test.server.digester.Server�����󣬲��ҰѸö���ѹ��ջ��
	
(2)serverDigester.addSetProperties("Server", "port", "port")
	��Server����ע��port���ԣ���������Server�ڵ��port����ʱ����Server��setPort����
	
(3)serverDigester.addSetNext("Server/Listener", "addListener","com.test.server.digester.Listener")
	������Server�ڵ��µ�Listener�ڵ��ʱ�򣬵���Server�����addListener�������ѵ�ǰListener����д�뵽Server�����С�
	����Server�ڵ����ж��ٸ�Listener�ڵ㣬�������addListener����
	
(4)serverDigester.addCallMethod("Server/Service/Engine", "setEngine", 0)
	Service�����Engine,���õ�ǰtop object��setEngine��������������Ϊ0
	addCallMethod��addBeanPropertySetter�����ȼ�
 */
import java.io.File;

import org.apache.commons.digester3.Digester;

public class DigesterDemo01 {

	public static void main(String[] args) throws Exception { 
	//1����digester����
		Digester digester = new Digester();
		
	//2.ָ��java��xml��ǩ�Ķ�Ӧ����
		digester.addObjectCreate("Users", Users.class);
		digester.addObjectCreate("Users/User", User.class);
	//3.���Ǹ�����ǩ֮��Ĺ�ϵ
		digester.addSetProperties("Users/User");
	//4.Ϊ��ǰ����ָ������ù���ķ���
		digester.addSetNext("Users/User", "addUser");
		
		
	//5.ʹ��xml�ļ�·�������ļ�����
		File file = new File("C://Users//FZS//eclipse-workspace//Day10pm//src//com//digsterdemo//User.xml");
	//6.����xml�ļ����н����������ص㣡����
		Users users = (Users)digester.parse(file);
	//7.��ӡ����
		System.out.println(users);
	}
}