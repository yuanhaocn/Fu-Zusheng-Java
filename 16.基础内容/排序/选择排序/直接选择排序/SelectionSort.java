package ֱ��ѡ������;
import java.util.*;
/**

**/
public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
       //��ѡ�������㷨,������Ϊ��������
        //��¼��С�±�ֵ
        int min=0;
        //�̶���ߵ�����
        for(int i=0; i<A.length-1;i++){
            min = i;
            //�ҵ��±�i��ʼ�������Сֵ
            for(int j=i+1;j<A.length;j++){

                 if(A[min]>A[j]){
                     min = j;
                 }
            }
           //ȷ���ȶ�����,��ֵ��ȾͲ��ý���
            if(i!=min){
                swap(A,i,min);
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