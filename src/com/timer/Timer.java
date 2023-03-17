package com.timer;

public class Timer {
	
	private long elapsedtime = 3600000*23;
	private long hours =0;
	private long minutes =0;
	private long seconds = 0;
	private long msec =0;
	
	public String getTime() {		
		hours = (elapsedtime/ 3600000);
		minutes = (elapsedtime/ 60000) % 60;
		seconds =(elapsedtime/1000) % 60;
		msec = elapsedtime %1000;
		return String.format("%02d : %02d : %02d (%03d)", hours, minutes, seconds, msec);
	}

	public void setTime() {
		elapsedtime+=1000;
	}
	
	public static void main(String[] args) {
		
		Timer timers = new Timer();
		
		int out =0;
		long realtime = System.currentTimeMillis();
		while(out < 3000) {		
		try {
			realtime = System.currentTimeMillis();
			
			timers.setTime();
			System.out.println(timers.getTime()+"Out "+out);
			out++;
			
			realtime = System.currentTimeMillis()- realtime;			
			if(realtime < out) {
			Thread.sleep(out);
			}
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		}	
		
	}
}
