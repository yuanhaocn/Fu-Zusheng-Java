package D$��������ԭ��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 *��ȡ��Դ:Դ����
 * HTML:������ʽ�����ݵ�
 * CSS:�����������ݵ�
 * JS�������������ݵ�
 * 
 * 
 * ����������Ҫ��������ʽ�������ݣ������õ����ݴ�����
 *
 */
public class URLDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.dotamax.com");//���ʵ�����ҳ������˵��Ĭ����Դ
	/*	//��ȡ������Դ��������	
		InputStream is = url.openStream();
		byte[] flush =new byte[1024];
		int len =0;
		while(-1!=(len=is.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
		is.close();*/
		
		//ʹ��ת����
		
		BufferedReader br = 
		new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		//�����ȥ�����������
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("�ٶ�.html"),"utf-8"));
		String msg=null;
		while((msg=br.readLine())!=null) {
		//	System.out.println(msg);
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
