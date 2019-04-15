package list实现;

/**
 * 自己实现一个ArrayList帮住我们更好的理解底层结构
 * @author FZS
 *
 */
public class MyArrayList  {
	
	
//********************************************************************************************//
	private Object[] elementData;		//核心 关键 一个“对象数组”
	private int  size;
//*******************************************************************************************//

//******************************************************************************************//
//两个有关联的构造器。
	public MyArrayList() {
		this(10);
	}	
	public MyArrayList(int initialCapacity) {
		if(initialCapacity<0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		elementData = new Object[initialCapacity];		//一个最初的对象数组就形成了。
	}
//*******************************************************************************************//
	
	
//******************************************************************************************//
	 public void add(Object obj) {
		//数组扩容
		 if(size==elementData.length) {		//扩容，核心关键
			 Object[] newArray = new Object[size*2+1];
			 System.arraycopy(elementData, 0, newArray, 0, elementData.length);		//数组拷贝
			 elementData = newArray;

		 }
		 elementData[size++]=obj;	
	 }
//*******************************************************************************************//
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0; 
	}
	
	 public Object get(int index) {			//get方法
		 if(index<0 || index>=size) {
			 try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 return elementData[index];
	 }
	 
	 	public void remove(int index) {		//删除指定位置的对象
			 if(index<0 || index>=size) {
				 try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}
			 } 
	 		int numMoved = size - index -1;
	 		if(numMoved>0) {
	 			System.arraycopy(elementData, index+1, elementData, index, numMoved);
	 		
	 		}
	 		elementData[--size]=null;
	 	}
	 
	 	public void remove(Object obj) {
	 		for(int i = 0;i<size;i++) {
	 			if(get(i).equals(obj)) {
	 				remove(i);
	 			}
	 		}
	 	}
	 	
	 	public Object set(int index,Object obj) {
			 if(index<0 || index>=size) {
				 try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}
			 } 
			 Object oldValue = elementData[index];
			 elementData[index]=obj;
			 return oldValue;
	 	}
	 	
	 public static void main(String[] args) {
		 MyArrayList list = new MyArrayList(3);
		 list.add("w234");
		 list.add("w2344");
		 list.add("w23564");
		 list.add("w2304");
		 list.add("w23804");
		 list.add("w232204");
		 System.out.println(list.size());
		 System.out.println(list.get(3));
	 }
}
