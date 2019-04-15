package B$����ֲ�;
/**
1��InetAddress :��װ IP ��DNS
 ����:
getHostAddress() ����ip��ַ
getHostName() ��������|����Ϊ�������
InetAddress.getLocalHost();
InetAddress.getByName("ip��ַ|����");
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetDemo {
	public static void main(String[] args) throws UnknownHostException{
		InetAddress[] ips = InetAddress.getAllByName("DESKTOP-CVFEM0T");
		System.out.println(Arrays.toString(ips));
		/*����һ��IPv4�����飬���ȱ���4���������ٻ��߶�
		 * �Գ���127��������Ҫǿת
		 */
		byte[] bytes = {10,11,54,54};
		InetAddress byAddress = InetAddress.getByAddress(bytes);
		System.out.println(byAddress);
		//��ȡ���������������Ӫ��
		InetAddress byName = InetAddress.getByName("www.baidu.com");
		System.out.println(byName);
		//��ȡ����������ַ
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);
//**********************************************************************	
		//��ȡָ��������IP��ַ
		byte[] bytes1 = localHost.getAddress();
		//��ȡIP��ַ�����ַ�������ʽ
		String hostAddress = localHost.getHostAddress();
		System.out.println(hostAddress);
		//��ȡIP��ַ��Ӧ����������������
		String hostName = localHost.getHostName();
		System.out.println(hostName);
	}

}
