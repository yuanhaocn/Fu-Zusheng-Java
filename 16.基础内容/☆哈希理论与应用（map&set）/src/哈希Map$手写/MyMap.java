package ��ϣMap$��д;

import ��ϣMap$��д.MyEntry;

/**
 * �Զ���ʵ������Map����
 * Map��ż�ֵ�ԣ����ݶ����Ҷ����ֵ����
 * �������ظ�
 * @author FZS
 *
 */
public class MyMap {
	MyEntry[] arr = new MyEntry[990];
	int size;
	
	
	public void put(Object key,Object value) {
		MyEntry e = new MyEntry(key,value);
		
		
//*********************�������ظ�**********************************************************//
		for(int i = 0;i<size;i++) {			//��ֹkeyֵ�����ظ� ������key
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
			if(arr[i].key.equals(key)) {		//�Ƚϵ������ݲ��Ƕ���
				return arr[i].value;
			}
		}
		return null;
	}
	
	
	public boolean containsKey(Object key) {
		for(int i = 0;i<size;i++) {
			if(arr[i].key.equals(key)) {		//�Ƚϵ������ݲ��Ƕ���
				return true;
			}
		}
		return false;
	}
	
	
	public boolean containsValue(Object value) {
		for(int i = 0;i<size;i++) {
			if(arr[i].value.equals(value)) {		//�Ƚϵ������ݲ��Ƕ���
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		MyMap m = new MyMap();
		m.put("fzs", new Wife("��֮��"));
		m.put("����", new Wife("����"));
		Wife w = (Wife)m.get("fzs");
		System.out.println(w.name);
	}
	
}

 
 
