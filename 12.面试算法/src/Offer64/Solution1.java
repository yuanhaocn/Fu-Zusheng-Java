package Offer64;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Title:�������е���λ��
 * Description:��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ
 * ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * 
 * @author rico
 * @created 2017��7��9�� ����9:46:05
 */
public class Solution1 {

	List<Integer> list = new ArrayList<Integer>();

	public void Insert(Integer num) {
		list.add(num);
	}

	public Double GetMedian() {
		Collections.sort(list);
		int size = list.size();
		if (size != 0) {
			if ((size & 1) == 1) {
				return Double.valueOf(String.valueOf(list.get(size / 2)));
			} else {
				double result = list.get(size/2) + list.get((size / 2)-1);
				result /= 2;
				return result;
			}
		}
		return null;
	}
}