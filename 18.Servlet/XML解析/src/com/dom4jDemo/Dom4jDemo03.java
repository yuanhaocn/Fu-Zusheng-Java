package com.dom4jDemo;
/**
 * �ݹ�+��������ȡxml��������
 * SAXReader����һ��ţ�ƵĴ�ѧ���ڣ� �������κ�һ�ҹ���
 */
import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo03 {

	public static void main(String[] args) throws Exception {
		SAXReader sr = new SAXReader();
		File file=new File("C:\\Users\\FZS\\eclipse-workspace\\XML����\\src\\com\\dom4jDemo\\Cat.xml");
		Document document = sr.read(file);
		
		Element root = document.getRootElement();
		System.out.println(root.getNodeType()+"  "+root.getName()+"   "+root.getText());
		loopShow(root);
	}
	/*
	 * û�з���ֵ��һ���ݹ鷽��
	 */
	
	public static void  loopShow(Element element) {
		Iterator<Element> iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element next = (Element) iterator.next();
				
			System.out.println(next.getName()+"  "+next.getText());
//***********************************************************************************	
			//��ȡ���Խڵ��list���
			List<Attribute> attributes = next.attributes();
			//ʹ�õ�����
			Iterator<Attribute> iterator2 = attributes.iterator();
			while (iterator2.hasNext()) {
				//��ȡ��ǰ����
				Attribute attribute = (Attribute) iterator2.next();
				System.out.println(attribute.getName()+"   "+attribute.getValue());
			}
//***********************************************************************************			
			loopShow(next);
		}
	}
}
