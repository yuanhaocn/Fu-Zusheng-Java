package ֱ�Ӳ�������;

public class Snippet {
	public static void insertSort(int a[]){
		int j; //��ǰҪ����ֵ��λ��
		int preJ; //����ָ��jǰ��λ��
		int key; //����ʱ���ݴ�Ҫ�����ֵ
		//������ĵڶ���λ�ÿ�ʼ����ֵ
		for(j=1;j<a.length;j++){
			key=a[j];
			preJ=j-1;
			//a[preJ]�ȵ�ǰֵ��ʱ��a[preJ]����һλ
			while(preJ>=0 && a[preJ]>key){
				a[preJ+1]=a[preJ]; //��a[preJ]ֵ����
				//����ע��: a[preJ+1]=a[j]=key,�Ѳ���ֵ�Ѿ������� key��
				//����˵, ������һ���հ�λ����ʵ�����κ��ƣ�����������ݶ�ʧ���⣩
				preJ--; //preJǰ��
			}
				//�ҵ�Ҫ�����λ�û��ѱ�����ɣ�(preJ=0��
			a[preJ+1]=key; //����ǰֵ���� �հ�λ��
		}
	}
}

