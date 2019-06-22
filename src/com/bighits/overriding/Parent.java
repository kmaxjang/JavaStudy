package com.bighits.overriding;

public class Parent implements Inter {

	public String str = "부모변수";
	private static int count = 0;

	public Parent(String str) {
		this.str = str;
	}

	public String get() {
//    System.out.print("부모 Get메소드>>");
		return str;
	}

	public void set(String str) {
//    System.out.println("부모 Set메소드>> " + this.str + "=>" + str + " 문자추가");
		count++;
		this.str += ("<setP>" + str + count);
	}

	public void call(Inter i) {
		System.out.println("인터페이스 클래스 콜" + ((i instanceof Inter) ? "Inter" : "아님"));
		i.set("interCall>>");
		System.out.println("    변수접근 >>" + i.str);
		System.out.println("    메소드   >>" + i.get());
	}

	public void call(Parent p) {
		System.out.println("페런트클래스 콜" + ((p instanceof Parent) ? "Parent" : "아님"));
		p.set("ParentCall>>");
		System.out.println("    변수접근 >>" + p.str);
		System.out.println("    메소드   >>" + p.get());
	}
}
