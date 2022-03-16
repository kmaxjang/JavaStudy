package com.exproject.exclass;

public abstract class Parnt {

	private ParntVelue velue = new ParntVelue();
	
	private static ParntVelue staticvelue = new ParntVelue();
	
	public String getVelue() {
		return velue.get();
	}
	
	public String getStaticVelue() {
		return staticvelue.get();
	}
	
	public void setVelue(String v) {
		velue.set(v);
	}
	
	public void setStaticVelue(String v) {
		staticvelue.set(v);
	}	
	
	public void print() {
		System.out.println("Velue "+ velue.get());
		System.out.println("staticVelue "+ staticvelue.get());
	}
	
	public abstract void set(String v);
	public abstract String get();
}
