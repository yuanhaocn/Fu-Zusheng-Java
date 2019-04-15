package com.syc.ws.httpclient04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClientWS {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
			// 得到一个网络连接对象
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置请求方法
			conn.setRequestMethod("POST");
			// 设置连接超时时间
			conn.setConnectTimeout(5000);
			// 设置读取数据的超时时间
			conn.setReadTimeout(5000);
			// 设置请求参数
			conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

			// 是否可以输出数据
			conn.setDoOutput(true);
			// 是否可以读取数据
			conn.setDoInput(true);

			// 真正的进行连接
			// conn.connect();
			// 断开连接
			// conn.disconnect();

			//xml格式的字符串
			String xml = getXml("15800789341");
			//用来向服务器发送信息
			OutputStream os = conn.getOutputStream();
			os.write(xml.getBytes());
			os.close();
			
			// 判断是否和服务器建立了连接
			if (conn.getResponseCode() == 200) {
				// 获取服务器传递过来的内容
				InputStream is = conn.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}

				System.out.println("归属地=" + sb.toString());
				br.close();
				is.close();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 必须是这种格式的数据才可以
	private static String getXml(String phoneNum) {
		// 根据手机号生成遵循soap规范的xml数据
		String data = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "<soap:Body>" + "<getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">" + "<mobileCode>" + phoneNum
				+ "</mobileCode>" + "<userID></userID>" + "</getMobileCodeInfo>" + "</soap:Body>" + "</soap:Envelope>";
		return data;
	}
}
