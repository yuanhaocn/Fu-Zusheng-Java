package F$Socket￥TCP编程;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
/**
 * * Socket通信
 * 基于tcp协议，建立稳定连接的点对点的通信
 * 	实时，快速，安全性高，占用系统资源多，效率低
 * “请求-响应”模式
 * 	客户端
 * 		在网络通讯中，第一次主动发起通讯的程序被称作客户端程序
 * 服务器
 * 		第一次通讯中等待连接的程序被称作服务器程序
 * Socket:发送TCP消息
 * ServerSocket:创建服务器
 *  套接字：是一种进程间的数据交换机制，这些进程即可以在同一机器上，也可以在通过网络连接的不同机器上，换句话说，套接字起到了通信端点的
 *  作用，单个套接字是一个端点，而一对套接字则构成一个双向通信信道，使非关联的进程可以自本地或者通过网络进行数据交换
 *  一旦建立套接字连接，数据即可在相同或者不同的系统中双向或者单向发送，只到其中一个端点关闭连接 
 *
 */

public class Client {
	public static void main(String[] args) throws Exception {

		//构架InetAddress
		InetAddress address = InetAddress.getLocalHost();
		//构建端口,一般在1024之后
		int port =8888;
		/*
		 * 创建客户端套接字
		 * 客户端传输数据出去也是需要端口的，只不过Socket自己分配，不想UDP需要你自己指定两端的 端口
		 * 参数：
		 * 第一个：InetAddress或者String的IP地址
		 * 第二个：端口号
		 */
		
//1.创建客户端 必须指定服务器+端口，此时就在连接,路已经通了	
		Socket socket = new Socket(address,port);
//2.接收数据
		/*		
		//换一种流，但是要同步的换
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());//也是一种阻塞式的方法，整行读取
		 */		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		System.out.println(dis.readUTF());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		
		
		//使用socket获取输出流
		OutputStream os = socket.getOutputStream();
		//构建文件输入流
		FileInputStream fis = new FileInputStream("F://15501.wmv");
		//定义一个瓢，和容量
		byte[] bytes = new byte[1024];
		System.out.println("文件上传已经开始");
		int capacity=0;
		
		//循环输出
		while((capacity=fis.read(bytes))!=-1) {
			os.write(bytes,0,capacity);
		}
		os.flush();
		os.close();
		fis.close();
		System.out.println("文件上传已经结束");*/
		
	}
}
