package com.syc.xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo1 {

	@SuppressWarnings("unchecked")
	@Test
	public void xmlParse(){
		//XML解析方式:
		//1.SAX解析:是基于事件驱动的解析方式
		//2.DOM解析:dom解析不是事件驱动的解析方式,dom解析会把整个的xml文件
		//一次性加载进内存,然后把整个的xml看成是一个dom树,从根节点往子节点一点点解析.
		//3.PULL解析:是基于事件驱动的解析方式
		
		try {
			//创建SAX解析器
			SAXReader reader=new SAXReader();
			//加载要解析的文件
			Document doc = reader.read(new File("./src/contact.xml"));
			//得到节点迭代器
			Iterator<Node> iterator = doc.nodeIterator();
			while(iterator.hasNext()){
				Node node = iterator.next();
				if(node instanceof Element){
					//判断该节点是否是元素节点
					Element elmt=(Element) node;
					String name = elmt.getName();
					System.out.println("名称:"+name);
				}
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void xmlTest2(){
		try {
			//1.得到SAX解析器
			SAXReader reader=new SAXReader();
			//2.加载要解析的文件
			Document doc = reader.read(new File("./src/contact.xml"));
			//3.从根节点开始进行解析
			Element rootElement = doc.getRootElement();
			findChild(rootElement);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	//找出某个元素节点下的所有子节点
	@SuppressWarnings("unchecked")
	private void findChild(Element element) {
		System.out.println(element.getName());
		Iterator<Node> iterator = element.nodeIterator();
		while(iterator.hasNext()){
			Node node = iterator.next();
			if(node instanceof Element){
				Element elmt=(Element) node;
				//递归
				findChild(elmt);
			}
		}
	}
}
