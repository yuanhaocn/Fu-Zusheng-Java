package com.syc.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.syc.mybatis.domain.Person;
import com.syc.mybatis.domain.PersonExample;
import com.syc.mybatis.domain.PersonExample.Criteria;
import com.syc.mybatis.mapper.PersonMapper;
import com.syc.mybatis.utils.MybatisUtil;

public class MapperTest {

	@Test
	public void findByIdTest() {
		SqlSession session = MybatisUtil.getSession();

		PersonMapper mapper = session.getMapper(PersonMapper.class);
		// 根据id进行查询
		Person person = mapper.selectByPrimaryKey(3);
		System.out.println("name=" + person.getName());

		session.close();
	}

	@Test
	public void findByExampleTest() {
		SqlSession session = MybatisUtil.getSession();

		PersonMapper mapper = session.getMapper(PersonMapper.class);

		PersonExample example = new PersonExample();

		// 根据name进行查询
		// 取出重复数据
		// example.setDistinct(true);
		// 创建一个Criteria内部类对象
		Criteria criteria = example.createCriteria();
		// 根据某一列,给条件赋值
		// criteria.andNameEqualTo("林冲");

		// 查询昵称中带"李"的人
		criteria.andNicknameLike("%李%");

		// 根据example进行查询
		List<Person> persons = mapper.selectByExample(example);

		for (Person person : persons) {
			System.out.println("name=" + person.getName());
		}

		session.close();
	}

	@Test
	public void insertTest() {
		SqlSession session = MybatisUtil.getSession();

		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = new Person();
		person.setName("顾大嫂");

		// int result = mapper.insert(person);

		// xxxSelective:用来过滤掉值=null的列!和hibernate中的dynaicInsert与dynamicUpdate作用类似.
		int result = mapper.insertSelective(person);
		System.out.println("result=" + result);

		session.commit();
		session.close();
	}

	@Test
	public void deleteTest() {
		SqlSession session = MybatisUtil.getSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);

		// 根据id进行删除
		// int result = mapper.deleteByPrimaryKey(33);

		PersonExample example = new PersonExample();
		example.createCriteria().andNameEqualTo("孙二娘");
		int result = mapper.deleteByExample(example);

		System.out.println("result=" + result);

		session.commit();
		session.close();
	}
	
	@Test
	public void updateTest() {
		SqlSession session = MybatisUtil.getSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		
		//Person person = mapper.selectByPrimaryKey(3);
		
		Person person=new Person();
		//person.setPid(3);
		person.setNickname("小猫头");
		
		//根据主键更新
		//int result = mapper.updateByPrimaryKeySelective(person);
		
		//根据姓名进行更新
		PersonExample example=new PersonExample();
		example.createCriteria().andNameEqualTo("林冲");
		
		int result = mapper.updateByExampleSelective(person, example);
		
		System.out.println("result=" + result);
		
		session.commit();
		session.close();
	}
}
