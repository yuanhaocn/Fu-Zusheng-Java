package com.dom4jDemo;
/**
 * 递归+迭代器读取xml属性内容
 * SAXReader就像一个牛逼的大学教授， 不属于任何一家工厂
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
		File file=new File("C:\\Users\\FZS\\eclipse-workspace\\XML解析\\src\\com\\dom4jDemo\\Cat.xml");
		Document document = sr.read(file);
		
		Element root = document.getRootElement();
		System.out.println(root.getNodeType()+"  "+root.getName()+"   "+root.getText());
		loopShow(root);
	}
	/*
	 * 没有返回值的一个递归方法
	 */
	
	public static void  loopShow(Element element) {
		Iterator<Element> iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element next = (Element) iterator.next();
				
			System.out.println(next.getName()+"  "+next.getText());
//***********************************************************************************	
			//获取属性节点的list结合
			List<Attribute> attributes = next.attributes();
			//使用迭代器
			Iterator<Attribute> iterator2 = attributes.iterator();
			while (iterator2.hasNext()) {
				//获取当前属性
				Attribute attribute = (Attribute) iterator2.next();
				System.out.println(attribute.getName()+"   "+attribute.getValue());
			}
//***********************************************************************************			
			loopShow(next);
		}
	}
}
