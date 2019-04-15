package 用集合存表信息;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testo2 {

	public static void printEmployee(List<Map> list) {		//意思是传进来的list只能是Employee不能是别的
		for(int i=0; i<list.size();i++) {
			Map tempMap = list.get(i);
			System.out.println(tempMap.get("name")+"--"+tempMap.get("salary"));
		}
	}
	
	
	public static void main(String[] args) {

		//	一个map的一项对应一个记录，没有写一个表结构，这种结构也很好
		//以人为单位，这个人的id 是多少，name是多少，salary是多少，department是多少，hireDate是多少，等等
		//然后是下个人的，这种思路也是很正常的，符合一般的思维习惯
		Map map = new HashMap();
		map.put("id", 0301);
		map.put("name", "高企");
		map.put("salary", 3000);
		map.put("department", "项目部");
		map.put("hireDate", "2007-10");
		
		Map map2 = new HashMap();
		map2.put("id", 0302);
		map2.put("name", "马士兵");
		map2.put("salary", 3000);
		map2.put("department", "项目部");
		map2.put("hireDate", "2007-10");
		
		Map map3 = new HashMap();
		map3.put("id", 0301);
		map3.put("name", "裴新");
		map3.put("salary", 3000);
		map3.put("department", "项目部");
		map3.put("hireDate", "2007-10");

		List<Map> list = new ArrayList<Map>();	//加入泛型之后容器里面就只能放Employee了,就更规范了，以前里面什么都能放
		list.add(map);
		list.add(map2);
		list.add(map3);
		printEmployee(list);
	}
}
