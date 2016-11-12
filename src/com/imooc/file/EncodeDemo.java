package com.imooc.file;

import java.io.IOException;

public class EncodeDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s = "你好hhh";
		byte[] byte1 = s.getBytes();
		for (byte b : byte1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		System.out.println();

		byte[] byte2 = s.getBytes("gbk");
		for (byte b : byte2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		String byte3 = new String(byte2);
		System.out.println();
		System.out.println(byte3);

		String byte4 = new String(byte2, "gbk");
		System.out.println(byte4);

	}

}
