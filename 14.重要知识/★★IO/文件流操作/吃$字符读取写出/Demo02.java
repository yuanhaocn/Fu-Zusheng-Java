package ��$�ַ���ȡд��;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * д���ļ�
 * @author Administrator
 *
 */
public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����Դ
		File dest =new File("e:/xp/test/char.txt");
		//ѡ����
		Writer wr =null;
		try {
			//׷���ļ��������Ǹ����ļ�
			wr =new FileWriter(dest);
			//д��
			String msg ="׷��.....�����յ���\r\n��ũ������\r\nһ��С����\r\nһ��һ����";
			wr.write(msg);
			wr.append("�������˿����Ӿ� ");
			
			wr.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (null != wr) {
					wr.close();
				}
			} catch (Exception e2) {
			}
		}
	}

}
