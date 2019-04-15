package com.domdemo.www;
/**
 * 只能获得documet一层的标签信息，不能获得全部的，要用递归读取，就像打印一个文件目录一样
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMDemo01 {

	public static void main(String[] args) throws Exception {
		  //1.获取DocumentBuilderFactory对象
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  //2.使用工厂获取DocumentBuilder对象
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  //3.构建文件对象 
		  File file = new File("C:\\Users\\FZS\\eclipse-workspace\\XML解析\\src\\com\\domdemo\\www\\Book.xml");
		  //4.使用DocumentBuilder对象处理文档
		  Document document = db.parse(file);
		  //5.获取document下面所有的节点
		  NodeList nodeList = document.getChildNodes();
		  //6.使用for循环处理nodeList
		  for (int i = 0; i < nodeList.getLength(); i++) {
			//7.获取具体的Node对象
			  Node node = nodeList.item(i);
			 //8.获取节点的NodeType nodeName nodeValue
			  short nodeType = node.getNodeType();
			  String nodeName = node.getNodeName();
			  String nodeValue = node.getNodeValue();
			  System.out.println(nodeType+"   "+nodeName+"   "+nodeValue);
		}
	}
}
