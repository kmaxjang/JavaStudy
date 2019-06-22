package com.exproject.exclass;

public class ChildA extends Parnt{

	@Override
	public void set(String v) {
		setVelue(v);
		setStaticVelue(v);
	}

	@Override
	public String get() {		
		return "ChildA";
	}

}
