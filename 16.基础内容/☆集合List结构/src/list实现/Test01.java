package listʵ��;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
/**������ΪSet����List�б�Mapӳ�� 
 *Set���ϣ������ڲ��洢�ṹ���ص㣬Set�����в�����Ԫ�ص�˳�򣬲���������ظ���Ԫ�أ�TreeSet�������⣬Ԫ�طŽ�ȥ��ʱ����Ȼ
 *��Ȼ����˳���ˣ�Set������������ѧ�еļ������Ӧ����ͬ��Ԫ�ز��ᱻ���� List�б������ڲ��洢�ṹ���ص㣬List����������Ԫ
 *�ص�˳������������ظ���Ԫ�ء�List�����е�Ԫ�ض���Ӧһ�������͵���ż������������е�λ�ã����Ը�����Ŵ�ȡ�����е�Ԫ�ء�����
 *�����ظ� Mapӳ�䣺�����ڲ��洢�ṹ���ص㣬ӳ���в��ܰ����ظ��ļ�ֵ��ÿ�������ֻ��ӳ��һ��ֵ���������ָ��ǵ����(����
 *��valueֵ�Ὣǰ���valueֵ���ǵ�)��Map��һ�ְѼ������ֵ�������ӳ��ļ��ϣ���Map�����м�Ҫ������ݱ���ҲҪ��Źؼ���:
 *��ͬ��Ԫ�ػᱻ���� 
 *ע�⣺����Set��Map��˵,Ԫ�طŽ�ȥ֮����û��˳��ģ����ϣ��Ԫ�طŽ�ȥ֮������˳��ģ�������treeSet��treeMap�洢���ݡ� 
 * ����List�еĻ�������
 * @author FZS
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
	//	ArrayList�ײ�ʵ�������飬���Բ�ѯ�� �޸Ĳ���ɾ�������̲߳���ȫ��Ч�ʸ�
	//LinkedList �ײ�ʵ�����������Բ�ѯ�����޸�ɾ������죬�̲߳���ȫ��Ч�ʸ�
	//Vector���̰߳�ȫ��Ч�ʵ�
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);	//��װ����Զ�װ��
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	//	list.remove("aaa");
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		System.out.println(list.size());
		String ste=(String) list.get(0);
		list.add(1, "ababab");
		list.remove(1);
	}
	
}

class Dog{}