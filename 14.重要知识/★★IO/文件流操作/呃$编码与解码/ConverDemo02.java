package ��$���������;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ת����: �ֽ�תΪ�ַ�
 * 1������� OutputStreamWriter ����
 * 2�������� InputStreamReader  ����
 * ȷ��Դ����Ϊ����
 */
public class ConverDemo02 {
	public static void main(String[] args) throws IOException {
		//ָ�������ַ���
		BufferedReader br =new BufferedReader(
				new InputStreamReader(
					new BufferedInputStream(
							new FileInputStream( 
									new File("E:/xp/test/Demo03.java"))),"UTF-8")
				);
		//д���ļ� ����
		BufferedWriter bw =new BufferedWriter(
				new OutputStreamWriter(
					new BufferedOutputStream(	
					new FileOutputStream(new File("E:/xp/test/encode.java")))));
				
		String info =null;
		while(null!=(info=br.readLine())){
			//System.out.println(info);
			bw.write(info);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
