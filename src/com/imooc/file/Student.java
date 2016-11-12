package com.imooc.file;

import java.io.Serializable;

public class Student implements Serializable{
	String num;
	String name;
	String age;
	public Student(){
		
	}
	public Student(String num, String name, String age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", age=" + age + "]";
	}
}
