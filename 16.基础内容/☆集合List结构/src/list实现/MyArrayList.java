package listʵ��;

/**
 * �Լ�ʵ��һ��ArrayList��ס���Ǹ��õ����ײ�ṹ
 * @author FZS
 *
 */
public class MyArrayList  {
	
	
//********************************************************************************************//
	private Object[] elementData;		//���� �ؼ� һ�����������顱
	private int  size;
//*******************************************************************************************//

//******************************************************************************************//
//�����й����Ĺ�������
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
		elementData = new Object[initialCapacity];		//һ������Ķ���������γ��ˡ�
	}
//*******************************************************************************************//
	
	
//******************************************************************************************//
	 public void add(Object obj) {
		//��������
		 if(size==elementData.length) {		//���ݣ����Ĺؼ�
			 Object[] newArray = new Object[size*2+1];
			 System.arraycopy(elementData, 0, newArray, 0, elementData.length);		//���鿽��
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
	
	 public Object get(int index) {			//get����
		 if(index<0 || index>=size) {
			 try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 return elementData[index];
	 }
	 
	 	public void remove(int index) {		//ɾ��ָ��λ�õĶ���
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
