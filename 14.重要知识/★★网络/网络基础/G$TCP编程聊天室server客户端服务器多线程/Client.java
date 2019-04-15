package G$TCP编程聊天室server客户端服务器多线程;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
public class Client {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket(InetAddress.getLocalHost(),9999);
		new Thread(new Send(client)).start();//控制台输入流，一个线程，一条路径
		new Thread(new Receive(client)).start();//一个线程
	}
}
