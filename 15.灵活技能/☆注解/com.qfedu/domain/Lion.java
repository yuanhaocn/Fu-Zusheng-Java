package domain;

import part01.Annotation02;

@Annotation02(name="animal",value="Lion")
public class Lion {
	@Annotation02(name="name",value="�ǰͿ�")
	private String name;
	@Annotation02(name="show")
	public void show() {
		System.out.println(name+"��˯��������");
	}
	
}
