package ð������;

import java.util.*;

public class BubbleSort3 {
    public int[] bubbleSort3(int[] A, int n) {
        //ð�����򣺴Ӻ���ǰ���������ϣ�����ð��һ��
        //��flag��Ϊ��ǣ���������Ƿ��Ѿ��������
        boolean flag = true;
        //�̶���ߵ�����
        for(int i=0; i<n-1&flag; i++){
            flag = false;
            //�Ӻ��棨���棩��ǰ���ϣ�����
            for(int j=n-2;j>=i;j--){

                if(A[j]>A[j+1]){
                    swap(A,j,j+1);
                    flag = true;
                }
            }
        }

        return A;

    }
    //�����ǰ����ô��ݣ��ں����иı�����������
    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}