package com.frame;

public class Delay {

	private long start;
	private long keepup = -2000;
	private double fps = 0;
	private int ms;
	
	private double plusms =0;
	private double plusmssum = 0;
	
	private int interval;
	
	public Delay(double fps) {
		this(fps, System.currentTimeMillis());
	}
	
	public Delay(double fps, long start) {
		this(fps, start, false);
	}
	
	public Delay(double fps, long start, boolean sync) {
		this.start = start;
		this.fps = fps;
		
		double time = 1000D/fps;
		int ms = (int)time;
		int ns = (int)((time - ms) * 100000);
		this.ms = ms;
		
		double val = ns * fps;
		interval = (int)(100000 - (val -(int)val/100000 * 100000));
		
		if(interval >= 100000) {
			interval -= 100000;
		}
		if(sync) {
			plusms = interval/ fps;
		}
	}
	
	public void setSyncDelay(boolean istrue) {
		if(istrue) {
			plusms = interval/fps;
		}else {
			plusms = 0;
			plusmssum =0;
		}
	}
	
	public int getMS() {
		return ms;
	}
	
	public int getUpdateMS() {
		plusmssum += plusms;
		if(plusmssum >= 1 || plusmssum <= -1) {
			int delta = (int) plusmssum;
			plusmssum -= delta;
			return delta;
		}
		return 0;
	}
	
	public void setKeepUpTime(long keepuptime) {
		keepup = -Math.abs(keepuptime);
	}
	
	public boolean autoCompute() throws InterruptedException{
		int ms = getRemainMS(start);
		int msplus = getUpdateMS();
		
		start += getMS() + getUpdateMS();
		
		long cal =0;
		if(ms <= keepup) {
			while(getRemainMS(start + cal) <= 0) {
				cal += getMS() + getUpdateMS();
			}
		}
		
		start += cal;
		Delay.sleep(ms + msplus);
		
		return cal != 0;
	}
	
	public double getFPS() {
		return fps;
	}
	
	public static void sleep(int ms, int ns) throws InterruptedException{
		if(ms >0) {
			if(ns > 0) {
				Thread.sleep(ms, ns);
			}else {
				Thread.sleep(ms);
			}
		}else {
			if(ns>0) {
				Thread.sleep(0, ns);
			}
		}
	}
	
	public static void  sleep(int ms) throws InterruptedException{
		if(ms > 0) {
			Thread.sleep(ms);
		}
	}
	
	public int getRemainMS(long start) {
		return (int)(getMS() - (System.currentTimeMillis() - start));
	}
	
	public void setTime(long time) {
		this.start =time;
	}
	
	public long getTime() {
		return start;
	}
	
	
}
