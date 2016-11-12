package com.imooc.xml;

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
		
	}

}
