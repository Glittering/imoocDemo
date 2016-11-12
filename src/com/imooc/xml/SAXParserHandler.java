package com.imooc.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	private static int count = 0;
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("SAXParse begin....");
		System.out.println();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAXParse shut....");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName == "book"){
//			System.out.println(attributes.getValue("id"));
			count++;
			System.out.println("**********遍历第"+count+"本书开始**********");
			for(int i=0; i<attributes.getLength(); i++){
				System.out.print("第"+(i+1)+"个节点是"+attributes.getQName(i)+"节点值是---");
				System.out.println(attributes.getValue(i));
			}
		}else if(qName != "bookstore"){
			System.out.print("元素"+qName+"的值是---");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(qName.equals("book")){
			System.out.println("**********遍历第"+count+"本书结束**********");
			System.out.println();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String str = new String(ch,start,length);
		if(!str.trim().equals("")){
			System.out.println(str);
		}
		
	}
}
