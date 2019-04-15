package 哈希Map$手写;
/**
 * 测试Map的使用
 */
import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public void main(String[] args) {
		Map map = new HashMap();
		map.put("高企", new Wife("张曼玉"));
		map.put("张三",new Wife("杨幂"));
		Wife w = (Wife)map.get("高企");
		map.remove("高企");
		System.out.println(w.name);
	}
}

class Wife{
	String name;
	public Wife(String name) {
		this.name = name;
	}
	
}