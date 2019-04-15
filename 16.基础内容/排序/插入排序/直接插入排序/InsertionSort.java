package 直接插入排序;

public class InsertionSort {

    public int[] insertionSort(int[] A, int n) {
      //用模拟插入扑克牌的思想
        //插入的扑克牌
        int i,j,temp;
        //已经插入一张，继续插入
        for(i=1;i<n;i++){
            temp = A[i];
            //把i前面所有大于要插入的牌的牌往后移一位，空出一位给新的牌
            for(j=i;j>0&&A[j-1]>temp;j--){
                A[j] = A[j-1];
            }
            //把空出来的一位填满插入的牌
            A[j] = temp;

        }
        return A;


    }
}