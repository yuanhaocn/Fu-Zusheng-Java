package com.domdemo.www;
/**
 * ��ȡ�ĵ���ȫ��
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMDemo2 {
	/*
	 * ��Ƶݹ��ȡ����
	 * 		������������nodeTypeΪ1��node�ڵ�-->��ΪnodeLIst
	 */
	public static void loopNode(NodeList nodeList) {
		 for (int i = 0; i < nodeList.getLength(); i++) {
			  Node node = nodeList.item(i);
			  //�жϽڵ�����
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
		  File file = new File("C:\\Users\\FZS\\eclipse-workspace\\XML����\\src\\com\\domdemo\\www\\Book.xml");
		 //��������XML�õ�һ��dom����ֻ�������涼û��ֵ
		  Document document = db.parse(file);
		  NodeList nodeList = document.getChildNodes();
		  loopNode(nodeList);
	}
}
