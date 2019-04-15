package com.syc.ws.httpclient04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONClient {

	public static void main(String[] args) {
		try {
			URL url = new URL(
					"http://piao.163.com/m/movie/list.html?app_id=2&mobileType=iPhone&ver=2.5&channel=lede&deviceId=C1985DD9-0125-4AB5-B66B-B91A85824BBA&apiVer=11&city=110000");
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
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}

				System.out.println("JSON字符串=" + sb.toString());

				// String msg = sb.toString();
				// JSONObject object=JSON.parse(msg);
				//解析json
				//得到图片的url地址
				//下载图片?

				br.close();
				is.close();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
