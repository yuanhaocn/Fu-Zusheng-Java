package G$TCP编程聊天室client多线程;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 创建服务器
 * 这个不好，群聊客户端之间存在先后顺序，客户端之间不应该存在先后顺序，所以要使用多线程改进192
 */
public class Server {
	public static void main(String[] args) throws Exception {
		//这是一个客户端
		ServerSocket server = new ServerSocket(9999);
		while(true) {
		Socket client = server.accept();
		
		//输入流
		 DataInputStream dis = new DataInputStream(client.getInputStream());
		 DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		while(true) {
		 String msg = dis.readUTF();
		 System.out.println(msg);
		//输出流
		 dos.writeUTF("服务器--》"+msg);
		 dos.flush(); 
		}
		}
	}
}
