/**
 * �÷����л��ķ�ʽ�ƽⵥ��ģʽ
 */
package E�����л��ƽ�;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class  Demo{
	public static void main(String[] args) throws Exception {
		 MyJvm s1 = MyJvm.getInstance();
		 MyJvm s2 = MyJvm.getInstance();
		 System.out.println(s1);
		 System.out.println(s2);
		 
		 //ͨ���������л�  �ͷ����л����ܶ������
		 
		//���л�
		 FileOutputStream fos = new FileOutputStream("d://a.txt");
		 ObjectOutputStream oos = new ObjectOutputStream(fos);
		 oos.writeObject(s1);
		 oos.close();
		 fos.close();
		 
		 //�����л�
		 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d://a.txt"));
		 MyJvm s3 = (MyJvm) ois.readObject();
		 System.out.println(s3);
		 
	}
}



