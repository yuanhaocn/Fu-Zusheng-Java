package G$TCP���������client���߳�;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
/**
 *���㣺���������������ͬһ���߳��ڣ�Ӧ�ñ˴˶��� 
 *
 */

public class Client {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket(InetAddress.getLocalHost(),9999);
		new Thread(new Send(client)).start();//����̨��������һ���̣߳�һ��·��
		new Thread(new Receive(client)).start();//һ���߳�
	}
}
