package com.syc.dao.mapper;

import java.util.List;

import com.syc.dao.domain.Person;

/*
 * 把要实现的方法,在接口中抽取出来.
 * 1.接口名称必须和映射文件的名称一样;
 * 2.接口中的方法的名称必须和映射文件中对应的标签的id一样;
 * 3.接口文件和映射文件最后最好在同一目录下;
 * 4.映射文件中namespace的值必须是接口的全路径!
 */
public interface PersonMapper {

	public Person findById(int id);
	
	public Person findByName(String name);
	
	public List<Person> findAll();
	
	public int addPerson(Person person);
	
	public int updatePerson(Person person);
	
	//deleteXXX
}
