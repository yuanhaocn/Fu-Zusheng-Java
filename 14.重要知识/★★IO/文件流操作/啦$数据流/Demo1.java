package ��$������;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 *�ļ������ new DataOutputStream(new FileOutputStream(new File(c://fzs.txt)));
 *���ݿ���д�������ǳ���Ա�޷�����
 */
public class Demo1 {
	public static void main(String[] args) {
		//�����ļ������
		//�����ļ�������������������
		try(FileOutputStream fos = new FileOutputStream("C:\\Users\\FZS\\Pictures\\����5.txt");
				DataOutputStream dos = new DataOutputStream(fos);) {
			//д��int����
			/*dos.writeInt(10);
			dos.writeDouble(13.14);*/
			dos.writeUTF("fzs������");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
