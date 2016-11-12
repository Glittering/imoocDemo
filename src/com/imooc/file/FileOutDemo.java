package com.imooc.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo {
	/**
	 * src复制一份到dest
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copy(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int b;
		byte[] buff=new byte[8*1024]; 
		while((b=in.read(buff, 0, buff.length))!=-1){
			out.write(buff, 0, b);
			out.flush();
		}
		in.close();
		out.close();
	}
	
	public static void copyFileByBuffer(File srcFile,File desFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件");
		}
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(srcFile));
		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(desFile));
		int d;
		while((d=in.read())!=-1){
			out.write(d);
			out.flush();
		}
		out.close();
		in.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file1 = new File("//home//zhao//下载//20161109-1973463452_tongxunlu.vcf");
		File file2 = new File("//home//zhao//下载//222.txt");
		File file3 = new File("//home//zhao//下载//333.txt");
		Long start = System.currentTimeMillis();
		copyFileByBuffer(file1,file3);
		Long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}

}
