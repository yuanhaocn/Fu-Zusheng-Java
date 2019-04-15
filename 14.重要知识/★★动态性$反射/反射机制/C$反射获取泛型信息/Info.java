package C$�����ȡ������Ϣ;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import A$�������.User;

/**
 *���������������
 *setAccessible 
 * ���úͽ��÷��ʰ�ȫ���Ŀ��أ�ֵΪtrue��ָʾ����Ķ�����ʹ��ʱӦ��ȡ��java���Է��ʼ�飬
 * 						  ֵΪfalse��ָʾ�������Ӧ��ʵʩjava���Է��ʼ�飬
 * ������Ϊtrue���ܷ���Ϊfalse�Ͳ��ܷ���
 * ���ð�ȫ��飬������߷���������ٶ�(���4��)��������ͨ����������3��
 * 
 * �����������
 * 	java���÷��Ͳ�����ֵ�����뷺�ͣ�Java�еķ��ͽ����Ǹ�������javacʹ�õģ�ȷ�����ݵİ�ȫ�Ժ���ȥǿ������ת�����鷳������һ���������
 * �����еĺͷ����йص�����ȫ������
 * 
 * Ϊ��ͨ�����������Щ���ͣ���ӭ��ʵ�ʿ�������Ҫ��javac��������ParameterizedType,GenericArrayType,TypeVariable��
 * WildcardType���������������ܱ���һ��Class���е����͵����ֺ�ԭʼ��������������
 * 
 * ParameterizedType����ʾһ�ֲ����������ͣ�����Collection<String>
 * GenericArrayType:��ʾһ��Ԫ�������ǲ��������ͻ������ͱ�������������
 * TypeVariable���Ǹ������ͱ����Ĺ������ӿ�
 * WildcardType������һ��ͨ������ͱ��ʽ������?,? extends Number,? super Integer(Wildcard����ͨ�������˼)
 */
public class Info {

	public void test01(Map<String,User>map,List<User> list) {
		System.out.println("Info.test01");
	}
	public Map<Integer,User> test02(){
		System.out.println("Info.test02");
		return null;
	}
	
	
	public static void main(String[] args) {
		try {
			Method m = Info.class.getMethod("test01", Map.class,List.class);
			Type[] t = m.getGenericParameterTypes();//��ô����Ͳ�������
			
			for (Type paramtype : t) {
				System.out.println("#"+paramtype);
				if(paramtype instanceof ParameterizedType) {
					Type[] genericTypes= ((ParameterizedType)paramtype).getActualTypeArguments();
					for (Type genericType : genericTypes) {
						System.out.println("�������ͣ�"+genericType);
					} 
				}
			}
			
			
		//���ָ����������ֵ������Ϣ
			Method m2 = Info.class.getMethod("test02", null);
			Type returnType = m2.getGenericReturnType();//��ô����͵ķ�������
			if(returnType instanceof ParameterizedType) {
				Type[] genericTypes= ((ParameterizedType)returnType).getActualTypeArguments();
				
				for (Type genericType : genericTypes) {
					System.out.println("����ֵ���������ͣ�"+genericType);
				} 
			}
} catch (Exception e) {e.printStackTrace();}}}
