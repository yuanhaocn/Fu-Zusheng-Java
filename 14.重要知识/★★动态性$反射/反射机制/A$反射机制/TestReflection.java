package A$�������;
/**
 *�������(reflection)
 *	ָ���ǿ���������ʱ���أ�֪̽��ʹ�ñ����ڼ���ȫδ֪����
 *	����������״̬�У����Զ�̬�ļ���һ��ֻ�����ֵ��࣬��������һ���Ѽ��ص��࣬���ܹ�֪���������������Ժͷ����������κ�һ�����󣬶��ܹ�����
 *��������һ������������
 *	Class cls=Class.forName("ȫ����"); //��������ĺ��Ĵ���
 *��������֮���ڶ��ڴ��У��Ͳ�����һ��Class���͵Ķ���(һ����ֻ��һ��Class����)���������Ͱ�������������Ľṹ��Ϣ��
 *���ǿ���ͨ��������󿴵���Ľṹ������������һ�澵�ӣ�͸��������ӿ�����Ľṹ��������������ĳ�֮Ϊ������
 *
 *
 *������Ƶĳ������ã�
 *	��̬�����࣬��̬��ȡ�����Ϣ(���ԣ�������������)
 *	��̬�������
 *	��̬������Ͷ�������ⷽ����������
 *	��̬���úʹ�������
 *	��ȡ������Ϣ
 *	����ע��
 * ����java.lang.Class����Ļ�ȡ��ʽ
 * 
 * 
 *Instances of the class Class represent classes and interfaces in a running Java application. 
 *An enum is a kind of class and an annotation is a kind of interface. Every array also belongs 
 *to a class that is reflected as a Class object that is shared by all arrays with the same element 
 *type and number of dimensions. The primitive Java types (boolean, byte, char, short, int, long, 
 *float, and double), and the keyword void are also represented as Class objects. 
 */
public class TestReflection {
	public static void main(String[] args) {
		String path="A$�������.User";
		try {
/*
 * ��������ʾ���߷�װһЩ���ݣ�һ���౻���غ�JVM�ᴴ��һ����Ӧ�����Class������������ṹ��Ϣ�ᱻ�ŵ���Ӧ��Class������
 * ���Class�������һ�澵��һ����͸�����澵�����ǿ��Կ�����Ӧ���ȫ����Ϣ��Ҳ����˵cls������󱣴���User������ȫ����Ϣ ��
  --��ȡClass�����һ�ַ���
  ----Class<?> cls = Class.forName("ȫ����");
 */
			Class<?> cls = Class.forName(path);
			System.out.println(cls);
			System.out.println(cls.hashCode());
			//ͬ����һ����ֻ�ᱻ����һ�Σ�һ����ֻ��һ���������cls�����ظ����صĹ�ϣֵ������ͬ��Ҳ�ʹ���ֻ��һ������
			Class<?> cls2 = Class.forName(path);
			System.out.println(cls2.hashCode());
			
		/*
		 * ��ȡClass����ڶ��ַ���
		 * 	����.class
		 */
			Class cls3=String.class;
		 /*
		  * ��ȡClass��������ַ���
		  * 	����.class
		  */	
			Class cls4=path.getClass();
			System.out.println(cls3==cls4);//�����ַ�����������ͬһ������
			
			
/*
 * Jump above calculations, group the operations, classify them according to their complexities rather than their appearance;
 * this, I believe,is the mission of future mathematicians; this is the road I'm embarking in thiswork.��
 * ���������㣬Ⱥ�����㣬�������ǵĸ��Ӷȶ����Ǳ��������ࣻ�����ţ�����δ����ѧ��������Ҳ�����ҵĹ�������ʾ�����ĵ�·����
 */
			int[] arr01=new int[10];
			int[] arr02=new int[30];
			//ͬ�����������ͷ������õķ��������ͬһ�����󣬸о��ͳ������һ���������һ��ģ�ͣ���������
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
		} catch (Exception e) {e.printStackTrace();}
	}
}

