package ��ϣMap$��д;
/**
 * ����Map��ʹ��
 */
import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public void main(String[] args) {
		Map map = new HashMap();
		map.put("����", new Wife("������"));
		map.put("����",new Wife("����"));
		Wife w = (Wife)map.get("����");
		map.remove("����");
		System.out.println(w.name);
	}
}

class Wife{
	String name;
	public Wife(String name) {
		this.name = name;
	}
	
}