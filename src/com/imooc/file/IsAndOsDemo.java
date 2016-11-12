package com.imooc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsAndOsDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String url = "/home/zhao/下载/hello";
		InputStreamReader isr = new InputStreamReader(
				new FileInputStream(url));
		url = "/home/zhao/下载/hello1";
		File file = new File(url);
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		/*int d;
		while((d= isr.read())!=-1){
			System.out.print((char)d);
		}*/
		char[] d = new char[8*1024];
		int k;
		while((k=isr.read(d, 0, d.length))!=-1){
			String str = new String(d, 0, k);
			System.out.println(str);
			osw.write(str, 0, k);
			osw.flush();
		}
		isr.close();
		osw.close();
	}

}
