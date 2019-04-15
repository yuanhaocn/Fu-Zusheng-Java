package D$网络爬虫原理;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URI(Uniform resource identifier)统一资源标识符，用来唯一的标识一个资源
 * URL(Uniform resource Locator)统一资源定位器，它是一种具体的URI
 * 统一资源定位符，由4个部分组成：协议，存放资源的主机域名，资源文件名和端口号
 *  url是指向互联网“资源”的指针
 *  资源可以是简单的文件或者目录，也可以是对更为复杂的对象的引用，例如对数据库或者搜索引擎的查询
 * 
 * URL：
	一、创建
		URL(String spec)  :绝对路径构建
		URL(URL context, String spec)  :相对路径构建
	二、方法
		System.out.println("协议:"+url.getProtocol());
		System.out.println("域名:"+url.getHost());
		System.out.println("端口:"+url.getPort());
		System.out.println("资源:"+url.getFile());
		System.out.println("相对路径:"+url.getPath());
		System.out.println("锚点:"+url.getRef()); //锚点
		System.out.println("参数:"+url.getQuery());//?参数 :存在锚点  返回null ,不存在，返回正确
	三、流
		openStream() 
 *
 */
public class TestURL {
	public static void main(String[] args) throws MalformedURLException {
		//绝对路径构造
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");
		System.out.println("协议:"+url.getProtocol());
		System.out.println("域名:"+url.getHost());
		System.out.println("端口:"+url.getPort());
		System.out.println("资源:"+url.getFile());
		System.out.println("相对路径:"+url.getPath());
		System.out.println("锚点:"+url.getRef()); //锚点
		System.out.println("参数:"+url.getQuery());//?之后的参数 :存在锚点  返回null ,不存在，返回正确
 
			 
	}
}
