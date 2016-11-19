package com.imooc.Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class SocketInetAddress {

	public static void main(String[] args) throws Exception {
		//获取本机的ip
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("主机名"+address.getHostName());
		System.out.println("IP地址"+address.getHostAddress());
		System.out.println("字节数组形式的IP"+Arrays.toString(address.getAddress()));
		System.out.println(address);
		
		//根据名称获取InetAddress
		InetAddress address2 = InetAddress.getByName("zhao-lenovo-G510");
		System.out.println("主机名"+address2.getHostName());
		System.out.println("IP地址"+address2.getHostAddress());
		System.out.println("字节数组形式的IP"+Arrays.toString(address2.getAddress()));
		System.out.println(address2);
	}

}
