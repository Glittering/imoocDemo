package com.imooc.xml;

import java.io.File;
import java.io.IOException;

import javax.annotation.Generated;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {
	
	public static DocumentBuilder getDocumentBuilder() throws Exception{
		// 创建DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建DocunmentBuilder对象
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db;
	}

	/**
	 * 解析xml
	 * @throws Exception 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void DOMPaser() throws SAXException, IOException, Exception {
		// 解析为Document对象
		Document doc = getDocumentBuilder().parse("test//books.xml");
		// 获取所有book节点的集合
		NodeList booklist = doc.getElementsByTagName("book");
		// 获取书的长度
		System.out.println("一共有" + booklist.getLength() + "本书");
		// 遍历每一个book节点
		for (int i = 0; i < booklist.getLength(); i++) {
			System.out.println("==========下面开始遍历第" + (i + 1) + "本书的内容==========");
			// 通过item(i)方法，获取一个book节点
			Node book = booklist.item(i);
			// 获取book节点的所有属性结合
			NamedNodeMap attrs = book.getAttributes();
			System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "个属性");
			// 遍历book的属性
			for (int j = 0; j < attrs.getLength(); j++) {
				// 通过item(index)方法，获取属性
				String name = attrs.item(j).getNodeName();
				String value = attrs.item(j).getNodeValue();
				System.out.println("属性名：" + name + "--" + "属性值" + value);
				System.out.println("==========结束遍历遍历第" + (i + 1) + "本书的内容==========");
				System.out.println();
			}
			// Element book = (Element) booklist.item(i);
			// System.out.println("id的值为："+book.getAttribute("id"));
			// System.out.println("==========结束遍历遍历第"+(i+1)+"本书的内容==========");
			// System.out.println();
			NodeList childNodes = book.getChildNodes();
			System.out.println("第" + (i + 1) + "本书共有" + childNodes.getLength() + "个字节点");
			for (int k = 0; k < childNodes.getLength(); k++) {
				if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
					System.out.print(childNodes.item(k).getNodeName() + "--");
					// System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
					System.out.println(childNodes.item(k).getTextContent());
				}
			}
		}
	}

	/**
	 * 生成xml
	 * @throws Exception 
	 */
	public static void DOMCreate() throws Exception{
		//生成节点，结构
		Document document = getDocumentBuilder().newDocument();
		document.setXmlStandalone(true);
		Element bookstore = document.createElement("bookStore");
		Element book = document.createElement("book");
		Element name = document.createElement("name");
		name.setTextContent("小王子");
		book.appendChild(name);
		book.setAttribute("id", "1");
		bookstore.appendChild(book);
		document.appendChild(bookstore);
		//生成xml文件
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.transform(new DOMSource(bookstore), new StreamResult(new File("test//books1.xml")));
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DOMTest test = new DOMTest();
		test.DOMPaser();
		test.DOMCreate();
	}
}
