package C$���͵ļ̳к�ʵ��;
/**
 * ����Ϊ������
 * 1������
 * 2������
 * Ҫôͬʱ������Ҫô������ڵ��ڸ��������
 * ����������������෺��
 * 1���������� 
 * 	�����У��游�����
 * 	�����У����������
 * 2��������д
 * �游�����
 *  
 * @author FZS
 *
 */
public abstract class Father<T>{
	T name;
	public abstract void test(T t);
}
/*
 * 1������ʹ��ʱ������ʱ��ָ����������
 * ��������Ϊ��������
 * ����ͬ�� 
 */
class Child extends Father<String>{
	String t2;
	@Override
	public void test(String t) {
		// TODO Auto-generated method stub
		
	}
	
}
/*
 * 2������Ϊ�����࣬������ʹ�õ�ʱ��ȷ��
 * 
 */
class Child2<T2,T> extends Father<T>{ //child<T>�ķ��Ͳ��������ֺͷ���Ҫ�͸���һ�� ��˳����Ե���,����Child2�Ķ�һ��ʱû��ϵ��
	String t2;
	@Override
	public void test(T t) {
		
	}	
}

/*
 * 3,����Ϊ�����࣬���಻ָ�����ͣ��������͵Ĳ�����ͳһʹ��Object�滻
 */
class Child3<T> extends Father{

	@Override
	public void test(Object t) {		//11��ע�ͶԴ��н���
		// TODO Auto-generated method stub
		
	}
	
}
/*
 * 4,����͸���ͬʱ����
 */
class Child4 extends Father{
//����ʹ��T
	
	@Override
	public void test(Object t) {	//���Object����
		// TODO Auto-generated method stub
		
	}
	
}
/*
 * ����5,�������������ʹ�÷���
 */
/*
class Child5 extends Father<T>{
	String name;
	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
		
	}
	
}
*/