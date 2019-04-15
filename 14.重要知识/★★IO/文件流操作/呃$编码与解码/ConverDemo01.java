package 呃$编码与解码;

import java.io.UnsupportedEncodingException;

public class ConverDemo01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str ="中国";
		byte[] data =str.getBytes();
		//字节数不完整
		System.out.println(new String(data,0,3));
		test1();
	}
	/**
	 * 编码与解码字符集必须相同，否则乱码
	 */
	public static void test1() throws UnsupportedEncodingException{
		//解码 byte -->char
				String str ="中国"; //gbk 
				byte[] data =str.getBytes();//编码 char -->byte
				System.out.println(new String(data));//编码与解码字符集同一
				data =str.getBytes("utf-8"); //设定编码字符集
				System.out.println(new String(data));//不同一出现乱码
				byte[] data2 = "中国".getBytes("utf-8");//编码
				str=new String(data2,"utf-8");//解码
				System.out.println(str);
	}

}
