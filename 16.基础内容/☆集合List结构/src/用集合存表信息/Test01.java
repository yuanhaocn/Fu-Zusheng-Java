package �ü��ϴ����Ϣ;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args){
		
/*һ��һ�����ã�̫������,�ù�����һ�γ�ʼ�����
		e.setId(0301);
			e.setName("����");
			e.setDepartment("��Ŀ��");
			e.setSalary(3000);
			String strDate = "2007-10";
			DateFormat format = new SimpleDateFormat("yyyy-NN");
			e.setHireDate(format.parse(strDate));
*/		
		//һ�������Ӧһ�м�¼
		Employee e  = new Employee(0301,"����",3000,"��Ŀ��","2007-10");
		Employee e2 = new Employee(0302,"��ʿ��",3000,"��Ŀ��","2007-10");
		Employee e3 = new Employee(0303,"����",3000,"��Ŀ��","2007-10");
		//����������¼��������������
		List<Employee> list = new ArrayList<Employee>();	//���뷺��֮�����������ֻ�ܷ�Employee��,�͸��淶�ˣ���ǰ����ʲô���ܷ�
		list.add(e);
		list.add(e2);
		list.add(e3);
		printEmployee(list);
	}
	public static void printEmployee(List<Employee> list) {		//��˼�Ǵ�������listֻ����Employee�����Ǳ��
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).getName());
		}
	}
	
}
