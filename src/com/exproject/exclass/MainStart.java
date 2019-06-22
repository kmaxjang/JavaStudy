package com.exproject.exclass;

public class MainStart {

	
	Parnt a = new ChildA();
	Parnt b = new ChildB();
	
	public MainStart() {
		
		a.set("에이변수 변경");
		b.set("비변수 변경");
		a.print();
		b.print();
		
	}
	
	public static void main(String[] args) {		
		new MainStart();
	}
}
