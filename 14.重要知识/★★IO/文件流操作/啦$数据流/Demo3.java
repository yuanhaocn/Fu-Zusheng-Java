package ��$������;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 1).
 * ��֤���ݵĶ�ȡ˳������ݵĴ洢˳��һ��
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		//��װһ��DataInputStreaam����
	
		try(	FileOutputStream fos = new FileOutputStream("C:\\Users\\FZS\\Pictures\\����5.txt");
				DataOutputStream dos = new DataOutputStream(fos);
				FileInputStream fis  = new FileInputStream("C:\\Users\\FZS\\Pictures\\����5.txt");
				DataInputStream dis  = new DataInputStream(fis);) {
			//��һ���ѻ�����������д���ĵ�
			dos.writeInt(12);
			dos.writeDouble(13.14);
			dos.writeBoolean(true);
			dos.writeUTF("fzs��lzy");
			//�ڶ��������ĵ��еĻ����������Ͷ�����
			int readInt = dis.readInt();
			double readDouble = dis.readDouble();
			boolean readBoolean = dis.readBoolean();
			String readUTF = dis.readUTF();
			//������ ������������
			System.out.println(readInt+"  "+readDouble+" "+readBoolean+" " +readUTF);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
