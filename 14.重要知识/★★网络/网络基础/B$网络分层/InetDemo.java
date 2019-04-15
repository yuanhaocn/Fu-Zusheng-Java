package B$网络分层;
/**
1、InetAddress :封装 IP 及DNS
 方法:
getHostAddress() 返回ip地址
getHostName() 返回域名|本机为计算机名
InetAddress.getLocalHost();
InetAddress.getByName("ip地址|域名");
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetDemo {
	public static void main(String[] args) throws UnknownHostException{
		InetAddress[] ips = InetAddress.getAllByName("DESKTOP-CVFEM0T");
		System.out.println(Arrays.toString(ips));
		/*构建一个IPv4的数组，长度必须4，不可以少或者多
		 * 对超过127的字数需要强转
		 */
		byte[] bytes = {10,11,54,54};
		InetAddress byAddress = InetAddress.getByAddress(bytes);
		System.out.println(byAddress);
		//获取距离最近的网络运营商
		InetAddress byName = InetAddress.getByName("www.baidu.com");
		System.out.println(byName);
		//获取本地主机地址
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);
//**********************************************************************	
		//获取指定主机的IP地址
		byte[] bytes1 = localHost.getAddress();
		//获取IP地址，以字符串的形式
		String hostAddress = localHost.getHostAddress();
		System.out.println(hostAddress);
		//获取IP地址对应的主机名或者域名
		String hostName = localHost.getHostName();
		System.out.println(hostName);
	}

}
