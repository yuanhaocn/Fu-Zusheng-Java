package D$��������ԭ��;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URI(Uniform resource identifier)ͳһ��Դ��ʶ��������Ψһ�ı�ʶһ����Դ
 * URL(Uniform resource Locator)ͳһ��Դ��λ��������һ�־����URI
 * ͳһ��Դ��λ������4��������ɣ�Э�飬�����Դ��������������Դ�ļ����Ͷ˿ں�
 *  url��ָ����������Դ����ָ��
 *  ��Դ�����Ǽ򵥵��ļ�����Ŀ¼��Ҳ�����ǶԸ�Ϊ���ӵĶ�������ã���������ݿ������������Ĳ�ѯ
 * 
 * URL��
	һ������
		URL(String spec)  :����·������
		URL(URL context, String spec)  :���·������
	��������
		System.out.println("Э��:"+url.getProtocol());
		System.out.println("����:"+url.getHost());
		System.out.println("�˿�:"+url.getPort());
		System.out.println("��Դ:"+url.getFile());
		System.out.println("���·��:"+url.getPath());
		System.out.println("ê��:"+url.getRef()); //ê��
		System.out.println("����:"+url.getQuery());//?���� :����ê��  ����null ,�����ڣ�������ȷ
	������
		openStream() 
 *
 */
public class TestURL {
	public static void main(String[] args) throws MalformedURLException {
		//����·������
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");
		System.out.println("Э��:"+url.getProtocol());
		System.out.println("����:"+url.getHost());
		System.out.println("�˿�:"+url.getPort());
		System.out.println("��Դ:"+url.getFile());
		System.out.println("���·��:"+url.getPath());
		System.out.println("ê��:"+url.getRef()); //ê��
		System.out.println("����:"+url.getQuery());//?֮��Ĳ��� :����ê��  ����null ,�����ڣ�������ȷ
 
			 
	}
}
