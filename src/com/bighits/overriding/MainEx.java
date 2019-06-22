package com.bighits.overriding;

public class MainEx {

	public static void inter(Inter i) {
		i.set("Inter접근");
		scr("변수접근 >   " + i.str);
		scr("매소드접근> " + i.get());
	}

	public static void inter(Parent i) {
		i.set("Parent접근");
		scr("변수접근 >   " + i.str);
		scr("매소드접근> " + i.get());
	}

	public static void inter(Child i) {
		i.set("Child접근");
		scr("변수접근 >   " + i.str);
		scr("매소드접근> " + i.get());
	}

	public static void scr(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		// 상속에 따른 변수와 메소드 호출 우선순위
		Inter inter_parent = new Parent("inter_parent");
		Inter inter_child = new Child("inter_child");
		Parent parent_parent = new Parent("parent_parent");
		Parent parent_child = new Child("parent_child");
		Child child = new Child("child");

		scr("****인터페이스 < 부모클래스****");
		inter(inter_parent);
		scr("**********************inter_parent call");
		inter_parent.call(inter_parent);
		inter_parent.call(inter_child);
		inter_parent.call(parent_parent);
		inter_parent.call(parent_child);
		inter_parent.call(child);
		scr("**********************inter_parent call");

		scr("****인터페이스 < 자식클래스****");
		inter(inter_child);
		scr("**********************inter_child call");
		inter_child.call(inter_parent);
		inter_child.call(inter_child);
		inter_child.call(parent_parent);
		inter_child.call(parent_child);
		inter_child.call(child);
		scr("**********************inter_child call");

		scr("****부모클래스 < 부모클래스****");
		inter(parent_parent);
		scr("**********************parent_parent call");
		parent_parent.call(inter_parent);
		parent_parent.call(inter_child);
		parent_parent.call(parent_parent);
		parent_parent.call(parent_child);
		parent_parent.call(child);
		scr("**********************parent_parent call");

		scr("****부모클래스 < 자식클래스****");
		inter(parent_child);
		scr("**********************parent_child call");
		parent_child.call(inter_parent);
		parent_child.call(inter_child);
		parent_child.call(parent_parent);
		parent_child.call(parent_child);
		parent_child.call(child);
		scr("**********************parent_child call");

		scr("****자식클래스****");
		inter(child);
		scr("**********************child call");
		child.call(inter_parent);
		child.call(inter_child);
		child.call(parent_parent);
		child.call(parent_child);
		child.call(child);
		scr("**********************child call");
		
		scr("ip       >>"+inter_parent.get());
		scr("ic       >>"+inter_child.get());
		scr("icsuper>>"+((Parent)inter_child).get());
		scr("pp      >>"+parent_parent.get());
		scr("pc      >>"+parent_child.get());
		scr("pcsuper>>"+((Parent)parent_child).get());
		scr("cc       >>"+child.get());
		scr("ccsuper>>"+((Parent)child).get());
		
	}
}
