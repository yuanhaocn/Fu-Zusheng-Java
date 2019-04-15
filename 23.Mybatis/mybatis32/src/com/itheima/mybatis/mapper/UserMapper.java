package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.User;
/**
 *第一步：配mybatis文件sqlMapConfig.xml，相当于hibernate的applicationContext.xml文件 
 *第二步：配置ORM文件， 建议ORM文件的名字和对应的dao接口名相同
 *<mapper namespace="com.itheima.mybatis.mapper.UserMapper">
	 
		<select id="findUserById" parameterType="Integer" resultType="User">
			select * from user where id = #{v}
		</select>
  </mapper>
  
  第三部：遵循四个原则的基础上写接口
 *
 */
public interface UserMapper {

	
	//遵循四个原则
	//接口 方法名  == User.xml 中 id 名
	//返回值类型  与  Mapper.xml文件中返回值类型要一致
	//方法的入参类型 与Mapper.xml中入参的类型要一致
	//命名空间 绑定此接口
	public User findUserById(Integer id);
	
}
