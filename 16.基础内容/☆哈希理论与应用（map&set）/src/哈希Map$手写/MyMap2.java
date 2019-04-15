package 哈希Map$手写;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义Map的升级版
 * 1.提高查询到效率
 * @author FZS
 */
public class MyMap2 {
	LinkedList[] arr = new LinkedList[999];		//这是一个数组 ，数组里面放容器 //Map的底层结构就是数组+链表
	int size;
	
	
	public void put(Object key,Object value) {
		MyEntry e = new MyEntry(key,value);
		int a = key.hashCode()%arr.length;		//核心算法
		if(arr[a]==null) {
			LinkedList list = new LinkedList();		//这是一个链表容器 链表里面放键值对，对象数组使用的时候必须实例化
			arr[a]=list;
			list.add(e);
		}else {
			arr[a].add(e);
		}
	}
	
	
	public Object get(Object key) {
		int a = key.hashCode()%arr.length;		
		if(arr[a]!=null) {
			LinkedList list = arr[a];
		for(int i =0;i<list.size();i++) {
			MyEntry e = (MyEntry)list.get(i);
			if(e.key.equals(key)) {
				return e.value;
			}
			}
		} 
		return null;
	}
}
