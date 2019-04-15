package 直接选择排序;
import java.util.*;
/**

**/
public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
       //简单选择排序算法,排序结果为递增数组
        //记录最小下标值
        int min=0;
        //固定左边的数字
        for(int i=0; i<A.length-1;i++){
            min = i;
            //找到下标i开始后面的最小值
            for(int j=i+1;j<A.length;j++){

                 if(A[min]>A[j]){
                     min = j;
                 }
            }
           //确保稳定排序,数值相等就不用交换
            if(i!=min){
                swap(A,i,min);
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