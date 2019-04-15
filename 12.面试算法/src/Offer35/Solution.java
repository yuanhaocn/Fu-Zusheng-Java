package Offer35;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Title:��һ��ֻ����һ�ε��ַ�(ʹ��LinkedHashMap���洢�ṹ)
 * Description: ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 * 
 * ʱ�临�Ӷȣ�O(n)
 * �ռ临�Ӷȣ�O(1)
 * @author rico
 * @created 2017��6��24�� ����8:51:27
 */

public class Solution {
	public int FirstNotRepeatingChar(String str) {
		if (str != null && str.length() != 0) {
			// �洢�ַ������ַ�����λ�ã����ַ��ظ�������λ����Ϊ-1
			LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();  // ά�ֲ���˳��
			for (int i = 0; i < str.length(); i++) {
				Character key = str.charAt(i);
				if (!map.containsKey(key)) {
					map.put(key, i);
				} else {
					map.put(key, -1);
				}
			}
			System.out.println(map);
			Set<Map.Entry<Character, Integer>> set = map.entrySet();
			for (Map.Entry<Character, Integer> entry : set) {  //LinkedHashMap����˳���ǲ���˳�� 
				if (entry.getValue() != -1) {
					return entry.getValue();
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "google";
		System.out.println(s.FirstNotRepeatingChar(str));
	}
}
