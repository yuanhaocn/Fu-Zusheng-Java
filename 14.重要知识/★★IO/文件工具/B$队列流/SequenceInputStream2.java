package B$������;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;
/**
 * ����ʵ�������ļ��ĺϲ�����Լ��ļ��ϲ�
 *
 */
public class SequenceInputStream2 {
	public static void main (String[] args) throws Exception {
		//��ȡö�ٵ����ã�����Vector
		Vector<InputStream> vector = new Vector<InputStream>();
		//���������ļ��������������������
		File file1 = new File("C://Users//FZS//Pictures//����1.txt");
		File file2 = new File("C://Users//FZS//Pictures//����2.txt");
		File file3 = new File("C://Users//FZS//Pictures//����3.txt");
		//�����ļ����� �����ļ�������
		FileInputStream fis01 = new FileInputStream(file1);
		FileInputStream fis02 = new FileInputStream(file2);
		FileInputStream fis03 = new FileInputStream(file3);
		//ʹ�û�������װ�����ĵ�������
		BufferedInputStream bis01 = new BufferedInputStream(fis01);
		BufferedInputStream bis02 = new BufferedInputStream(fis02);
		BufferedInputStream bis03 = new BufferedInputStream(fis03);
		//������������д�뼯��
		vector.add(bis01);
		vector.add(bis02);
		vector.add(bis03);
		//���ü��ϵ�elements��������ȡö�ٵ�����
		Enumeration<InputStream> elements = vector.elements();
		//����ö�ٵ����ù�������������
		SequenceInputStream sis = new SequenceInputStream(elements);
		
		byte[] bytes = new byte[1024];
		int capacity=0;
		//�����ļ���������󣬲�ʹ�û�������װ
		File fileTarget=new File("C://Users//FZS//Pictures//�ϼ�.txt");
		FileOutputStream fos = new FileOutputStream(fileTarget);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
	
		while((capacity=sis.read(bytes))!=-1) {
			System.out.println(new String(bytes,0,capacity));
			bos.write(bytes,0,capacity);
		}
		bos.flush();
		
	
	}
}
