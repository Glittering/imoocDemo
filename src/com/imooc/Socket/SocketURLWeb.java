package com.imooc.Socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class SocketURLWeb {
	/**
	 * URL读取网页
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//创建rul实例
		URL url = new URL("http://www.baidu.com");
		//通过openstream获取字节输入流
		InputStream is = url.openStream();
		//转化为字符输入流
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		//为字符输入流增加缓冲
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		while (str!=null){
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
		isr.close();
		is.close();
	}

}
