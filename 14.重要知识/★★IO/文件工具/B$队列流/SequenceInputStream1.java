package B$������;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.SequenceInputStream;

public class SequenceInputStream1 {
	public static void main(String[] args) {
		//�����ļ����󹹽�������
		File file1 = new File("C://Users//FZS//Pictures//����1.txt");
		File file2 = new File("C://Users//FZS//Pictures//����2.txt");
		//�����ļ����� �����ļ�������
		try(FileInputStream fis01 = new FileInputStream(file1);
			 FileInputStream fis02 = new FileInputStream(file2);
			//ʹ�û�������װ�����ĵ�������
			BufferedInputStream bis01 = new BufferedInputStream(fis01);
			BufferedInputStream bis02 = new BufferedInputStream(fis02);
			SequenceInputStream sis = new SequenceInputStream(bis01,bis02);	) {
			//����һ���������ݵ�byte����
			byte[] bytes = new byte[1024];
			int capacity=0;
			
			while((capacity=sis.read(bytes))!=-1) {
				System.out.println(new String(bytes,0,capacity));
			}} catch (Exception e) {}}}
