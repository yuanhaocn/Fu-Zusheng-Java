package F$Socket��TCP���;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
/**
 * * Socketͨ��
 * ����tcpЭ�飬�����ȶ����ӵĵ�Ե��ͨ��
 * 	ʵʱ�����٣���ȫ�Ըߣ�ռ��ϵͳ��Դ�࣬Ч�ʵ�
 * ������-��Ӧ��ģʽ
 * 	�ͻ���
 * 		������ͨѶ�У���һ����������ͨѶ�ĳ��򱻳����ͻ��˳���
 * ������
 * 		��һ��ͨѶ�еȴ����ӵĳ��򱻳�������������
 * Socket:����TCP��Ϣ
 * ServerSocket:����������
 *  �׽��֣���һ�ֽ��̼�����ݽ������ƣ���Щ���̼�������ͬһ�����ϣ�Ҳ������ͨ���������ӵĲ�ͬ�����ϣ����仰˵���׽�������ͨ�Ŷ˵��
 *  ���ã������׽�����һ���˵㣬��һ���׽����򹹳�һ��˫��ͨ���ŵ���ʹ�ǹ����Ľ��̿����Ա��ػ���ͨ������������ݽ���
 *  һ�������׽������ӣ����ݼ�������ͬ���߲�ͬ��ϵͳ��˫����ߵ����ͣ�ֻ������һ���˵�ر����� 
 *
 */

public class Client {
	public static void main(String[] args) throws Exception {

		//����InetAddress
		InetAddress address = InetAddress.getLocalHost();
		//�����˿�,һ����1024֮��
		int port =8888;
		/*
		 * �����ͻ����׽���
		 * �ͻ��˴������ݳ�ȥҲ����Ҫ�˿ڵģ�ֻ����Socket�Լ����䣬����UDP��Ҫ���Լ�ָ�����˵� �˿�
		 * ������
		 * ��һ����InetAddress����String��IP��ַ
		 * �ڶ������˿ں�
		 */
		
//1.�����ͻ��� ����ָ��������+�˿ڣ���ʱ��������,·�Ѿ�ͨ��	
		Socket socket = new Socket(address,port);
//2.��������
		/*		
		//��һ����������Ҫͬ���Ļ�
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());//Ҳ��һ������ʽ�ķ��������ж�ȡ
		 */		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		System.out.println(dis.readUTF());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		
		
		//ʹ��socket��ȡ�����
		OutputStream os = socket.getOutputStream();
		//�����ļ�������
		FileInputStream fis = new FileInputStream("F://15501.wmv");
		//����һ��ư��������
		byte[] bytes = new byte[1024];
		System.out.println("�ļ��ϴ��Ѿ���ʼ");
		int capacity=0;
		
		//ѭ�����
		while((capacity=fis.read(bytes))!=-1) {
			os.write(bytes,0,capacity);
		}
		os.flush();
		os.close();
		fis.close();
		System.out.println("�ļ��ϴ��Ѿ�����");*/
		
	}
}
