package D$网络爬虫原理;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 *获取资源:源代码
 * HTML:用来格式化数据的
 * CSS:用来美化数据的
 * JS：用来交互数据的
 * 
 * 
 * 网络爬虫需要用正则表达式解析数据，把有用的数据存起来
 *
 */
public class URLDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.dotamax.com");//访问的是主页，或者说是默认资源
	/*	//获取网络资源，网络流	
		InputStream is = url.openStream();
		byte[] flush =new byte[1024];
		int len =0;
		while(-1!=(len=is.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
		is.close();*/
		
		//使用转换流
		
		BufferedReader br = 
		new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		//输出出去到计算机磁盘
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("百度.html"),"utf-8"));
		String msg=null;
		while((msg=br.readLine())!=null) {
		//	System.out.println(msg);
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
