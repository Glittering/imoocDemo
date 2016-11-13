package com.imooc.xml;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXTest {

	public static void main(String[] args) throws Exception, Exception {
		// TODO Auto-generated method stub
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
	}

}
