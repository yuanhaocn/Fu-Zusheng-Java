package ֱ�Ӳ�������;

public class InsertionSort {

    public int[] insertionSort(int[] A, int n) {
      //��ģ������˿��Ƶ�˼��
        //������˿���
        int i,j,temp;
        //�Ѿ�����һ�ţ���������
        for(i=1;i<n;i++){
            temp = A[i];
            //��iǰ�����д���Ҫ������Ƶ���������һλ���ճ�һλ���µ���
            for(j=i;j>0&&A[j-1]>temp;j--){
                A[j] = A[j-1];
            }
            //�ѿճ�����һλ�����������
            A[j] = temp;

        }
        return A;


    }
}