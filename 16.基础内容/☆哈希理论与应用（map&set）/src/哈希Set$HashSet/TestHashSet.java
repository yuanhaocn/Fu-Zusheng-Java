package ��ϣSet$HashSet;
/**
 * hashSet����ȥ�غ�������
 * �Լ��Ի������������Լ�String���͵�Ĭ������
 */
import java.util.HashSet;

public class TestHashSet {

	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(4);
		hashSet.add(2);
		hashSet.add(1);
		hashSet.add(0);
		System.out.println(hashSet);
		
	}

}
