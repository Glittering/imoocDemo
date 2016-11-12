package com.imooc.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSeriaDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Student stu = new Student("0025","刘晓","22");
		String file = new String("ObjectSerializable.osr");
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));
		oos.writeObject(stu);
		oos.flush();
		Student news = (Student)ois.readObject();
		System.out.println(news);
		ois.close();
		oos.close();
	}

}
