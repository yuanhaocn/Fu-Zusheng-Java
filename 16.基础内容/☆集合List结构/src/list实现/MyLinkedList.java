package list实现;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
	private Node first;		//伊始，不可动
	private Node last;
	
	private int size;
	public void add(Object obj) {  		//重点
		 Node n = new Node();			//相当与一个过度先设置好N然后再赋值给last
		if(first==null) {
			 n.setPrevious(null);
			 
			 n.setObj(obj);
			 n.setNext(null);
			 first = n;
			 last = n;
		}else {
										//直接往last节点后增加新的节点  不懂！！！
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			 last = n;
		}
		size++;					//很重要
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
			Node temp = null;					//寻找到指定位置的方法,这一点和ArrayList非常不同 LinkedList是通过遍历找到操作节点的
			if(first!=null) {
				 temp = first;					//指路人
				for(int i =0;i<index;i++) {
					temp = temp.next;
				}
			}
			return temp;
		}
	public Object get(int index) {
		rangeCheck(index);
		Node temp = node(index);					//寻找到指定位置的方法
		return temp.obj;
		
	}
	
	public void remove(int index) {
		Node temp = node(index);
		if(temp != null) {
		Node up = temp.previous;		//每个节点的头和尾都是节点类型
		Node down = temp.next;
		up.next = down;
		down.previous = up;
		size--;
		}	
	}
	public void add(int index,Object obj) {			//指定位置加一个对象，是对象，但是你要创造一个节点把对象放进去
		Node temp=node(index);
		Node newNode = new Node();
		newNode.obj=obj;
		if(temp != null) {
		Node up = temp.previous;		//每个节点的头和尾都是节点类型
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

