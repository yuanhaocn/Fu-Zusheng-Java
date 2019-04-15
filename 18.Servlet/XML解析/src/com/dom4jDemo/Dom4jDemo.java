package com.dom4jDemo;
/**
 * ֱ�Ӵ�ӡ�Ǵ�ӡ��������ģ�ֻ�ܴ�ӡ�����ڵ���ӽڵ�
 */
import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {

	public static void main(String[] args) throws Exception {
		//1.����SAXReader������Ҫdom4j��jar
		SAXReader sr = new SAXReader();
		//2.ʹ��xml�ļ�����file����
		File file=new File("C:\\Users\\FZS\\eclipse-workspace\\XML����\\src\\com\\dom4jDemo\\Dog.xml");
		//3.ʹ��sexReader�������xml
		Document document = sr.read(file);
		//4.��ȡ���ڵ�
		Element root = document.getRootElement();
		System.out.println(root.getNodeType()+"  "+root.getName()+"   "+root.getText());
		//5.��ȡ���ڵ�ĵ�����
		Iterator<Element> iterator = root.elementIterator();
		//6.�������ı���
		while (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			//7.��ȡ�ýڵ��nodetype nodename ��nodevalue
			short nodeType = element.getNodeType();
			String name = element.getName();
			String nodeValue = element.getText();
			//8.��ӡ
			System.out.println(nodeType+"   "+name+"   "+nodeValue);
		}
	}

}
