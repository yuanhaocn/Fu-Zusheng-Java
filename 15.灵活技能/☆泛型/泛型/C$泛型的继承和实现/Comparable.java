package C$���͵ļ̳к�ʵ��;
/**
 * ���ͽӿڣ���̳�ʱͬ���
 * ��д�����游�����
 * @author FZS
 *
 * @param <T>
 */
public interface Comparable<T> {
 void compare(T t);		//����ÿ����д�ķ����游�����
}
//��������ָ����������
class Comp  implements Comparable<Integer>{

	@Override
	public void compare(Integer t) {
		// TODO Auto-generated method stub
		
	}}
//���Ͳ���
class Comp1 implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub
		
	}}
//������������෺��
class Comp2<T> implements Comparable{

	@Override
	public void compare(Object t) {
		// TODO Auto-generated method stub
		
	}}
//���෺��>=���෺��
class Comp3<T,T2> implements Comparable<T>{

	@Override
	public void compare(T t) {
		// TODO Auto-generated method stub
		
	}}
//���෺�ͣ������������