package �ű�����;

import javax.script.*;

/**
 * java�ű�����ִ��JavaScript����
 * �ű�������ܣ�
 * 	ʹ��JavaӦ�ó������ͨ��һ�׹̶��Ľӿ�����ֽű����潻�����Ӷ��ﵽ��Javaƽ̨�ϵ��ø��ֽű����Ե�Ŀ��
 * 	Java�ű�API����ͨJavaƽ̨�ͽű����Ե�����
 * 	���԰�һЩ��������ҵ���߼������ű����Դ������ִ������˿���Ч��
 * 
 * �ű������ǽ���Javaƽ̨�ͽű�����֮���ƽ̨
 * Java�ű�APIΪ�������ṩ�����¹���
 * 	��ȡ�ű��������룬ͨ���ű��������нű����������н������������ĵĽӿ�
 * 		ע���ǣ��ӿڡ�Java����ʹ�ø��ֲ�ͬ��ʵ�֣��Ӷ�ͨ�õĵ���js��groovy��python�Ƚű�
 * 			jsʹ����Rhino
 * 					Rhino��һ��ʹ��Java���Ա�д��JavaScript�Ŀ�Դʵ�֣�ԭ����Mozilla���������ڱ����ɽ���JDK6.0
 * 		ͨ���ű�����������������ڽű���Javaƽ̨�佻������
 * 		ͨ��JavaӦ�ó�����ýű�����			
 */
public class Info {
	public static void main(String[] args) throws Exception {
		//��ýű�����
		ScriptEngineManager sem = new ScriptEngineManager();//�ű����������
		ScriptEngine engine = sem.getEngineByName("javascript");//�ű����������
		/*
		 * js�ű�����
		 */
		//����һ�����֣�����һ����ֵ��,������������������
		engine.put("msg", "fzs is good man!");
		String str = "var user = {name:'fzs',age:18,schools:['���չ��̴�ѧ','programmer']};";
		str +="println(user.name);";
		/*
		 * ִ�нű�
		 */
		engine.eval(str);
		engine.eval("msg='lzy is a good girl';");
		System.out.println(engine.get("msg"));
	}
}
