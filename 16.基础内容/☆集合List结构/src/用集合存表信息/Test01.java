package 用集合存表信息;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args){
		
/*一个一个设置，太复杂了,用构造器一次初始化完成
		e.setId(0301);
			e.setName("高企");
			e.setDepartment("项目部");
			e.setSalary(3000);
			String strDate = "2007-10";
			DateFormat format = new SimpleDateFormat("yyyy-NN");
			e.setHireDate(format.parse(strDate));
*/		
		//一个对象对应一行记录
		Employee e  = new Employee(0301,"高企",3000,"项目部","2007-10");
		Employee e2 = new Employee(0302,"高士兵",3000,"项目部","2007-10");
		Employee e3 = new Employee(0303,"裴新",3000,"项目部","2007-10");
		//整合三条记录，丢经容器里面
		List<Employee> list = new ArrayList<Employee>();	//加入泛型之后容器里面就只能放Employee了,就更规范了，以前里面什么都能放
		list.add(e);
		list.add(e2);
		list.add(e3);
		printEmployee(list);
	}
	public static void printEmployee(List<Employee> list) {		//意思是传进来的list只能是Employee不能是别的
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).getName());
		}
	}
	
}
