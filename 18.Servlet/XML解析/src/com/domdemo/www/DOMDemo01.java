package com.domdemo.www;
/**
 * ֻ�ܻ��documetһ��ı�ǩ��Ϣ�����ܻ��ȫ���ģ�Ҫ�õݹ��ȡ�������ӡһ���ļ�Ŀ¼һ��
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMDemo01 {

	public static void main(String[] args) throws Exception {
		  //1.��ȡDocumentBuilderFactory����
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  //2.ʹ�ù�����ȡDocumentBuilder����
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  //3.�����ļ����� 
		  File file = new File("C:\\Users\\FZS\\eclipse-workspace\\XML����\\src\\com\\domdemo\\www\\Book.xml");
		  //4.ʹ��DocumentBuilder�������ĵ�
		  Document document = db.parse(file);
		  //5.��ȡdocument�������еĽڵ�
		  NodeList nodeList = document.getChildNodes();
		  //6.ʹ��forѭ������nodeList
		  for (int i = 0; i < nodeList.getLength(); i++) {
			//7.��ȡ�����Node����
			  Node node = nodeList.item(i);
			 //8.��ȡ�ڵ��NodeType nodeName nodeValue
			  short nodeType = node.getNodeType();
			  String nodeName = node.getNodeName();
			  String nodeValue = node.getNodeValue();
			  System.out.println(nodeType+"   "+nodeName+"   "+nodeValue);
		}
	}
}
