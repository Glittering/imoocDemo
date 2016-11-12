package com.imooc.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//创建DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//创建DocunmentBuilder对象
		DocumentBuilder db = dbf.newDocumentBuilder();
		//解析为Document对象
		Document doc = db.parse("test//books.xml");
		//获取所有book节点的集合
		NodeList booklist = doc.getElementsByTagName("book");
		//获取书的长度
		System.out.println("一共有"+booklist.getLength()+"本书");
		//遍历每一个book节点
		for ( int i=0; i<booklist.getLength(); i++){
			System.out.println("==========下面开始遍历第"+(i+1)+"本书的内容==========");
			//通过item(i)方法，获取一个book节点
			Node book = booklist.item(i);
			//获取book节点的所有属性结合
			NamedNodeMap attrs = book.getAttributes();
			System.out.println("第"+(i+1)+"本书共有"+attrs.getLength()+
					"个属性");
			//遍历book的属性
			for(int j=0; j<attrs.getLength(); j++){
				//通过item(index)方法，获取属性
				String name =attrs.item(j).getNodeName();
				String value = attrs.item(j).getNodeValue();
				System.out.println("属性名："+name+"--"+"属性值"+value);
				System.out.println("==========结束遍历遍历第"+(i+1)+"本书的内容==========");
				System.out.println();
			}
//			Element book = (Element) booklist.item(i);
//			System.out.println("id的值为："+book.getAttribute("id"));
//			System.out.println("==========结束遍历遍历第"+(i+1)+"本书的内容==========");
//			System.out.println();
			NodeList childNodes = book.getChildNodes();
			System.out.println("第" + (i+1) + "本书共有" + 
					childNodes.getLength() + "个字节点");
			for (int k=0; k<childNodes.getLength(); k++){
				if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
					System.out.print(childNodes.item(k).getNodeName() + "--");
//					System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
					System.out.println(childNodes.item(k).getTextContent());
				}
			}
		}
	}

}
