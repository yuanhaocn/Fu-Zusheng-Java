package A$�����ԭ��;

public class Demo {
	static {
		System.out.println("��̬��ʼ��Demo");
	}

	public static void main(String[] args) throws Exception {
		/*System.out.println("Demo��main����");
		A a = new A();
		System.out.println(a.width);
		A a2=new A();//����غͳ�ʼ��ֻ��һ��
		System.out.println(A.width);//�������ã��ᵼ��A��ʼ��
		System.out.println(A.MAX);//�������ã����ᵼ��A��ʼ��
		Class<?> cls = Class.forName("JVMԭ��.A");//���������ʱ��Ҳ�ᵼ�³�ʼ��A
		A[] as = new A[10];//����A���鲻���ʼ��A
*/		System.out.println(B.width);//������һ��java��ľ�̬��ʱ��ֻ������������������Żᱻ��ʼ���� ����˵B�����ʼ����A�����������̬������A����ʼ����
		
	}

}

class B extends A{
	static {
		System.out.println("��̬��ʼ��B");
	}
}

class A extends A_Farther{
	public static int width=100;
	public static final int MAX=100;
	static {
		System.out.println("��̬��ʼ����A");
		width=300;//HOHOHO 
	}
	public A() {
		System.out.println("����A����");
	}
}

class A_Farther{
	static {
		System.out.println("��̬��ʼ��A_Father");
	}
	
}



