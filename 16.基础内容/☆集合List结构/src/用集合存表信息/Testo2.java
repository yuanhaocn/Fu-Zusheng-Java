package �ü��ϴ����Ϣ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testo2 {

	public static void printEmployee(List<Map> list) {		//��˼�Ǵ�������listֻ����Employee�����Ǳ��
		for(int i=0; i<list.size();i++) {
			Map tempMap = list.get(i);
			System.out.println(tempMap.get("name")+"--"+tempMap.get("salary"));
		}
	}
	
	
	public static void main(String[] args) {

		//	һ��map��һ���Ӧһ����¼��û��дһ����ṹ�����ֽṹҲ�ܺ�
		//����Ϊ��λ������˵�id �Ƕ��٣�name�Ƕ��٣�salary�Ƕ��٣�department�Ƕ��٣�hireDate�Ƕ��٣��ȵ�
		//Ȼ�����¸��˵ģ�����˼·Ҳ�Ǻ������ģ�����һ���˼άϰ��
		Map map = new HashMap();
		map.put("id", 0301);
		map.put("name", "����");
		map.put("salary", 3000);
		map.put("department", "��Ŀ��");
		map.put("hireDate", "2007-10");
		
		Map map2 = new HashMap();
		map2.put("id", 0302);
		map2.put("name", "��ʿ��");
		map2.put("salary", 3000);
		map2.put("department", "��Ŀ��");
		map2.put("hireDate", "2007-10");
		
		Map map3 = new HashMap();
		map3.put("id", 0301);
		map3.put("name", "����");
		map3.put("salary", 3000);
		map3.put("department", "��Ŀ��");
		map3.put("hireDate", "2007-10");

		List<Map> list = new ArrayList<Map>();	//���뷺��֮�����������ֻ�ܷ�Employee��,�͸��淶�ˣ���ǰ����ʲô���ܷ�
		list.add(map);
		list.add(map2);
		list.add(map3);
		printEmployee(list);
	}
}
