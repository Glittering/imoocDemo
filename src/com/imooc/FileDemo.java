package com.imooc;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("//home//zhao//文档//111.txt");
		if(!file.exists()){
			file.createNewFile();
		}else{
			//file.delete();
			System.out.println(file.getAbsolutePath());
			System.out.println(File.separator);
		}
	}

}
