package ��$�������л�;
/**
 * �������л����
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test01 {
	public static void main(String[] args) {
	File file = new File("C://Users//FZS//Pictures//fzs.txt");	
	//����һ������
	book book = new book(1,"������de����",13.14,"fzs��lzy");
	
	try (//�����ļ������
		FileOutputStream fos = new FileOutputStream(file);
		//�����ļ�������������������
		ObjectOutputStream oos = new ObjectOutputStream(fos);){
		oos.writeObject(book);
		oos.flush();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
