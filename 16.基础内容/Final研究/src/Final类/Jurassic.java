package Final��;
/**
 * ���˵�����඼��final�������Ķ���ǰ����final �ؼ��֣����ͱ����Լ���ϣ���������̳У����߲����������κ��˲�ȡ���ֲ�����
 * ����֮������������������ԭ�����ǵ���϶�����Ҫ�����κθı䣻���߳��ڰ�ȫ��������ɣ����ǲ�ϣ���������໯�����ദ����
�������⣬���ǻ������ǵ�ִ��Ч�ʵ����⣬����ȷ���漰����������������ж���Ҫ�����ܵ���Ч��
������ʾ��������������������
 *ע�����ݳ�Ա�ȿ�����final��Ҳ���Բ��ǣ�ȡ�������Ǿ���ѡ��Ӧ����final �Ĺ���ͬ�����������ݳ�Ա���������Ƿ񱻶����final��
 *���ඨ���final �󣬽��ֻ�ǽ�ֹ���м̳С���û�и�������ơ�
 *Ȼ������������ֹ�˼̳У�����һ��final ���е����з�����Ĭ��Ϊfinal����Ϊ��ʱ��Ҳ�޷��������ǡ�
 *���������ǽ�һ��������ȷ����Ϊfinal һ������������ʱ����ͬ��Ч��ѡ�񡣿�Ϊfinal ���ڵ�һ���������final ָʾ������������û���κ����塣
 *
 */
final class Dinosaur {
	int i = 7;
	int j = 1;
	SmallBrain x = new SmallBrain();
	void f() {}
	}
	//! class Further extends Dinosaur {}
	// error: Cannot extend final class 'Dinosaur'
	public class Jurassic {
		public static void main(String[] args) {
			Dinosaur n = new Dinosaur();
			n.f();
			n.i = 40;
			n.j++;
		}
	}
class SmallBrain {}