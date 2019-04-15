package Offer3;

import java.util.Arrays;

/**
 * Title : ��ά�����еĲ��� 
 * Description : �����޳��޹����У���С���ҷ�Χ
 * ʱ�临�Ӷȣ�O(n)
 * �ռ临�Ӷȣ�O(1)
 * 
 * @author rico
 */    
public class Solution2 {

	public static boolean contain(int[][] array, int target) {
		
		// Ŀ�����鲻Ϊnull�Һ���Ԫ��
		if(array != null && array.length > 0){
			int row = 0;
			int col = array[row].length - 1;
			if(col >= 0){
				// ��������Ŀ��ֵ��ֱ��������������߽���Χ���ɿ�
				while(row <= array.length-1 && col >= 0){
					//�Ӷ�ά��������Ͻ����������Ͻ�ֵС��Ŀ��ֵ�������������
					if(array[row][col] == target){
						return true;
					} else if(array[row][col] > target){ // ���Ͻ�ֵ����Ŀ��ֵ����ɾ����
						col--;
					} else{
						row++;  // ���Ͻ�ֵС��Ŀ��ֵ����ɾ����
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[][] = {new int[]{1,2,8,9},new int[]{2,4,9,12},new int[]{4,7,10,13},new int[]{6,8,11,15}};
		System.out.println(contain(arr, 5));
		System.out.println(Arrays.toString(arr));
	}
}
