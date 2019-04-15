package listʵ��;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
	private Node first;		//��ʼ�����ɶ�
	private Node last;
	
	private int size;
	public void add(Object obj) {  		//�ص�
		 Node n = new Node();			//�൱��һ�����������ú�NȻ���ٸ�ֵ��last
		if(first==null) {
			 n.setPrevious(null);
			 
			 n.setObj(obj);
			 n.setNext(null);
			 first = n;
			 last = n;
		}else {
										//ֱ����last�ڵ�������µĽڵ�  ����������
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			 last = n;
		}
		size++;					//����Ҫ
	}
	public int size(){
		return size;
	}
	
		private void rangeCheck(int index) {
			if(index<0 || index>=size) {
				try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
		public Node node(int index) {			//
			Node temp = null;					//Ѱ�ҵ�ָ��λ�õķ���,��һ���ArrayList�ǳ���ͬ LinkedList��ͨ�������ҵ������ڵ��
			if(first!=null) {
				 temp = first;					//ָ·��
				for(int i =0;i<index;i++) {
					temp = temp.next;
				}
			}
			return temp;
		}
	public Object get(int index) {
		rangeCheck(index);
		Node temp = node(index);					//Ѱ�ҵ�ָ��λ�õķ���
		return temp.obj;
		
	}
	
	public void remove(int index) {
		Node temp = node(index);
		if(temp != null) {
		Node up = temp.previous;		//ÿ���ڵ��ͷ��β���ǽڵ�����
		Node down = temp.next;
		up.next = down;
		down.previous = up;
		size--;
		}	
	}
	public void add(int index,Object obj) {			//ָ��λ�ü�һ�������Ƕ��󣬵�����Ҫ����һ���ڵ�Ѷ���Ž�ȥ
		Node temp=node(index);
		Node newNode = new Node();
		newNode.obj=obj;
		if(temp != null) {
		Node up = temp.previous;		//ÿ���ڵ��ͷ��β���ǽڵ�����
		up.next= newNode;
		newNode.previous =up;
		newNode.next= temp;
		temp.previous=newNode;
		size++;		
		}

	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		List list2 = new LinkedList();
		list.add("3253");
		list.add("bb");
		System.out.println(list.get(1));
	}
}

