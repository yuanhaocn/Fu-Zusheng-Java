package ��$��ӡ��;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * System.out.prinlln()-->PrintStream.println()
 * Ϊ���������
 *printStream��Կ���̨
 *FileOutputStream����ļ�
 *
 *���� �����������ƹ��ļ�������ֱ�Ӳ����ļ��Ŀ��ܣ��ײ��������ֱ�Ӳ���
 *
 */
public class Demo {
	 public static void main(String[] args) throws Exception {
		//��ȡPrintStream����
	 PrintStream ps = new PrintStream(new File("C:\\Users\\FZS\\Pictures\\����5.txt"));
		 //����write����
		ps.write("helloworld".getBytes());
		 ps.flush();
	}
}
