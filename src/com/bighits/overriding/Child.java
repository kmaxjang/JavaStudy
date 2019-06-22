package com.bighits.overriding;

public class Child extends Parent {

	public String str = "자식변수";

	public Child(String str) {
		super("<<parant>>"+str);
		this.str = str;
	}

	public String get() {
		// System.out.print("자식 Get메소드>");
		return str;
	}

	public void set(String str) {
//   System.out.println("자식 Set메소드 "+this.str +"+"+str+" 문자추가");
		this.str += ("<setC>" + str);
	}
}
