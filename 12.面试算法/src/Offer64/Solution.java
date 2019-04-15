package Offer64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

  
/**
 * Title:�������е���λ��(��K����)
 * Description:��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ
 * ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * 
 * @author rico
 * @created 2017��7��9�� ����9:46:05
 */     
public class Solution {
	
	List<Integer> list = new ArrayList<Integer>();

	public void Insert(Integer num) {
		list.add(num);
	}

	public Double GetMedian() {
		double result = 0.0;
		int size =list.size();
		if (size != 0) {
			if (size%2 == 1) {
				System.out.println("size/2 : " + size/2);
				result = getKthNum(size/2 + 1);
				return result;
			}else{
				int a1 = getKthNum(size/2+1);
				int a2 = getKthNum(size/2);
				result = (double)(a1 + a2)/2;   // ʹ��Doubleǿת������С��
				return result;
			}
		}
		return null;
	}
	
	
	  
	/**     
	 * @description �õ���K����
	 * @author rico       
	 * @created 2017��7��9�� ����11:10:07     
	 * @param k
	 * @return     
	 */
	public int getKthNum(int k){
		Integer[] arr = new Integer[list.size()];
		arr = list.toArray(arr);
		int start = 0;
		int end = arr.length - 1;
		int index = partition(arr, start, end);
		System.out.println("index : " + index );
		while(index != k-1){
			if (index < k-1) {
				start = index + 1; 
				index = partition(arr, start, end);
			}else{
				end = index - 1;
				index = partition(arr, start, end);
			}
		}
		System.out.println(arr[index]);
		return arr[index];
	}
	
	  
	/**     
	 * @description ���ŵĻ����㷨
	 * @author rico       
	 * @created 2017��7��9�� ����11:09:39     
	 * @param arr
	 * @param from
	 * @param to
	 * @return     
	 */
	public int partition(Integer[] arr, int from, int to){
		int base = arr[from];
		int index = from;
		for (int i = from + 1; i <= to; i++) {
			if (arr[i] < base) {
				index ++;
				if (index != i) {
					int tmp = arr[index];
					arr[index] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		arr[from] = arr[index];
		arr[index] = base;
		return index;
	}
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Integer[] arr = {5};
		s.setList(Arrays.asList(arr));
//		System.out.println(s.getKthNum(4));
//		System.out.println(s.GetMedian());
		double d = (double)(2+3)/2;
		System.out.println(d);
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
}
