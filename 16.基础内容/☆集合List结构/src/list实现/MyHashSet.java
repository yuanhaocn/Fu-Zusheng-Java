package listʵ��;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ������������Ͷ���ķ�װ ŷ��
 * �Զ����Լ���HashSet
 * @author FZS
 *
 */
public class MyHashSet {
	HashMap map;
	private static final Object PRESENT = new Object();
	int size;
	public MyHashSet() {
		map = new HashMap();
	}
	public void add(Object o) {
		map.put(o, PRESENT);	//set�Ĳ����ظ�����������map����ļ�����Ĳ����ظ�
	}
	public void remove(Object o) {
		
	}
	public static void main(String[] args) {
		MyHashSet s = new MyHashSet();
	}
}
