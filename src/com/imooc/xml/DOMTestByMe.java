package com.imooc.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMTestByMe {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("test//books.xml");
		NodeList booklist = doc.getElementsByTagName("book");
		System.out.println("总共有"+booklist.getLength()+"本书。");
		System.out.println();
		for (int i=0; i<booklist.getLength(); i++){
//			Node book = booklist.item(i);
//			NamedNodeMap attr = book.getAttributes();
//			for(int j=0; j<attr.getLength(); j++){
//				Node nod = attr.item(j);
//				nod.getNodeName();
//				nod.getNodeValue();
//				System.out.println("第"+i+"本书的，第"+j+"条属性"+nod.getNodeName()
//				+"的值为"+nod.getNodeValue());
//				System.out.println();
//			}
			Element ele = (Element) booklist.item(i);
			String str = ele.getAttribute("id");
			System.out.println(str);
		}
	}

}
