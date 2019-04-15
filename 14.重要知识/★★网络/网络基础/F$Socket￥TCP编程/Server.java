package F$Socket￥TCP编程;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args) throws Exception {

//1.创建服务器，指定端口serverSocket	依赖端口使用ServerSocket构建服务器套接字
		ServerSocket server = new ServerSocket(8888);
/*
 * 2.接收客户端的连接	线程阻塞式的	
 * 调用accept方法，把服务器套接字转为客户端套接字
 * 浏览器也是一个基于TCP的客户端
 */
		Socket socket = server.accept();
		System.out.println("服务器已经开始运行，阻塞接收数据中");
		
//3.发送数据+接收数据	,管道已经铺好了，内部还是流	
		String msg = "欢迎使用";
		//换一种流，但是要同步的换
	/*	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();*/
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	//使用getInputStream方法获取输入流
		InputStream is = socket.getInputStream();
		
		//构建文件输出流
		FileOutputStream fos = new FileOutputStream("C:\\Users\\FZS\\Pictures");
		//定义数组和长度变量
		byte[] bytes = new byte[1024];
		int capacity=0;
		while((capacity=is.read(bytes))!=-1) {
			fos.write(bytes,0,capacity);
		}
		fos.flush();
		fos.close();
		is.close();
		System.out.println("服务器已经结束运行");*/
	}
}
