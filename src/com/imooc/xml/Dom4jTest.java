package com.imooc.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXWriter;
import org.dom4j.io.XMLWriter;
import org.xml.sax.DocumentHandler;
import org.xml.sax.SAXException;

public class Dom4jTest {

	@SuppressWarnings("unchecked")
	public static void DOM4JParser() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("test/books.xml");
		Element bookstore = document.getRootElement();
		Iterator<Element> books = bookstore.elementIterator();
		while (books.hasNext()) {
			System.out.println("-----开始遍历某一本书-----");
			Element book = books.next();
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attribute : bookAttrs) {
				System.out.println("属性名："+attribute.getName()+"-----属性值："+attribute.getValue());
			}
			Iterator<Element> element = book.elementIterator();
			while ( element.hasNext() ){
				Element ele = element.next();
				System.out.println("节点名："+ele.getName()+"----节点值："+ele.getStringValue());
			}
			System.out.println("-----结束遍历某一本书-----");
		}
	}
	
	public static void DOM4JCreate() throws Exception{
		//创建document
		Document document = DocumentHelper.createDocument();
		//添加rss
		Element rss = document.addElement("rss");
		rss.addAttribute("version", "2.0");
		//生成子节点以及节点内容
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
//		title.addAttribute("id", "11");
		title.setText("国内最新新闻");
		//设置生成格式
		OutputFormat format = OutputFormat.createPrettyPrint();
//		format.setEncoding("gbk");
		//生成xml文件
		XMLWriter writer = new XMLWriter(new FileOutputStream(new File("test//rss.xml")),format);
		writer.write(document);
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DOM4JParser();
		DOM4JCreate();
	}

}
