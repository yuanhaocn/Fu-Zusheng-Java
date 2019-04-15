package 哈希Map$手写;

import 哈希Map$手写.MyEntry;

/**
 * 自定义实现类似Map功能
 * Map存放键值对，根据对象找对象的值对象
 * 键不能重复
 * @author FZS
 *
 */
public class MyMap {
	MyEntry[] arr = new MyEntry[990];
	int size;
	
	
	public void put(Object key,Object value) {
		MyEntry e = new MyEntry(key,value);
		
		
//*********************键不可重复**********************************************************//
		for(int i = 0;i<size;i++) {			//防止key值出现重复 覆盖老key
			if(arr[i].key.equals(key)) {		 
				arr[i].value = value;
				return ;
			}
		}
//****************************************************************************************//
		
		
			
		arr[size++]=e;
	}
	
	
	public Object get(Object key) {
		for(int i = 0;i<size;i++) {
			if(arr[i].key.equals(key)) {		//比较的是内容不是对象
				return arr[i].value;
			}
		}
		return null;
	}
	
	
	public boolean containsKey(Object key) {
		for(int i = 0;i<size;i++) {
			if(arr[i].key.equals(key)) {		//比较的是内容不是对象
				return true;
			}
		}
		return false;
	}
	
	
	public boolean containsValue(Object value) {
		for(int i = 0;i<size;i++) {
			if(arr[i].value.equals(value)) {		//比较的是内容不是对象
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		MyMap m = new MyMap();
		m.put("fzs", new Wife("骆之玉"));
		m.put("张三", new Wife("杨幂"));
		Wife w = (Wife)m.get("fzs");
		System.out.println(w.name);
	}
	
}

 
 
