package G$TCP编程聊天室server客户端服务器多线程;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * 创建服务器
 * 服务器实现多线程
 * 把一部分放进内部类中，内部类的一个好处，便于访问私有的属性
 */
public class Server {
	//为了实现群聊的效果，我们设置一个容器，用来存“道路”，就是服务器和每个客户端连接的那个东东
	private List<MyChannel> all= new ArrayList<MyChannel>();
	public static void main(String[] args) throws Exception {
		new Server().start();
		
	}
	
	public void start() throws Exception {
		//这是一个客户端
			ServerSocket server = new ServerSocket(9999);
			while(true) {
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			all.add(channel);//这就将任何一个“管道”，都加到我这个容器里面去了，方便对其统一管理
			new Thread(channel).start();//一条道路
			}
	}
	/*一个客户端一条道路
	 * 1.输入流
	 * 2.输出流
	 * 3.接收数据
	 * 4.发送数据
	 */
	
	private class MyChannel implements Runnable{
		private DataInputStream dis;
		private  DataOutputStream dos;
		private boolean isRunning =true;
		
		//同样的构造器里面初始化
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
		 * 读取数据
		 */
		private String receive() {
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				//e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning =false;
				all.remove(this);//只要当前的这个管道有问题，我们就把它从容器里面移出去
			}
			return msg;
		}
		/*
		 * 发送数据
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
			all.remove(this);//只要当前的这个管道有问题，我们就把它从容器里面移出去
		}
		/*
		 * 发送给其他客户端,遍历容器（管道）
		 */
		private void sendOther() {
			String msg = this.receive();
			//遍历容器
			for(MyChannel other:all) {
				if(other==this) {
					continue;
				}
				//发送给其他客户端
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
