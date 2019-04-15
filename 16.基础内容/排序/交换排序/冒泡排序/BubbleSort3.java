package 冒泡排序;

import java.util.*;

public class BubbleSort3 {
    public int[] bubbleSort3(int[] A, int n) {
        //冒泡排序：从后往前（从下往上）就像冒泡一样
        //用flag作为标记，标记数组是否已经排序完成
        boolean flag = true;
        //固定左边的数字
        for(int i=0; i<n-1&flag; i++){
            flag = false;
            //从后面（下面）往前（上）遍历
            for(int j=n-2;j>=i;j--){

                if(A[j]>A[j+1]){
                    swap(A,j,j+1);
                    flag = true;
                }
            }
        }

        return A;

    }
    //数组是按引用传递，在函数中改变数组起作用
    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}