package F$Socket��TCP���;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args) throws Exception {

//1.������������ָ���˿�serverSocket	�����˿�ʹ��ServerSocket�����������׽���
		ServerSocket server = new ServerSocket(8888);
/*
 * 2.���տͻ��˵�����	�߳�����ʽ��	
 * ����accept�������ѷ������׽���תΪ�ͻ����׽���
 * �����Ҳ��һ������TCP�Ŀͻ���
 */
		Socket socket = server.accept();
		System.out.println("�������Ѿ���ʼ���У���������������");
		
//3.��������+��������	,�ܵ��Ѿ��̺��ˣ��ڲ�������	
		String msg = "��ӭʹ��";
		//��һ����������Ҫͬ���Ļ�
	/*	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();*/
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	//ʹ��getInputStream������ȡ������
		InputStream is = socket.getInputStream();
		
		//�����ļ������
		FileOutputStream fos = new FileOutputStream("C:\\Users\\FZS\\Pictures");
		//��������ͳ��ȱ���
		byte[] bytes = new byte[1024];
		int capacity=0;
		while((capacity=is.read(bytes))!=-1) {
			fos.write(bytes,0,capacity);
		}
		fos.flush();
		fos.close();
		is.close();
		System.out.println("�������Ѿ���������");*/
	}
}
