package com.imooc.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
/**
 * 客户端
 * @param args
 * @throws Exception 
 * @throws UnknownHostException 
 */
	public static void main(String[] args) throws UnknownHostException, Exception {
		// TODO Auto-generated method stub
		//1.创建Socket，
		Socket socket = new Socket("localhost",8888);
		//2.获取输出流，
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("用户名：admin---密码：123");
		pw.flush();
		socket.shutdownOutput();
		//3.获取输入流
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info;
		while((info = br.readLine()) != null){
			System.out.println("我是客户端，服务器说:"+info);
		}
		socket.shutdownInput();
		//4.关闭资源
		br.close();
		isr.close();
		is.close();
		pw.close();
		os.close();
		socket.close();
	}

}
