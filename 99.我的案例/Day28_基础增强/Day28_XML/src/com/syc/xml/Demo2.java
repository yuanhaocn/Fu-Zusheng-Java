package com.syc.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo2 {

	@Test
	@SuppressWarnings("unchecked")
	public void getAttributeValue() {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("./src/contact.xml"));
			Element root = doc.getRootElement();
			// 得到指定名称的元素迭代器
			Iterator<Element> it = root.elementIterator("contact");
			while (it.hasNext()) {
				Element element = it.next();

				// 1.获取属性的第一种方式
				// Attribute attribute = element.attribute("id");
				// String name = attribute.getName();
				// String value = attribute.getValue();

				// 2.获取属性的第2种方式
				// String value = element.attributeValue("id");

				// 3.获取属性的第3种方式
				List<Attribute> attributes = element.attributes();
				for (Attribute attr : attributes) {
					String name = attr.getName();
					String value = attr.getValue();
					System.out.println("Name=" + name + ",Value=" + value);
				}

			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getNodeText() {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("./src/contact.xml"));
			Element rootElement = doc.getRootElement();
			List<Element> elements = rootElement.elements("contact");
			for (Element elmt : elements) {
				// 得到id属性值
				String id = elmt.attributeValue("id");
				Element nameElmt = elmt.element("name");
				String name = nameElmt.getText();
				// nameElmt.getTextTrim();
				Element telElmt = elmt.element("tel");
				String tel = telElmt.getText();
				System.out.println("ID=" + id + ",Name=" + name + ",TEL=" + tel);
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
