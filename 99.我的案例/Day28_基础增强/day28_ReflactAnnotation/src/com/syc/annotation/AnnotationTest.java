package com.syc.annotation;

import java.lang.reflect.Field;

import org.junit.Test;

public class AnnotationTest {

	@Test
	public void annotationTest() {
		Person p = new Person();
		p.setId(1);
		p.setName("林冲");
		p.setSex("男");

		// 要求:往person表中插入数据,1,林冲,男.
		// String sql="insert into person values(1,林冲,男)";

		// 加入有个dao类,里面有个save()方法,接收Person类型的参数,只要Person对象
		// 里面封装了数据,就可以自动的将Person对象的中的数据添加到person表中.
		// dao.save(p);

		// 实现的原理就是ORM框架---:反射+注解!

		// 获取类字节码的方式:
		// ①.Person.class;
		// ②.p.getClass();
		// ③.Class.forName("完整的包名+类名");
		// 获取公开的方法
		// clazz.getMethod(name, parameterTypes)
		// 获取所有声明的方法,包括公开和私有的方法
		// clazz.getDeclaredMethod(name, parameterTypes)
		// clazz.getField(name)
		// clazz.getDeclaredField(name)
		// clazz.getConstructor(parameterTypes)
		// clazz.getDeclaredConstructor(parameterTypes);
		// clazz.getAnnotation(annotationClass)
		// clazz.getDeclaredConstructor(parameterTypes)

		try {
			Class<? extends Person> clazz = p.getClass();
			// 获取TableName注解
			TableName tblAnnotation = clazz.getAnnotation(TableName.class);
			// 获取注解的值
			String tableName = tblAnnotation.value();
			System.out.println("表名:" + tableName);

			// 获取所有的属性
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				// 暴力反射--->"强暴"
				field.setAccessible(true);
				// 去属性上去注解
				Column columnAnnotation = field.getAnnotation(Column.class);
				String columnName = columnAnnotation.value();
				System.out.println("列名:" + columnName);

				// 注解
				ID idAnnotation = field.getAnnotation(ID.class);
				if (idAnnotation != null) {
					int id = 0;
					// 主键
					if (idAnnotation.isAutoIncrement()) {
						// 主键自增长
						id = (int) field.get(p);
						//主键自增长的时候,可以不处理主键.
					} else {
						// 主键非自增长
						id = (int) field.get(p);
						//非自增长的时候可以手动给主键插入值
					}
					System.out.println("ID="+id);
				} else {
					// p.setId(1);
					// field.get(p);
					String value = (String) field.get(p);
					System.out.println("Value=" + value);
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}
