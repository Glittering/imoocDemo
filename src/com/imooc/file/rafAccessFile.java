package com.imooc.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class rafAccessFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("test");
		if(!file.exists()){
			file.mkdir();
		}
		File file1 =new File("test.ext");
		if(!file1.exists()){
			file1.createNewFile();
		}
		RandomAccessFile raf = new RandomAccessFile(file1, "rw");
		System.out.println(raf.getFilePointer());
		raf.write('A');
		int i=0xffffffff;
		raf.write(i);
		System.out.println(raf.getFilePointer());
		raf.writeInt(i);
		System.out.println(raf.getFilePointer());
		raf.write(i >> 24);
		raf.write(i >> 16);
		raf.write(i >> 8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		raf.seek(0);
		System.out.println(raf.getFilePointer());
		System.out.println(raf.length());
		byte[] buff = new byte[(int) raf.length()];
		raf.read(buff);
		System.out.println(Arrays.toString(buff));
	}

}
