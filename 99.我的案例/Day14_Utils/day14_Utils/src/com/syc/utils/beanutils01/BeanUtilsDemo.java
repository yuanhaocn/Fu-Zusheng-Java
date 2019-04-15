package com.syc.utils.beanutils01;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import com.syc.utils.bean.User;

/**
 * 学习BeanUtils的使用
 * 
 * @类名称:BeanUtilsDemo
 * @创建人:SYC
 * @创建时间:2017年7月13日 上午10:33:59
 */
public class BeanUtilsDemo {

	@Test
	public void demo1() {

		User user = new User();

		// 1.没有beanutils的使用,给JavaBean赋值的方式:
		// user.setId(1);
		// user.setUsername("三胖");
		// user.setPassword("111");

		try {
			// 2.利用BeanUtils进行简化
			// 赋值.注意:name的值必须与JavaBean中属性的名称一致!
			// BeanUtils.setProperty(user, "id", "1");
			// BeanUtils.setProperty(user, "username", "二呆");
			// BeanUtils.setProperty(user, "password", "222");

			// setProperty()方法,会尽可能的给你进行值与类型之间的转换.
			// copyProperty()方法,一般不会将值和它对应的类型进行转换.
			// java.util.Date与java.sql.Date.

			// 赋值的第二个方法:copyProperty(obj,name,value)
			BeanUtils.copyProperty(user, "id", "2");
			BeanUtils.copyProperty(user, "username", "三胖");
			BeanUtils.copyProperty(user, "password", "333");

			// 获取对应属性值的方法.
			// String id = BeanUtils.getProperty(user, "id");
			// String name = BeanUtils.getProperty(user, "username");
			// String pwd = BeanUtils.getProperty(user, "password");
			// System.out.println("ID="+id+",Name="+name+",Pwd="+pwd);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println("ID=" + user.getId());
		System.out.println("UserName=" + user.getUsername());
		System.out.println("PassWord=" + user.getPassword());
	}

	@Test
	public void demo2() {
		try {
			User user = new User();
			// Map<String, String[]> map = request.getParameterMap();

			Map<String, Object> map = new HashMap<>();
			map.put("id", 3);
			map.put("username", "三炮");
			map.put("password", "333");

			// 会将map集合里的值封装到user对象中.
			BeanUtils.populate(user, map);

			System.out.println("ID=" + user.getId());
			System.out.println("UserName=" + user.getUsername());
			System.out.println("PassWord=" + user.getPassword());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void demo3() {
		try {
			User user = new User();
			BeanUtils.setProperty(user, "id", "1");
			BeanUtils.setProperty(user, "username", "二呆");
			BeanUtils.setProperty(user, "password", "222");

			// 复制....,将user复制为newUser对象.
			// 注意:cloneBean()方法不要求给类中的每个属性都要赋值.
			// User newUser = (User) BeanUtils.cloneBean(user);

			User newUser = new User();
			// 注意:copyProperties()方法要求给类中的每个属性都要赋值.
			BeanUtils.copyProperties(newUser, user);

			System.out.println("ID=" + newUser.getId());
			System.out.println("UserName=" + newUser.getUsername());
			System.out.println("PassWord=" + newUser.getPassword());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void demo4() {
		try {
			User user = new User();

			// 默认情况下,BeanUtils不能把String转为util.Date;
			// 我们就自己写一个转换器,将String转为util.Date;
			ConvertUtils.register(new Converter() {
				// 转换方法
				@SuppressWarnings("rawtypes")
				@Override
				public Object convert(Class clazz, Object value) {
					// 判断类型是否是util.Date类型
					if (clazz != Date.class) {
						return null;
					}
					//判断是否为空串
					if (value == null || "".equals(value.toString().trim())) {
						return null;
					}
					try {
						//自定义转换格式
						SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
						//将value转为obj
						return format.parse(value.toString());
					} catch (ParseException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			}, Date.class);

			BeanUtils.setProperty(user, "id", 1);
			BeanUtils.setProperty(user, "username", "大傻");
			BeanUtils.setProperty(user, "password", "111");
			// org.apache.commons.beanutils.ConversionException:
			// DateConverter does not support default String to 'Date'
			// conversion.
			// 注意:BeanUtils默认情况下,无法将时间日期类型的字符串转化为java.util.Date.
			// 但是默认支持将日期时间字符串自动转换为java.sql.Date.
			BeanUtils.setProperty(user, "birthDay", "2017-07-13");

			System.out.println("ID=" + user.getId());
			System.out.println("UserName=" + user.getUsername());
			System.out.println("PassWord=" + user.getPassword());
			System.out.println("BirthDay=" + user.getBirthDay());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void demo5() {
		try {
			User user = new User();

			// 默认情况下,BeanUtils不能把String转为util.Date;
			// 我们就自己写一个转换器,将String转为util.Date;
			
			//使用beanUtil包中自带的日期时间转换器.
			ConvertUtils.register(new DateLocaleConverter(), Date.class);

			BeanUtils.setProperty(user, "id", 1);
			BeanUtils.setProperty(user, "username", "大傻");
			BeanUtils.setProperty(user, "password", "111");
			// org.apache.commons.beanutils.ConversionException:
			// DateConverter does not support default String to 'Date'
			// conversion.
			// 注意:BeanUtils默认情况下,无法将时间日期类型的字符串转化为java.util.Date.
			// 但是默认支持将日期时间字符串自动转换为java.sql.Date.
			BeanUtils.setProperty(user, "birthDay", "2017-07-13");

			System.out.println("ID=" + user.getId());
			System.out.println("UserName=" + user.getUsername());
			System.out.println("PassWord=" + user.getPassword());
			System.out.println("BirthDay=" + user.getBirthDay());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
