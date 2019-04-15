package com.syc.struts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DataAction04 extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Person> persons;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String execute() throws Exception {

		persons=new ArrayList<Person>();
		
		persons.add(new Person("武松","行者",30));
		persons.add(new Person("林冲","豹子头",30));
		persons.add(new Person("孙二娘","母夜叉",30));
		persons.add(new Person("扈三娘","一丈青",30));
		persons.add(new Person("吴用","智多星",30));
		persons.add(new Person("卢俊义","玉麒麟",30));
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("persons", persons);
		
		return super.execute();
	}
}
