package ��$ת����;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * ת����OutputStreamWriter
 * ��������ַ���ͨ���ֽ���������
 * �����ô��ǽ���ϵͳ���������Scanner������תΪ�ֽ�
 * 
 */
public class TestOutputStreamWriter {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		//�����ַ�ת����+������ӡ�ֽ�����Ϊ����
		try(OutputStreamWriter osw = new OutputStreamWriter(ps);) {
			osw.write("hello world");
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
