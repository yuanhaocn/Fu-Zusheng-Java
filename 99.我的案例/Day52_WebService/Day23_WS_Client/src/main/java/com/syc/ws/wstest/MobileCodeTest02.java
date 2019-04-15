package com.syc.ws.wstest;

import javax.xml.namespace.QName;
import javax.xml.ws.*;

import com.syc.ws.mobile02.ArrayOfString;
import com.syc.ws.mobile02.MobileCodeWSSoap;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileCodeTest02 {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		try {
			// 指明WebService的服务地址
			URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");

			// namespaceURI:命名空间
			// localPart:服务端服务的名称
			QName qName = new QName("http://WebXml.com.cn/", "MobileCodeWS");
			// 创建服务对象
			Service service = Service.create(url, qName);
			// 获取接口对象
			MobileCodeWSSoap port = service.getPort(MobileCodeWSSoap.class);
			// 手机号码信息
			// String codeInfo = port.getMobileCodeInfo("14705512531", null);
			String codeInfo = port.getMobileCodeInfo("15800789341", null);
			System.out.println(codeInfo);

			ArrayOfString phones = port.getDatabaseInfo();
			for (String phone : phones.getString()) {
				System.out.println("phone=" + phone);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
