package ��$��ӡ��;
/**
 * 	Scanner��
		ɨ����:ɨ��������߳����������ȴ��û�����������û������룬һ�´�������״̬�����������ı�־�ǻس��������û�����Ŀո�
	
11.Scanner�Ĺ��췽��
	Scanner(InputStream source)  ����һ���µ� Scanner�������ɵ�ֵ�Ǵ�ָ����������ɨ��ġ�
	���룺
		//�û�������������������	Scanner sc = new Scanner(System.in);
		String input = sc.next();//next�����ǵ�������ɨ�蹦��
	���ۣ�	
		next�����������������ַ��ģ����ǽ���ɨ���û��������
		nextɨ���ַ�����nextIntɨ������
		
Scanner�ĵ�������ȡ�ĵ�
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo2 {
	 public static void main(String[] args) throws FileNotFoundException {
			// ��ȡ��ӡ��
			PrintStream psConsole = System.out;
			// ���ڿ���̨��ӡhello
			psConsole.println("hello");
			//��ȡ��ӡ������
			System.out.println(psConsole);

			// *************************************
			File file = new File("C://Users//FZS//Pictures//����5.txt");
			PrintStream psFile = new PrintStream(file);
			//�����ĵ�����д��hello
			psFile.println("hello");
	 }
}
