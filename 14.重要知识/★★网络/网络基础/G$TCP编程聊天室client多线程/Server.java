package G$TCP���������client���߳�;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ����������
 * ������ã�Ⱥ�Ŀͻ���֮������Ⱥ�˳�򣬿ͻ���֮�䲻Ӧ�ô����Ⱥ�˳������Ҫʹ�ö��̸߳Ľ�192
 */
public class Server {
	public static void main(String[] args) throws Exception {
		//����һ���ͻ���
		ServerSocket server = new ServerSocket(9999);
		while(true) {
		Socket client = server.accept();
		
		//������
		 DataInputStream dis = new DataInputStream(client.getInputStream());
		 DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		while(true) {
		 String msg = dis.readUTF();
		 System.out.println(msg);
		//�����
		 dos.writeUTF("������--��"+msg);
		 dos.flush(); 
		}
		}
	}
}
