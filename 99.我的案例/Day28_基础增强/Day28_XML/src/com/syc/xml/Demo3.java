package com.syc.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo3 {

	@SuppressWarnings("unchecked")
	@Test
	public void getNodeText() {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("./src/contact.xml"));
			Element rootElement = doc.getRootElement();
			List<Element> elements = rootElement.elements("contact");
			
			List<Contact> contacts=new ArrayList<>();
			for (Element elmt : elements) {
				//获取名称节点
				Element nameElmt = elmt.element("name");
				//获取名称节点中的值
				String name = nameElmt.getText();
				// nameElmt.getTextTrim();
				//获取tel几点
				Element telElmt = elmt.element("tel");
				String tel = telElmt.getText();
				
				//封装JavaBean
				Contact contact=new Contact();
				contact.setName(name);
				contact.setTel(tel);
				contacts.add(contact);
			}

			System.out.println(contacts.size()+"--"+contacts.get(0).getName());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
