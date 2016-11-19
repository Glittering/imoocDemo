package com.imooc.Socket;

import java.net.MalformedURLException;
import java.net.URL;

public class SocketURL {
	/**
	 * URLDemo
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL imooc = new URL("http://www.imooc.com");
		//?后边是参数，#后边是锚点
		URL url = new URL(imooc, "/index.html?username=tom#test");
		System.out.println("协议："+url.getProtocol());
		System.out.println("主机:"+url.getHost());
		//未制指定端口号则显示默认端口号
		System.out.println("端口号："+url.getPort());
		System.out.println("文件路径："+url.getPath());
		System.out.println("文件名："+url.getFile());
		System.out.println("相对路径:"+url.getRef());
		System.out.println("查询字符串："+url.getQuery());
		
	}

}
