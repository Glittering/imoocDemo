package com.imooc.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.AttributesImpl;

public class SAXTest {

	public static ArrayList<Book> SAXPaser() throws Exception, Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SAXParserHandler ph = new SAXParserHandler();
		parser.parse("test//books.xml", ph);
		ArrayList<Book> al = ph.getBookList();
		System.out.println("共有" + ph.getBookList().size()+ "本书");
		for (Book book : al) {
			System.out.println(book.getId());
			System.out.println(book.getName());
			System.out.println(book.getAuthor());
			System.out.println(book.getYear());
			System.out.println(book.getPrice());
			System.out.println(book.getLanguage());
		}
		return ph.getBookList();
	}
	
	public static void SAXCreate() throws Exception{
		/*
		 * 创建handle并与文件关联
		 * 核心就是创建以及设置handle
		 */
		ArrayList<Book> al = SAXPaser();
		//创建Handle
		SAXTransformerFactory stff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		TransformerHandler tfh = stff.newTransformerHandler();
		//设置xml格式
		Transformer tf = tfh.getTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		//创建result并与handle关联
		Result result = new StreamResult(new FileOutputStream(new File("test//books2.xml")));
		tfh.setResult(result);
		//创建节点
		tfh.startDocument();
		AttributesImpl atts =new AttributesImpl();
		tfh.startElement("", "", "bookstore", atts);
		for (Book book : al) {			
			atts.clear();
			atts.addAttribute("", "", "id", "", book.getId());
			tfh.startElement("", "", "book", atts);
			atts.clear();
			tfh.startElement("", "", "name", atts);
			tfh.characters(book.getName().toCharArray(), 0, book.getName().length());
			tfh.endElement("", "", "name");
			tfh.endElement("", "", "book");
		}
		tfh.endElement("", "", "bookstore");
		tfh.endDocument();
		
	}
	
	public static void main(String[] args) throws Exception, Exception {
		// TODO Auto-generated method stub
		new SAXTest().SAXCreate();
	}

}
