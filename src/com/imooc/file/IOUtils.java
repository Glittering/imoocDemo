package com.imooc.file;

import java.io.FileInputStream;
import java.io.IOException;

public class IOUtils {

	public static void inputHex(String filePath) throws IOException{
		@SuppressWarnings("resource")
		FileInputStream in = new FileInputStream(filePath);
		int k;
		int i = 1;
		while((k=in.read())!=-1){
			if(k<= 0xf){
				System.out.print(0);
			}
			System.out.print(Integer.toHexString(k)+"  ");
			if(i++%10 ==0){
				System.out.println();
			}
		}
		in.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		inputHex("//home//zhao//文档//111.txt");
	}

}
