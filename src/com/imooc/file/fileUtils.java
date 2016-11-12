package com.imooc.file;

import java.io.File;
import java.io.IOException;

public class fileUtils {
	/**
	 * 列出目录内容
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录："+dir+"不存在。");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录。");
		}
		/*String[] s = dir.list();
		for (String string : s) {
			System.out.println(string);
		}*/
		File[] file = dir.listFiles();
		if(file!=null && file.length > 0)
		for (File file2 : file) {
			if(file2.isDirectory()){
				//递归
				listDirectory(file2);
			}else{
				System.out.println(file2);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("//home//zhao");
		try {
			listDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
