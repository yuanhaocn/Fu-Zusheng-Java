package A$�ļ��ָ�;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * ��������
 * 1��System.in  ������  ��������
 * 2��System.out �����   ����̨���
 *    System.err
 *    
 * ==>�ض���   
 * setIn()
 * setOut()
 * setErr()
 * FileDescriptor.in
 * FileDescriptor.out
 * @author Administrator
 *
 */
public class SystemDemo01 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//test1();
		//test2();
		//�ض���
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("e:/xp/test/print.txt")),true));
		System.out.println("a");  //����̨  -->�ļ�		
		System.out.println("test");
		//�ؿ���̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("back....");
	}
	public static void test2() throws FileNotFoundException{
		InputStream is =System.in;  //��������
		is = new BufferedInputStream(new FileInputStream("e:/xp/test/print.txt"));
		Scanner sc = new Scanner(is);
		//System.out.println("������:");
		System.out.println(sc.nextLine());
	}
	
	public static void test1(){
		System.out.println("test");
		System.err.println("err");
	}

}
