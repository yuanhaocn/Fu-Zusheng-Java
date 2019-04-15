package com.syc.struts;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class DataAction05 extends ActionSupport {

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
		
		persons.add(new Person("武松","行者",22));
		persons.add(new Person("林冲","豹子头",30));
		persons.add(new Person("孙二娘","母夜叉",34));
		persons.add(new Person("扈三娘","一丈青",18));
		persons.add(new Person("吴用","智多星",50));
		persons.add(new Person("卢俊义","玉麒麟",35));
		persons.add(new Person("花荣","小李广",19));
		
		//HttpServletRequest request = ServletActionContext.getRequest();
		//request.setAttribute("persons", persons);
		
		return super.execute();
	}
}
