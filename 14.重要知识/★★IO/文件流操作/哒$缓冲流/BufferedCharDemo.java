package ��$������;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * �ַ������� +��������(���ܷ�����̬)
 */
public class BufferedCharDemo {
	public static void main(String[] args) {
		//����Դ ������ �ַ��Ĵ��ı�
		File src =new File("E:/xp/test/Demo03.java");
		File dest =new File("e:/xp/test/char.txt");
		//ѡ����
		try (BufferedReader	reader =new BufferedReader(new FileReader(src));
				BufferedWriter	wr =new BufferedWriter(new FileWriter(dest));){
			/*//��ȡ����
			char[] flush =new char[1024];
			int len =0;
			while(-1!=(len=reader.read(flush))){
				wr.write(flush, 0, len);
			}*/
			String line =null;
			while(null!=(line=reader.readLine())){	//���������Ĳ���һ�ζ�ȡһ��
				wr.write(line);
				//wr.append("\r\n");
				wr.newLine(); //���з���
			}
			wr.flush();//ǿ��ˢ��
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
