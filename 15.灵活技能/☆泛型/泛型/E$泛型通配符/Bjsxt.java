package E$����ͨ���;

/**
 * ���͵�Ƕ��
 * ������Ƕ��ʹ�÷���
 * A<B<C>> a = new A<B<C>>
 * ʹ�ã����⵽�һ��һ���֣���΢����һЩ�������û���κι�ϵ��ֻ��ȷ�������Ͷ���
 */
public class Bjsxt<T>{
	T stu;
	public static void main(String[] args) {
		//���͵�Ƕ�ף����ҶԳ�	
		 Bjsxt<Student<String>> room = new  Bjsxt<Student<String>>();			//�����ʱ Bjsxt<Student<String>>
		//ʹ�õ�ʱ��ʱ���⵽������һ��һ���֣���hashMap()�о���ʹ��			
		 room.stu = new Student<String>();			//��ֵ����ñ���	
		 Student<String> stu = room.stu;										//�ڶ���Student<String>
		 String score = stu.score;												//�����String	
		 System.out.println(score);
		 
//****************************���Լ������******************************************************//	 
		 Bjsxt<Student<String>> floor = new  Bjsxt<Student<String>>();
		floor.stu = new Student<String>();//�������и�ֵ����ÿ�ָ���쳣�� ��һ���൱�ڸ�floor.stu������һ�£���δ��ֵ
		//��һ���ͱ�17��18�к����һ��ֱ�Ӱѷ��͵Ĳ��ֶ������͸�ֵ�ã�Ȼ��Ϳ���ֱ�ӵ���
		 System.out.println(floor.stu.score);
	}
}
