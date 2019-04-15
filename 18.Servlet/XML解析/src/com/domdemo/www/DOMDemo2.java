package com.domdemo.www;
/**
 * 读取文档的全部
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMDemo2 {
	/*
	 * 设计递归读取数据
	 * 		参数：必须是nodeType为1的node节点-->改为nodeLIst
	 */
	public static void loopNode(NodeList nodeList) {
		 for (int i = 0; i < nodeList.getLength(); i++) {
			  Node node = nodeList.item(i);
			  //判断节点类型
			  if (node.getNodeType()==1) {
				  loopNode(node.getChildNodes());
			}else if(node.getNodeType()==2){
				System.out.println(node.getNodeName()+";"+node.getNodeValue());
			}else {
				System.out.println(node.getNodeValue());
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  File file = new File("C:\\Users\\FZS\\eclipse-workspace\\XML解析\\src\\com\\domdemo\\www\\Book.xml");
		 //解析整个XML得到一个dom树，只不过上面都没有值
		  Document document = db.parse(file);
		  NodeList nodeList = document.getChildNodes();
		  loopNode(nodeList);
	}
}
