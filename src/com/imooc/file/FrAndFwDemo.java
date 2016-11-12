 package com.imooc.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("/home/zhao/下载/hello5",true);
		FileReader fr = new FileReader("/home/zhao/下载/hello");
		int d;
		while ((d=fr.read())!=-1){
			fw.write(d);
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
