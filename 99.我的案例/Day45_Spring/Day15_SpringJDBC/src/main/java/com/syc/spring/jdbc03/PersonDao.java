package com.syc.spring.jdbc03;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.syc.spring.domain.Person;

public class PersonDao extends JdbcDaoSupport {

	/*
	 * private JdbcTemplate jdbcTemplate;
	 * 
	 * public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	 * 
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	 * this.jdbcTemplate = jdbcTemplate; }
	 */

	public int updatePerson(Person person) {
		String sql = "update person set name=? where id=?";
		return getJdbcTemplate().update(sql, person.getName(), person.getId());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Person> findAll() {
		String sql = "select * from person";
		// BeanPropertyRowMapper,类似于BeanListHandler
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Person.class));
	}

}
