package list实现;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 容器就是数组和对象的封装 欧拉
 * 自定义自己的HashSet
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
		map.put(o, PRESENT);	//set的不可重复就是利用了map里面的键对象的不可重复
	}
	public void remove(Object o) {
		
	}
	public static void main(String[] args) {
		MyHashSet s = new MyHashSet();
	}
}
