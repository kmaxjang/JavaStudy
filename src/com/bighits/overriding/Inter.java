package com.bighits.overriding;

public interface Inter {

	public String str = "인터페이스변수";

	public String get();

	public void set(String str);

	public void call(Inter i);

	public void call(Parent p);
}
