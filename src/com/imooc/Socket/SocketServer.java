package com.imooc.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	/**
	 * 基于tcp协议的socket通信，实现用于登录
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 创建服务端的socket。
		ServerSocket serverSocket = new ServerSocket(8888);
		// 2.调用accept（）
		System.out.println("***服务器即将启动，等待链接***");
		Socket socket = serverSocket.accept();
		// 3.获取输入流
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String info ;
		while ((info = br.readLine()) != null) {
			System.out.println("我是服务器，客户端说：" + info);
		}
		socket.shutdownInput();
		//4.获取输出流
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("Get your issue.");
		pw.flush();
		socket.shutdownOutput();
		//5.关闭资源
		pw.close();
		os.close();
		br.close();
		isr.close();
		is.close();
		socket.close();
		serverSocket.close();
	}

}
