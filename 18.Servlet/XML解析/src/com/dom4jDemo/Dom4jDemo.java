package com.dom4jDemo;
/**
 * 直接打印是打印不出里面的，只能打印出根节点的子节点
 */
import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {

	public static void main(String[] args) throws Exception {
		//1.构建SAXReader对象，需要dom4j的jar
		SAXReader sr = new SAXReader();
		//2.使用xml文件构建file对象
		File file=new File("C:\\Users\\FZS\\eclipse-workspace\\XML解析\\src\\com\\dom4jDemo\\Dog.xml");
		//3.使用sexReader对象加载xml
		Document document = sr.read(file);
		//4.获取根节点
		Element root = document.getRootElement();
		System.out.println(root.getNodeType()+"  "+root.getName()+"   "+root.getText());
		//5.获取根节点的迭代器
		Iterator<Element> iterator = root.elementIterator();
		//6.迭代器的遍历
		while (iterator.hasNext()) {
			Element element = (Element) iterator.next();
			//7.获取该节点的nodetype nodename 和nodevalue
			short nodeType = element.getNodeType();
			String name = element.getName();
			String nodeValue = element.getText();
			//8.打印
			System.out.println(nodeType+"   "+name+"   "+nodeValue);
		}
	}

}
