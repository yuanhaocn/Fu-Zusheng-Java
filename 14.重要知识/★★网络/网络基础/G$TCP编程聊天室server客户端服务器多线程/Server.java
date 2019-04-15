package G$TCP���������server�ͻ��˷��������߳�;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * ����������
 * ������ʵ�ֶ��߳�
 * ��һ���ַŽ��ڲ����У��ڲ����һ���ô������ڷ���˽�е�����
 */
public class Server {
	//Ϊ��ʵ��Ⱥ�ĵ�Ч������������һ�������������桰��·�������Ƿ�������ÿ���ͻ������ӵ��Ǹ�����
	private List<MyChannel> all= new ArrayList<MyChannel>();
	public static void main(String[] args) throws Exception {
		new Server().start();
		
	}
	
	public void start() throws Exception {
		//����һ���ͻ���
			ServerSocket server = new ServerSocket(9999);
			while(true) {
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			all.add(channel);//��ͽ��κ�һ�����ܵ��������ӵ��������������ȥ�ˣ��������ͳһ����
			new Thread(channel).start();//һ����·
			}
	}
	/*һ���ͻ���һ����·
	 * 1.������
	 * 2.�����
	 * 3.��������
	 * 4.��������
	 */
	
	private class MyChannel implements Runnable{
		private DataInputStream dis;
		private  DataOutputStream dos;
		private boolean isRunning =true;
		
		//ͬ���Ĺ����������ʼ��
		public MyChannel(Socket client) {
			try {
				dis=new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dis,dos);
				isRunning =false;
			}
		}
		/*
		 * ��ȡ����
		 */
		private String receive() {
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning =false;
				all.remove(this);//ֻҪ��ǰ������ܵ������⣬���ǾͰ��������������Ƴ�ȥ
			}
			return msg;
		}
		/*
		 * ��������
		 */
		
		private void send(String msg) {
			if(null==msg || msg.equals("")) {
				return ;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CloseUtil.closeAll(dos);
			isRunning =false;
			all.remove(this);//ֻҪ��ǰ������ܵ������⣬���ǾͰ��������������Ƴ�ȥ
		}
		/*
		 * ���͸������ͻ���,�����������ܵ���
		 */
		private void sendOther() {
			String msg = this.receive();
			//��������
			for(MyChannel other:all) {
				if(other==this) {
					continue;
				}
				//���͸������ͻ���
				other.send(msg);
			}
		}
		@Override
		public void run() {
			while(isRunning) {
				sendOther( );
			}
		}
	}
}
