package A$�޷��ʹ����������;
/**
 * ��ȡֵ��ʱ����Ҫǿ������ת��
 * �ֶ����ͼ�飬����ת������
 * @author FZS
 *
 */
public class App {
	public static void main(String[] args) {
		Object obj = 80;
		//int score =(int)obj; //jdk1.7�Ժ� Object -->integer -->�Զ�����
		int score=(Integer)obj;
		System.out.println(score);
		 
		//�������� int -->Integer -->Object
		Student stu = new Student(80,90);

		//()stu.getJavase();
		int javaseScore =(Integer)stu.getJavase();	
		String oracleScore =null ;
		if(stu.getOracle() instanceof String){
			oracleScore =(String)stu.getOracle();
		}
		System.out.println("����Ϊ��"+javaseScore+","+oracleScore);
	}
}
