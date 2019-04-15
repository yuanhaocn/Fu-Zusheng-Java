package Offer9_1;

/**
 * Title: ���󸲸�(��ѧ���ɷ�)---쳲��������е�Ӧ��
 * Description:���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * 
 * @author rico
 * @created 2017��6��4�� ����3:45:34
 */
public class Solution {
	
	public int RectCover(int target) {
		return RectCover(target, 1, 2);
	}

	public int RectCover(int target, int first, int second) {
		if (target > 0) {
			if (target == 1) {
				return 1;
			} else if (target == 2) {
				return 2;  
			} else if (target == 3) {
				return first + second;
			}
			return RectCover(--target, second, first + second);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().RectCover(4));
	}
}
