package com.syc.freemarker;

public class ${ClassName} {

	private Integer ${id};
	private String ${name};

	public ${ClassName}() {
	}
	
	public String get${id?cap_first}() {
		return id;
	}

	public void set${id?cap_first}(String id) {
		this.id = id;
	}

	public String get${name?cap_first}() {
		return name;
	}

	public void set${name?cap_first}(String name) {
		this.name = name;
	}
}
