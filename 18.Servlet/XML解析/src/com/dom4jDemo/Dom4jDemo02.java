package com.dom4jDemo;
/**
 * µ›πÈ∂¡»°xml
 */
import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo02 {

	public static void main(String[] args) throws Exception {
		SAXReader sr = new SAXReader();
		File file=new File("C://Users//FZS//eclipse-workspace//XMLΩ‚Œˆ//src//com//dom4jDemo//Dog.xml");
		Document document = sr.read(file);
		Element root = document.getRootElement();
		System.out.println(root.getNodeType()+"  "+root.getName()+"   "+root.getText());
		loopShow(root);
	}
	public static void  loopShow(Element element) {
		Iterator<Element> iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element next = (Element) iterator.next();
				
			System.out.println(next.getName()+"  "+next.getText());
			loopShow(next);
		}
	}
}
