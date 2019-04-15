package ��ϣMap$��д;

import java.util.LinkedList;
import java.util.List;

/**
 * �Զ���Map��������
 * 1.��߲�ѯ��Ч��
 * @author FZS
 */
public class MyMap2 {
	LinkedList[] arr = new LinkedList[999];		//����һ������ ��������������� //Map�ĵײ�ṹ��������+����
	int size;
	
	
	public void put(Object key,Object value) {
		MyEntry e = new MyEntry(key,value);
		int a = key.hashCode()%arr.length;		//�����㷨
		if(arr[a]==null) {
			LinkedList list = new LinkedList();		//����һ���������� ��������ż�ֵ�ԣ���������ʹ�õ�ʱ�����ʵ����
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
