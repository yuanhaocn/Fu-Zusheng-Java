package Offer45;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:�����ǵ���Ϸ(ԲȦ�����ʣ�µ���) Description:
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��
 * ,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:����,��С������Χ��һ����Ȧ
 * ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�
 * ,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ
 * ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���
 * ,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 * 
 * @author rico
 * @created 2017��7��2�� ����9:39:03
 */
public class Solution {

	/**
	 * @description ģ��ѭ������ģ����Ϸ����
	 * @author rico
	 * @created 2017��7��2�� ����2:00:04
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {
		if (n >= 1 && m >= 1) {
			List<Integer> list = new ArrayList<Integer>(n);
			for (int i = 0; i < n; i++) {
				list.add(i);
			}

			int count = 0; // ���ڱ��ĸ���
			int index = 0; // ��λͬѧ���ڱ���
			while (list.size() != 1) { // ֻʣһ��С����ʱ��ѭ����ֹ
				if (index == list.size()) { // ѭ������
					index = 0;
				}
				if (count == m - 1) { // ��m-1��С���ѳ���
					list.remove(index);
					count = 0;
					continue;
				}
				index++;
				count++;
			}
			return list.get(0);
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.LastRemaining_Solution(5, 3));
	}
}
