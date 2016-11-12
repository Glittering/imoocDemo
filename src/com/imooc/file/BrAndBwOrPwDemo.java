package com.imooc.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class BrAndBwOrPwDemo {

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file = new String("/home/zhao/下载/hello");
		String file1 = new String("/home/zhao/下载/hello6");
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(file)));
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(file1)));
		String d;
		while ((d=br.readLine()) != null){
			System.out.println(d);
			bw.write(d);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}

}
