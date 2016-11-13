package com.imooc.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDOMTest {
	private static ArrayList<Book> booklist = new ArrayList<Book>();
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		SAXBuilder build = new SAXBuilder();
		Document document = build.build("test/books.xml");
		Element rootElement = document.getRootElement();
		List<Element> childElments = rootElement.getChildren();
		for (Element element : childElments) {
			Book book = new Book();
			System.out.println("----------第"+(childElments.indexOf(element)+1)+"次循环开始----------");
			List<Attribute> attrs = element.getAttributes();
			for (Attribute attribute : attrs) {
				String name = attribute.getName();
				String value = attribute.getValue();
				System.out.println("属性名："+name +"-------值为:"+value);
				if ( name.equals("id")){
					book.setId(value);
				}
			}
			List<Element> childELmentss = element.getChildren();
			for (Element element2 : childELmentss) {
				System.out.println("节点名："+element2.getName() + "-----节点值："+element2.getValue());
				switch (element2.getName()){
				case "name":
					book.setName(element2.getValue());
					break;
				case "author":
					book.setAuthor(element2.getValue());
					break;
				case "year":
					book.setYear(element2.getValue());
					break;
				case "price":
					book.setPrice(element2.getValue());
					break;
				case "language":
					book.setLanguage(element2.getValue());
					break;
				}
			}
			System.out.println("----------第"+(childElments.indexOf(element)+1)+"次循环结束----------");
			System.out.println();
			booklist.add(book);
			System.out.println(booklist.size());
			System.out.println(booklist.get(0).getName());
		}
	}

}
