package Offer40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:������ֻ����һ�ε����� (ʹ�ù�ϣ�����)
 * Description: һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * ʱ�临�Ӷȣ�O(n)
 * �ռ临�Ӷȣ�O(n)
 * @author rico
 * @created 2017��6��28�� ����5:11:23
 */
public class Solution {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : array) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {  // �ڶ��γ��ֵ������ڹ�ϣ����ɾ������
				map.remove(i);
			}
		}

		List<Integer> list = new ArrayList<Integer>(map.keySet());
		num1[0] = list.get(0);
		num2[0] = list.get(1);
	}
}