package com.exproject.exclass;

public class ChildB extends Parnt{

	
	@Override
	public void set(String v) {
		setVelue(v);
		setStaticVelue(v);
	}

	@Override
	public String get() {

		return "ChildB";
	}

}
