package com.imooc.file;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {

	private static DataOutputStream dos;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file = "test.ext";
		dos = new DataOutputStream(
				new FileOutputStream(file));
		dos.writeInt(10);
		dos.writeUTF("中国");
		dos.close();
	}

}
