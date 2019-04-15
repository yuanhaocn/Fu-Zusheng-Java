package com.syc.ws.httpclient04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageClient {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://pimg1.126.net/movie/product/movie/151212200931411251_260_346_webp.jpg");
			// 得到一个网络连接对象
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置请求方法
			conn.setRequestMethod("GET");
			// 设置连接超时时间
			conn.setConnectTimeout(5000);
			// 设置读取数据的超时时间
			conn.setReadTimeout(5000);

			// 判断是否和服务器建立了连接
			if (conn.getResponseCode() == 200) {
				// 获取服务器传递过来的内容
				InputStream is = conn.getInputStream();

				File file = new File("//psf/Home/Desktop/test.jpg");
				if (!file.exists()) {
					file.mkdirs();
				}
				
				FileOutputStream fos = new FileOutputStream(file);
				int len=0;
				byte[] buffer=new byte[1024];
				while((len=is.read(buffer))!=-1){
					fos.write(buffer, 0, len);
					fos.flush();
				}
				
				fos.close();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
